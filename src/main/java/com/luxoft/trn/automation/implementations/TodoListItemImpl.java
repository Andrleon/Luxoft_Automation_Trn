package com.luxoft.trn.automation.implementations;

import com.luxoft.trn.automation.interfaces.Toggleable;

public class TodoListItemImpl implements Toggleable {
    private String title;
    private boolean toggled;

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public String getTitle() {
        return title;
    }

    public TodoListItemImpl setTitle(String title) {
        this.title = title;
        return this;
    }

    public TodoListItemImpl(String title) {
        this.title = title;
        this.toggled = false;
    }

    @Override
    public void toggle() {
        toggled = true;
    }
}
