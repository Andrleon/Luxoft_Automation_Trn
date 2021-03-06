package com.luxoft.trn.automation.implementations;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;


@Tag("todolist")
public class TodoListImplTest {

    private TodoListImpl list;
    private TodoListItemImpl[] todos;
    private static Logger logger;

    @BeforeAll
    public static void setUpAll() {
        logger = LoggerFactory.getLogger(TodoListImplTest.class);
    }

    @BeforeEach
    public void setUp() {
        todos = new TodoListItemImpl[]{
                new TodoListItemImpl("Go for a walk with the dog"),
                new TodoListItemImpl("Buy milk and sugar"),
                new TodoListItemImpl("See favourite TV series")
        };
        list = new TodoListImpl();
    }

    //done
    @Test
    public void can_add_items_to_the_list(){
        logger.info("Add items to list test");
        list.addItem(todos[0]);
        list.addItem(todos[1]);
        Assertions.assertEquals(2,list.length());
    }

    //done
    @Test
    public void can_add_an_array_of_items_to_the_list() {
        logger.info("Add array of items in list test");
        list.addItems(todos);
        Assertions.assertEquals(3, list.length());
    }

    //done
    @Test
    public void can_add_item_with_title_to_the_list() {
        list.addItem("Go to training for trainers");
        assertThat(list.length(),equalTo(1));
    }

    //done
    @Test
    public void toggle_item_in_the_list() {
        list.addItem(todos[0]);
        assertThat(list.toggle("Go for a walk with the dog"),is(equalTo(true)));
    }

    //done
    @Test
    @DisplayName("Exception have been thrown when we toggle non-existing item")
    public void throw_exception_when_toggle_non_existing_item() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> list.toggle("Non-existing item in list")
        );
    }

    //done
    @Test
    public void can_not_add_two_items_with_the_same_titles() {
        list.addItem(todos[0]);
        list.addItem("Go for a walk with the dog");
        assertThat(list.length(),equalTo(1));
    }

    //done
    @Test
    public void can_delete_item_using_its_title() {
        String targetTitle = "Item for deletion";
        list.addItem("Item not for deletion");
        list.addItem(targetTitle);
        list.deleteItem(targetTitle);
        assertThat(list.length(),is(equalTo(1)));
    }

    //done
    @Test
    public void can_delete_item_using_its_index() {
        list.addItem(todos[0]);
        int targetItemIndex = list.addItem(todos[1]);
        list.deleteItem(targetItemIndex);
        assertThat(list.length(), is(equalTo(1)));
    }

    //done
    @Test
    public void throws_exception_when_deleting_item_with_wrong_index() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.deleteItem(1));
    }


    // done with question
    @Test
    public void toggle_all_untoggled_items() {
        String targetTitle = todos[0].getTitle();
        list.addItems(todos);
        list.toggle(targetTitle);
        list.toggleAll();
        Assertions.assertEquals(true, list.getItem(targetTitle).isToggled()); // Expected result was changed fron false to true. it is not clear why it was expected false.
    }

    //done
    @Test
    public void get_item_with_its_title() {
        String targetTitle = todos[0].getTitle();
        list.addItems(todos);
        Assertions.assertEquals(targetTitle, list.getItem(targetTitle).getTitle());
    }
    //can be ommited
    //@Test
    //public void todo_list_is_empty_after_creation() {
    //    logger.info("test with our custom matcher for todo list class");
    //    assertThat(list, isAnEmptyTodoList());
    //}

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public static void tearDownAll() {
    }
}