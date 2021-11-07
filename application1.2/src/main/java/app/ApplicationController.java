/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.format.DateTimeFormatter;


import static javafx.geometry.Pos.CENTER;
import static javafx.scene.control.TableColumn.SortType.DESCENDING;

public class ApplicationController {
    // Declare and initialize a few commonly used controls and commonly used values.

    private int pressCount = 0;
    private static final String RED = "#ff0000";
    private static final String GREEN = "#00ff08";
    ItemsList itemsList = new ItemsList();
    FilteredList<Items> filteredItems = new FilteredList<>(itemsList.getList(), p->true);
    SortedList<Items> sortedList = new SortedList<>(filteredItems);

    @FXML
    private RadioButton all;
    @FXML
    private RadioButton completed;
    @FXML
    private RadioButton incomplete;
    @FXML
    private TextField itemDescription = new TextField();
    @FXML
    private DatePicker dueDate;
    @FXML
    private TableView<Items> table = new TableView<>();
    @FXML
    private Label saveLabel;
    @FXML
    private Label emptyListWarningLabel;
    @FXML
    private Label descWarningLabel;
    @FXML
    private TableColumn<Items, String> dueColumn;
    @FXML
    private TableColumn<Items, String> descriptionColumn;
    @FXML
    private TableColumn<Items, String> completedColumn;

    private void rejectInput(String output){
        // Applies the relevant text to the warning label.
        descWarningLabel.setText(output);
        // Changes the text color to red.
        descWarningLabel.setTextFill(Paint.valueOf(RED));
        // Wraps the text for readability and centered look.
        descWarningLabel.setWrapText(true);
        // Aligns the text to center for cleaner appearance.
        descWarningLabel.setAlignment(CENTER);
        // Sets the font to size that fits, but is still readable.
        descWarningLabel.setFont(Font.font(9));
        // Makes the invisible label appear.
        descWarningLabel.setVisible(true);
    }

    private void clearAllWarnings(){
        descWarningLabel.setVisible(false);
        saveLabel.setVisible(false);
        emptyListWarningLabel.setVisible(false);
    }

