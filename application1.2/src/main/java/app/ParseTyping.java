/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class ParseTyping {

    public Items createItem(String due, String description, String completed){
        return new Items(due, description, completed);
    }
}
