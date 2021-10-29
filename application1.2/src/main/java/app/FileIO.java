/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

public class FileIO {
    // Declare instance variable (String) for the filename.
    public FileIO(){
        // Initialize filename String.
    }

    public String filePrep(){
        // Prepares, according to the Controller for the ListView's focus, a file composed of all of the lists' information and
        // prepares it in a format that can be parsed by the FileReader.
        // Dummy return below.
        return "";
    }

    public boolean saveFile(){
        // This is called by the controller for the "save" button to save the list to a .txt file.
        // Creates the file (try/catch) using the parsed filename from the input text field (already passed to the object).
        // If the file cannot be created, does NOT crash the program but returns instead. Error message will be supplied to user.
        // Returns "false" if file unable to be created. Otherwise, returns "true".
        // This method will currently return "false" to allow program to compile.
        boolean temp = false;
        return false;
    }

    public void specifyFileLocation(){
        // This method uses JavaFX logic to open the Windows Explorer function to allow the user to specify a filepath and filename.
    }

    public void loadList(){
        // Loads the list highlighted in the Saved Lists ListView. Allow only for one file to be selected.
        // Parse the file using logic specified here to convert it to lists in active memory for the application to utilize.
    }
}