    @FXML
    private void addItemToListPressed(ActionEvent event){
        // Consumes the event.
        event.consume();
        this.clearAllWarnings();
        // Declare inputItemDesc variable.
        String inputItemDesc;
        // Instantiate ParseTyping object.
        ParseTyping typeCheck = new ParseTyping();
        // The item description becomes whatever was typed in the input box.
        inputItemDesc = itemDescription.getText();
        // Handle potential error cases (including empty date field and empty description box).
        if(!typeCheck.validateDescription(inputItemDesc)){
            this.rejectInput("Invalid description (see readme)!");
            return;
        }
        // Create the new item associated, and append it to the ItemsList.
        Items newItem;
        if(dueDate.getValue()!=null){
            newItem = new Items(dueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), itemDescription.getText(), "No");
        }
        else{
            newItem = new Items("", itemDescription.getText(), "No");
        }
        itemsList.addItem(newItem);
        // Give positive feedback to the user confirming the item was added.
        descWarningLabel.setText("Item added!");
        descWarningLabel.setTextFill(Paint.valueOf(GREEN));
        descWarningLabel.setWrapText(true);
        descWarningLabel.setAlignment(CENTER);
        descWarningLabel.setVisible(true);
        // Clear the values from itemDescription text box and due date DatePicker.
        itemDescription.clear();
        dueDate.setValue(null);
    }

    @FXML
    private void saveAsButtonPressed(ActionEvent event){
        event.consume();
        this.clearAllWarnings();
        // Abort if the list is empty.
        if(itemsList.isListEmpty()){
            saveLabel.setAlignment(CENTER);
            saveLabel.setTextFill(Paint.valueOf(RED));
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
        // Provide positive user feedback letting them know the file was saved successfully.
        saveLabel.setAlignment(CENTER);
        saveLabel.setVisible(true);
        saveLabel.setTextFill(Paint.valueOf(GREEN));
        saveLabel.setText("File Saved!");
    }

    @FXML
    private void emptyListButtonPressed(ActionEvent event){
        // The first time this is clicked, a warning should appear.
        // The second time it is clicked, it will carry out the instructions.
        // Given the amount of work that could be lost, this is key.
        event.consume();
        this.clearAllWarnings();
        pressCount++;
        if(pressCount<2){
            emptyListWarningLabel.setTextFill(Paint.valueOf(RED));
            emptyListWarningLabel.setAlignment(CENTER);
            emptyListWarningLabel.setWrapText(true);
            emptyListWarningLabel.setFont(Font.font(9));
            emptyListWarningLabel.setText("WARNING! This will delete all items associated with your to-do list. If you're sure this is" +
                    " what you want, please click the button above again.");
            emptyListWarningLabel.setVisible(true);
            return;
        }
        // An empty list can't be deleted, so only actually delete if it's possible to do so.
        if(!itemsList.isListEmpty()){
            itemsList.deleteList();
            emptyListWarningLabel.setTextFill(Paint.valueOf(GREEN));
            emptyListWarningLabel.setAlignment(CENTER);
            emptyListWarningLabel.setText("List deleted!");
        }
        else{
            emptyListWarningLabel.setTextFill(Paint.valueOf(RED));
            emptyListWarningLabel.setAlignment(CENTER);
            emptyListWarningLabel.setText("Cannot delete an empty list!");
        }
        emptyListWarningLabel.setVisible(true);
        pressCount = 0;
    }

    @FXML
    private void editSelectedItemPressed(ActionEvent event){
        event.consume();
        this.clearAllWarnings();
        ParseTyping typeCheck = new ParseTyping();
        // Ensure that the user has selected an item within the table.
        if(table.getSelectionModel().isEmpty()){
            rejectInput("Nothing selected!");
            return;
        }
        // Do not allow edits to an empty list.
        if(itemsList.isListEmpty()){
            rejectInput("List cannot be empty!");
        }
        // Enforce description requirements (tested in ParseTypingTest).
        if(!typeCheck.validateDescription(itemDescription.getText())){
            this.rejectInput("Invalid Description (see readme)!");
            return;
        }
        // Edit the selected value according to what is typed in the boxes (relies on setters in Items).
        int index = table.getSelectionModel().getSelectedIndex();
        Items item = new Items("", "", table.getSelectionModel().getSelectedItem().getCompleted());
        if(dueDate.getValue()!=null){
            item.setDue(dueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        item.setDescription(itemDescription.getText());
        itemsList.setItem(index, item);
        // Clear the values in the boxes for the next entry.
        itemDescription.clear();
        dueDate.setValue(null);
    }

    @FXML
    private void deleteItemButtonPressed(ActionEvent event){
        event.consume();
        this.clearAllWarnings();
        // Just ignore button press if list is empty, or if nothing selected.
        if(table.selectionModelProperty().getValue().isEmpty())
            return;
        if(itemsList.isListEmpty()){
            return;
        }
        // Otherwise, delete the item at the selected point.
        int index = table.getSelectionModel().getSelectedIndex();
        itemsList.removeItem(index);
    }

    @FXML
    private void markCompleteButtonPressed(ActionEvent event){
        // Mark selected item complete if incomplete. Otherwise ignore press.
        // Note: This method does not contain any unique method functionality. Rather, it uses other tested methods to accomplish its task.
        event.consume();
        this.clearAllWarnings();
        if(table.selectionModelProperty().getValue().isEmpty())
            return;
        int index = table.selectionModelProperty().getValue().getSelectedIndex();
        Items editedItem = new Items("", "", "Yes");
        editedItem.setDue(table.getSelectionModel().getSelectedItem().getDue());
        editedItem.setDescription(table.getSelectionModel().getSelectedItem().getDescription());
        itemsList.setItem(index, editedItem);
    }

    @FXML
    private void markIncompleteButtonPressed(ActionEvent event){
        // Mark selected item incomplete if marked incomplete. Otherwise, ignore press.
        // Note: This method does not contain any unique method functionality. Rather, it uses other tested methods to accomplish its task.
        event.consume();
        this.clearAllWarnings();
        if(table.selectionModelProperty().getValue().isEmpty())
            return;
        int index = table.selectionModelProperty().getValue().getSelectedIndex();
        Items editedItem = new Items("", "", "No");
        editedItem.setDue(table.getSelectionModel().getSelectedItem().getDue());
        editedItem.setDescription(table.getSelectionModel().getSelectedItem().getDescription());
        itemsList.setItem(index, editedItem);
    }

    @FXML
    private void loadButtonPressed(ActionEvent event){
        // Updates Items List with selected list from specified filepath into list view (limit 1 at a time).
        event.consume();
        this.clearAllWarnings();
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
            // Clear the current list from RAM if loading a new list.
            if(!itemsList.isListEmpty()){
                itemsList.deleteList();
            }
            load.loadList(file, itemsList);
        }
    }

    @FXML
    public void radioButtons(ActionEvent event){
        // Sets the appropriate filter predicate depending on the selection of each radio button..
        // The functionality of these filters depend on my item getters, which are tested in ItemsTest.
        if(all.isSelected()){
            // All items will populate if "all" is active.
            filteredItems.setPredicate(items-> true);
        }
        else if(completed.isSelected()){
            // Only completed items will populate if "completed" is active.
            filteredItems.setPredicate(items-> items.getCompleted().equals("Yes"));
        }
        else if(incomplete.isSelected()){
            // Only incomplete items will populate if "incomplete" is active.
            filteredItems.setPredicate(items-> items.getCompleted().equals("No"));
        }
    }

    public void initialize() {
        // Initialize all values and controls that the UI will need to launch properly.
        dueColumn.setCellValueFactory(new PropertyValueFactory<>("due"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        completedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));
        table.setPlaceholder(new Label("No items to display...add something!"));
        table.setItems(sortedList);
        dueColumn.setSortType(DESCENDING);
        table.setFixedCellSize(Region.USE_COMPUTED_SIZE);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
    }
}
