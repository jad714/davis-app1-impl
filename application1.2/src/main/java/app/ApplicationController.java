/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import static javafx.geometry.Pos.CENTER;

public class ApplicationController {
    // Will declare and initialize each control on an individual basis
    // to provide logic to the application.

    // Note that currently, the app has some disabled buttons
    // and text boxes.  This is by design, so that they can be activated
    // when there is something for them to operate on.
    private int pressCount = 0;
    private final String red = "#ff0000";
    private final String green = "#00ff08";
    ItemsList itemsList = new ItemsList();
    @FXML
    private Button emptyList;
    @FXML
    private Button saveAs;
    @FXML
    private Button loadList;
    @FXML
    private Button markComplete;
    @FXML
    private Button unMarkComplete;
    @FXML
    private Button delete;
    @FXML
    private TextField itemDescription;
    @FXML
    private DatePicker dueDate;
    @FXML
    private TextField itemName;
    @FXML
    private TableView<ObservableList<Items>> table;
    @FXML
    private Label saveLabel;
    @FXML
    private Label warningLabel;

    @FXML
    private void saveAsButtonPressed(ActionEvent event){
        event.consume();
        // Abort if the list is empty.
        if(itemsList.isListEmpty()){
            saveLabel.setAlignment(CENTER);
            saveLabel.setTextFill(Paint.valueOf(red));
            saveLabel.setVisible(true);
            saveLabel.setText("Cannot save an empty list!");
            return;
        }
        FileIO save = new FileIO();
        // Get the content for the output from here.
        String content = save.filePrep(itemsList);
        // Creates the stage for the FileChooser to exist on.
        Stage saveStage = new Stage();
        // Create a new FileChooser instance.
        FileChooser fileChooser = new FileChooser();
        // Apply an extension filter to the FileChooser instance (.txt)
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("(*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        // Show the save dialogue. Using pre-existing functionality, this will use native OS's file chooser dialogue
        // to select the directory path and output to correct file extension.
        File file = fileChooser.showSaveDialog(saveStage);
        // Providing a directory was specified, call the saveFile method of FileIO to save.
        if(file!=null){
            save.saveFile(content, file);
        }
        saveLabel.setAlignment(CENTER);
        saveLabel.setVisible(true);
        saveLabel.setTextFill(Paint.valueOf(green));
        saveLabel.setText("File Saved!");
    }

    @FXML
    private void emptyListButtonPressed(ActionEvent event){
        // The first time this is clicked, a warning should appear.
        // The second time it is clicked, it will carry out the instructions.
        // Given the amount of work that could be lost, this is key.
        event.consume();
        pressCount++;
        if(pressCount<2){
            warningLabel.setTextFill(Paint.valueOf(red));
            warningLabel.setAlignment(CENTER);
            warningLabel.setWrapText(true);
            warningLabel.setFont(Font.font(10));
            warningLabel.setText("WARNING! This will delete all items associated with your to-do list. If you're sure this is" +
                    " what you want, please click the button above again.");
            warningLabel.setVisible(true);
            return;
        }
        if(!itemsList.isListEmpty()){
            itemsList.deleteList();
            warningLabel.setTextFill(Paint.valueOf(green));
            warningLabel.setAlignment(CENTER);
            warningLabel.setText("List deleted!");
            warningLabel.setVisible(true);
        }
        else{
            warningLabel.setTextFill(Paint.valueOf(red));
            warningLabel.setAlignment(CENTER);
            warningLabel.setText("Cannot delete an empty list!");
            warningLabel.setVisible(true);
        }
        pressCount = 0;
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
    private void loadButtonPressed(ActionEvent event){
        // Updates Items List with selected list from specified filepath into list view (limit 1 at a time).
        event.consume();
        // Instantiate new FileIO object.
        FileIO load = new FileIO();
        // Create the stage that the load FileChooser will be placed on.
        Stage loadStage = new Stage();
        // Create a new FileChooser with a (*.txt) extension filter.
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("(*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        // Open up the open dialog for the FileChooser.
        File file = fileChooser.showOpenDialog(loadStage);
        // Assuming this file wasn't null, (NOTE: As long as the file is .txt, this will be the case,
        // nothing in project requirements dictated checking for user trying to load in inappropriate .txt files.),
        // call the load list method in FileIO.
        if(file!=null){
            load.loadList(file, itemsList);
        }
    }

    @FXML
    private void deleteItemButtonPressed(ActionEvent event){
        event.consume();
        /* Retrieve the index number from the table here. */
        int index = 0; // default (REMOVE BEFORE FLIGHT).
        // delete the item at that index.
        try{
            itemsList.removeItem(index);
        }
        catch(NullPointerException e){
            // Only prints error to console. User should quickly
            // realize that they've tried to delete from an empty list visually.
            System.err.println("List is empty.");
        }
    }

    @FXML
    private void tableViewBehavior(){
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
