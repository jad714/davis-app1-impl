/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */


package app;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {
    File testDir;
    static ItemsList itemsListTest = new ItemsList();



    public String readFile(File testFile){
        // Attempt to read the file, line by line.
        try{
            Scanner fileIO = new Scanner(testFile);
            String contents = "";
            while(fileIO.hasNextLine()){
                contents = fileIO.nextLine();
            }
            fileIO.close();
            return contents;
        }
        // Return "error" if unable to read. This should cause saveFileTest to fail.
        catch(FileNotFoundException e){
            System.err.println("Could not locate file!");
            return "error";
        }
    }

    public File createFile(){
        testDir = new File("test_data/");
        testDir.mkdir();
        File testFile = new File("test_data/test_doc.txt");
        try{
            PrintWriter writer = new PrintWriter(testFile);
            writer.println("2021-12-31 test_item Yes");
            writer.close();
            return testFile;
        }
        catch(FileNotFoundException e){
            System.err.println("Test will fail do to File Not Found.");
        }
        return null;
    }

    @Test
    void filePrepTest() {
        // Instantiate new test object for FileIO Class.
        FileIO fileIOTest = new FileIO();
        // Create the output string for comparison.
        String outputStringTest = "1111-01-01 test_test_test_test No\n2222-02-02 test_test_test Yes";
        // Instantiate new object of ItemsList.
        ItemsList itemsListTest = new ItemsList();
        // Create two test items and add them to the test list..
        Items testItem1 = new Items("1111-01-01", "test test test test", "No");
        Items testItem2 = new Items("2222-02-02", "test test test", "Yes");
        itemsListTest.addItem(testItem1);
        itemsListTest.addItem(testItem2);
        // Create an assertion that tests that the example string created here is the result of breaking down the item in filePrep.
        assertEquals(outputStringTest, fileIOTest.filePrep(itemsListTest));
    }

    @Test
    void saveFileTest() {
        FileIO fileIOTest = new FileIO();
        // Verify the existence of a file matching the name supplied.
        // Since the method is mostly self-testing this can be done according to its returned
        // boolean value, and separately by ensuring the data copied is correct.
        File testDir = new File("test_data/");
        testDir.mkdir();
        File testFile = new File("test_data/HelloWorld.txt");
        // Write the String to a file, creating a new one. Ensure method returns true with assertion.
        assertTrue(fileIOTest.saveFile("Hello World", testFile));
        // Read the just created test file to ensure it copied the information correctly.
        String fileContent = this.readFile(testFile);
        // Use another assertion to ensure the read string and the example string are equal.
        assertEquals("Hello World", fileContent);
        // Delete these files (don't pollute the directory with unnecessary things).
        testFile.delete();
        testDir.delete();
    }

    @Test
    void loadFileTest(){
        // Instantiate new fileIO object.
        FileIO fileIOTest = new FileIO();
        // Call the createFile method within the test class to build our test file (one line).
        File testFile = this.createFile();
        // Create a new Items list for testing.
        ItemsList itemsListTestCompare = new ItemsList();
        // Create a new Item to store the item listed on the file created by the above method.
        Items itemTest = new Items("2021-12-31", "test item", "Yes");
        // Add the item to the test list.
        itemsListTestCompare.addItem(itemTest);
        // Call the (void) method to load the created test list.
        fileIOTest.loadList(testFile, itemsListTest);
        // Run assertions to ensure the data was copied in correctly.
        assertEquals(itemsListTestCompare.getItem(0).getDue(), itemsListTest.getItem(0).getDue());
        assertEquals(itemsListTestCompare.getItem(0).getDescription(), itemsListTest.getItem(0).getDescription());
        assertEquals(itemsListTestCompare.getItem(0).getCompleted(), itemsListTest.getItem(0).getCompleted());
        // Delete the test files to clean up the directory.
        testFile.delete();
        testDir.delete();
    }
}