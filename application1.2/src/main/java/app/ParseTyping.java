/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class ParseTyping {

    public boolean validateDescription(String text){
        // Enforces between 1-256 characters bounds.
        return text.length() >= 1 && text.length() <= 256;
    }

    public Items createItem(String due, String description, String completed){
        return new Items(due, description, completed);
    }
}
