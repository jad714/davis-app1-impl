/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class AddDeleteItem {
    // Declare String name.
    // Declare String due.
    // Declare String description.
    // Declare the List of String arrays in question.
    // Declare index int
    // Declare boolean value for completion status.
    public AddDeleteItem(String name, String due, String description, int index){
        // Initialize all instance variables with passed arguments for each object of AddDeleteItem.
        // The index will be used either for the variable to be added or deleted, as may be required by the user.
        // The idea here is that the index will be given by the actively highlighted object of the code at the time of button press.
    }

    public String[] AddItem(){
        // Using the passed instance variables (to the class), add the item to the list.
        // This is a temporary String array for the purposes of simply running the program.
        String[] temp = {""};
        return temp;
    }

    public void removeItem(){
        // Remove the item with the specified index from the list.
    }

    public boolean getComplete(){
        // Gets the complete / incomplete status of the given list item.
        // The dummy value below allows the skeleton to compile, and has no bearing on the final product.
        boolean temp = false;
        return temp;
    }

    public String getDue(){
        // Returns the due date for the given item.
        // temporary dummy below
        return "";
    }

    public String getName(){
        // Returns the name for the given item.
        return "";
    }

    public String getDescription(){
        // Returns the description for the given item.
        return "";
    }
}
