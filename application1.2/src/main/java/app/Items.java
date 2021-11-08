/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class Items {

    // Declare instance fields.
    private String due;
    private String description;
    private final String completed;

    public Items(String due, String description, String completed){
        // Initialize instance fields.
        this.due = due;
        this.description = description;
        this.completed = completed;
    }
    // Getters and setters below, nothing interesting.

    public void setDue(String edit){
        this.due = edit;
    }

    public void setDescription(String edit){
        this.description = edit;
    }

    public String getDue(){
        return this.due;
    }

    public String getDescription(){
        return this.description;
    }

    public String getCompleted(){
        return this.completed;
    }
}
