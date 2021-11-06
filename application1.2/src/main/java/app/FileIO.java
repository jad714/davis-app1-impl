/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class FileIO {

    public String filePrep(ItemsList itemsList){
        // Initialize the outputString to null output.
        String outputString = "";
        // Providing the list isn't empty, iterate over each element.
        if(!itemsList.isListEmpty())
        {
            int itemCount = itemsList.getSize();
            for(int i=0;i<itemCount;i++){
                // Add the due date to each line of the output.
                outputString = outputString.concat(itemsList.getItem(i).getDue());
                outputString = outputString.concat(" ");
                // Add the description to each line of the output (remove spaces and replace with "-").
                outputString = outputString.concat(itemsList.getItem(i).getDescription().replace(" ", "-"));
                outputString = outputString.concat(" ");
                // Add the completion status to each line of the output.
                outputString = outputString.concat(itemsList.getItem(i).getCompleted());
                // Skip adding a newline to the last element (this would break the code).
                if(i!=itemCount-1)
                    outputString = outputString.concat("\n");
            }
        }
        // This method should prepare the file's contents for writing as a single string
        // for output into a document.
        return outputString;
    }

    public boolean saveFile(String content, File file){
        try{
            // Create a new instance of the PrintWriter Class to write the output file.
            PrintWriter fileWriter = new PrintWriter(file);
            // Print the content of the to-do list to said file.
            fileWriter.println(content);
            // Close the PrintWriter.
            fileWriter.close();
            return file.exists();
        }
        catch(IOException e)
        {
            // Catch the IOException (if anything went wrong with the FileChooser).
            System.err.println("Unable to write file. Program terminating (REMOVE BEFORE FLIGHT).");
            System.exit(0);
        }
        return false;
    }

    public void loadList(File file, ItemsList itemsList){
        try{
            Scanner fileScanner = new Scanner(file);
            // Loops while there is another line in the file.
            while(fileScanner.hasNextLine()){
                // For each line, scan each string into appropriate variables.
                String[] data = fileScanner.nextLine().split(" ");
                String due = data[0];
                String description = data[1];
                String completed = data[2];
                // Set up a new to-do list item according to what was read from the file.
                Items newItem = new Items(due, description, completed);
                // Add the item to the itemsList.
                itemsList.addItem(newItem);
            }
            fileScanner.close();
        }
        catch(FileNotFoundException e){
            // This absolutely should not happen.
            System.err.println("The file was not found.");
            System.exit(0);
        }
    }
}
