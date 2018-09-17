package com.luxoft.trn.automation.implementations;

import com.luxoft.trn.automation.interfaces.Toggleable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoListItemImpl implements Toggleable {
    private String title;
    private String shortDescription;
    private boolean toggled;
    private LocalDateTime dueDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy");

    public boolean isToggled() {
        return toggled;
    }

    public void setDueDate(String dueDate) {
        checkDate(dueDate);
        this.dueDate = LocalDateTime.parse(dueDate, formatter);
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return title;
    }

    public TodoListItemImpl setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException();
        this.title = title;
        return this;
    }

    public TodoListItemImpl(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException();
        this.title = title;
        this.toggled = false;
    }

    public TodoListItemImpl(String title, String dueDate)  {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title should be filled.");
        checkDate(dueDate);
        this.dueDate = LocalDateTime.parse(dueDate, formatter);
        this.title = title;
        this.toggled = false;
    }

    private void checkDate(String dueDate){
        if (LocalDateTime.parse(dueDate, formatter).isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Due date is in the past.");
    }

    @Override
    public void toggle() {
        toggled = !toggled;
    }
}
