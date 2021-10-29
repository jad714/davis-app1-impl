/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.awt.*;

public class ApplicationController {
    // Will declare and initialize each control on an individual basis
    // to provide logic to the application.

    // Note that currently, the app has some disabled buttons
    // and text boxes.  This is by design, so that they can be activated
    // when there is something for them to operate on.
    @FXML
    private TextField itemDescription;
    @FXML
    private TextField dueDate;
    @FXML
    private TextField itemName;
    @FXML
    private void newEmptyListButtonPressed(){
        // If the newListName field contains text, create new item.
        // Else, ignore button press (possibly disable button, we'll see).
    }
    @FXML
    private void saveAsButtonPressed(){
        // Calls the saveFile method from FileIO class and generates a .txt of
        // all of the combined files according to the file specified by the user
        // using the Windows Explorer system (or any local system, if possible).
    }

    @FXML
    private void saveButtonPressed(){
       // Saves the file according to its previously selected filename.
    }

    @FXML
    private void editSelectedButtonPressed(){
        // Renames the file highlighted in the grid pane to that specified in "Edit Selected" text field.
    }

    @FXML
    private void viewAllButtonPressed(){
        // Populates all items in the list view.
    }

    @FXML
    private void viewCompletedButtonPressed(){
        // Populates all items that have been completed ONLY in the list view.
    }

    @FXML
    private void viewIncompleteButtonPressed(){
        // Populates all items that have NOT been completed in the list view.
    }

    @FXML
    private void loadButtonPressed(){
        // Populates selected list from specified filepath into list view (limit 1 at a time).
    }

    @FXML
    private void newListButtonPressed(){
        // Calls FormatList's clearList function on press.
    }

    @FXML
    private void deleteItemButtonPressed(){
        // If the delete item button below the bottom GridPane is pressed,
        // the item that is highlighted is deleted from the list (AddDeleteItem's removeItem method),
        // and the information is removed from the GridPane (several cases of repositioning will need to be
        // accounted for if GridPane functionality does not comply).
    }

    private void lowerTable(){
        // Specifies the behavior of the lower grid (active list), which populates
        // a grid displaying each of the Strings (and one boolean value) that will relate
        // to the active list in question. Highlighted items can be deleted, thier contents edited,
        // (either from within the window or using the specified buttons, this remains to be seen),
        // and new items can be added using the "New Item Options" button and fields on the side.
    }

    public void initialize(){
        // I believe everything in here will be initialized to null values in my case,
        // but since I'm not sure, I will leave this until implementation.
    }
}
