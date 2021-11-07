/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {
    Items testItem = new Items("1999-01-01", "Y2K", "No");

    @Test
    void setDueTest() {
        // Set up an assertion that validates that items have changed corresponding to the values passed.
        testItem.setDue("2000-01-01");
        assertEquals("2000-01-01", testItem.getDue());
    }

    @Test
    void setDescriptionTest() {
        // Set up an assertion that validates that description has changed due to corresponding method correctly.
        testItem.setDescription("Never mind, we survived.");
        assertEquals("Never mind, we survived.", testItem.getDescription());
    }

    @Test
    void getDueTest(){
        // Assert that the correct value is returned from the getter.
        assertEquals("1999-01-01", testItem.getDue());
    }

    @Test
    void getDescriptionTest(){
        // Assert that the correct value is returned from the getter.
        assertEquals("Y2K", testItem.getDescription());
    }

    @Test
    void getCompletedTest(){
        // Assert that the correct value is returned from the getter.
        assertEquals("No", testItem.getCompleted());
    }
}