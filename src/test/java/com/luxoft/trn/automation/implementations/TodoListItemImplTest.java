package com.luxoft.trn.automation.implementations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TodoListItemImplTest {
    private TodoListItemImpl item;
    private String title = "Todo list item for test";
    private String newTitle = "Todo list item for test with changed title";

    @BeforeEach
    void setUp() {
        item = new TodoListItemImpl(title);
    }

    // done
    @Test
    void itemIsNotNullAfterCreation() {
        assertNotNull(item);
    }

    // done
    @Test
    void itemHasTitleAfterCreation() {
        assertEquals(title, item.getTitle());
    }

    // done
    @Test
    void itemsTitleIsChangedAfterAssignmentOfNewTitle() {
        item.setTitle(newTitle);
        assertEquals(newTitle, item.getTitle());
    }

    //done
    @Test
    public void toogle_an_item() {
        item.toggle();
        Assertions.assertTrue(item.isToggled());
    }

    @Test
    public void untoggle_an_item() {
        item.toggle();
        item.toggle();
        Assertions.assertFalse(item.isToggled());
    }

    @Test
    public void item_is_not_toggled_after_creation() {
        Assertions.assertFalse(item.isToggled());
    }

    @Test
    public void item_have_title() {
        Assertions.assertEquals("Todo item for test", item.getTitle());
    }

    @Test
    public void cannot_create_item_with_empty_title() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TodoListItemImpl(""));
    }

    //done
    @Test
    public void can_set_new_title() {
        TodoListItemImpl newItem = item.setTitle(newTitle);
        Assertions.assertEquals(newTitle, newItem.getTitle());
    }

    @Test
    public void cannot_set_empty_title() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> item.setTitle(""));
    }


    @AfterEach
    void tearDown() {

    }

}
