/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class Items {

    private String due;
    private String description;
    private String completed;

    public Items(String due, String description, String completed){
        this.due = due;
        this.description = description;
        this.completed = completed;
    }

    public void setDue(String edit){
        this.due = edit;
    }

    public void setDescription(String edit){
        this.description = edit;
    }

    public void markComplete(){
        this.completed = "Yes";
    }

    public void markIncomplete(){
        this.completed = "No";
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
