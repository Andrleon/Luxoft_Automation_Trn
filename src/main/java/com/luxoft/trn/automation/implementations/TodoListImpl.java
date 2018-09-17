package com.luxoft.trn.automation.implementations;

import java.util.ArrayList;

public class TodoListImpl {
    private ArrayList<TodoListItemImpl> todoList = new ArrayList<>();

    public int length() {
        return todoList.size();
    }

    public void addItem(String todoTitle) {
        if (!isDuplicatedTitle(todoTitle))
        todoList.add(new TodoListItemImpl(todoTitle));
    }

    public int addItem(TodoListItemImpl todo) {
        if (!isDuplicatedTitle(todo.getTitle()))
        todoList.add(todo);
        return todoList.size() - 1;
    }

    public void addItems(TodoListItemImpl[] todos) {
        for (TodoListItemImpl item : todos){
            todoList.add(item);
        }
    }

   /* public boolean toggle(String s) {
        int index = getItemsIndexByTitle(s);
        todoList.get(index).toggle();
        return todoList.get(index).isToggled();
    }
*/
    public boolean toggle(String s) {
        TodoListItemImpl item = getItemByTitle(s);
        item.toggle();
        return todoList.get(todoList.indexOf(item)).isToggled();
    }


    public void deleteItem(int targetItemIndex) {
        todoList.remove(targetItemIndex);

    }

    public void deleteItem(String targetTitle) {
        todoList.remove(getItemsIndexByTitle(targetTitle));

    }

    public void toggleAll() {
        for (TodoListItemImpl item : todoList){
            if (!item.isToggled())
                item.toggle();
        }

    }

    public TodoListItemImpl getItem(String targetTitle) {
        for(TodoListItemImpl item : todoList){
            if (item.getTitle().equals(targetTitle))
                return item;
        }
        return null;
    }


    private boolean isDuplicatedTitle(String title){
        for (TodoListItemImpl item : todoList){
            if (item.getTitle().equals(title))
                return true;
        }
        return false;
    }

    private int getItemsIndexByTitle(String title){
        int index = 0;
        for(TodoListItemImpl item :todoList ){
            if (item.getTitle().equals(title))
                return index;
            index++;
        }
        return -1;
    }

    private TodoListItemImpl getItemByTitle(String title){
        for(TodoListItemImpl item :todoList ){
            if (item.getTitle().equals(title))
                return item;
        }
        return null;
    }

}
