/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class ParseTyping {

    public boolean validateDescription(String text){
        // Enforces between 1-256 characters bounds and no "-" character (for save file formatting).
        return text.length() >= 1 && text.length() <= 256 && !text.contains("-");
    }
}
