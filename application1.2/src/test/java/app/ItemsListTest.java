/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsListTest {
    ItemsList itemsListFullTest = new ItemsList();
    Items newYearTest = new Items("0000-01-01", "The first new year in AD", "Yes");
    Items halloweenTest = new Items("2021-10-31", "too late to drop", "No");
    ItemsList itemsListEmptyTest = new ItemsList();
    public ItemsListTest(){
        itemsListFullTest.addItem(newYearTest);
        itemsListFullTest.addItem(halloweenTest);
    }

    @Test
    void addItemTest(){
        // Create a test item to add to the list.
        Items testItem = new Items("0101-05-01", "This has been a rewarding experience", "No");
        // Add the item to the list.
        itemsListFullTest.addItem(testItem);
        // The item should now be at index 2 given the other test items added.
        assertEquals(testItem, itemsListFullTest.getItem(2));
    }

    @Test
    void removeItemTest() {
        // Test that the list shrinks by one when item removed.
        itemsListFullTest.removeItem(1);
        // Assert that the size of the itemsList has been reduced by one.
        assertEquals(1, itemsListFullTest.getList().size());
        // Assert that the item at index 0 is the newYearTest object (first created, Halloween should be gone).
        assertEquals(newYearTest, itemsListFullTest.getItem(0));
    }

    @Test
    void deleteList() {
        // Delete ItemsListFullTest.
        itemsListFullTest.deleteList();
        // Assert that it is, in fact, empty.
        assertTrue(itemsListFullTest.isListEmpty());
        assertEquals(0,itemsListFullTest.getList().size());
    }

    @Test
    void isListEmpty() {
        // Assert that itemsListEmptyTest (which is an empty list) is empty.
        assertTrue(itemsListEmptyTest.isListEmpty());
    }

    @Test
    void getItemTest(){
        // Assert that the correct object is returned from this method.
        assertEquals(halloweenTest, itemsListFullTest.getItem(1));
    }

    @Test
    void setItemTest(){
        // Assert that setting an item at an index results in the correct changes.
        itemsListFullTest.setItem(0, halloweenTest);
        assertEquals(halloweenTest, itemsListFullTest.getItem(0));
    }

    @Test
    void getSizeTest(){
        // Assert that the correct size is returned by the getSize function (by comparing to java's .size() method for ObservableList).
        assertEquals(itemsListFullTest.getList().size(), itemsListFullTest.getSize());
        assertEquals(itemsListEmptyTest.getList().size(), itemsListEmptyTest.getSize());
    }

    @Test
    void getListTest(){
        // Assert that the correct list is returned when getList is run. Do this by testing that a value from that list is correct.
        assertEquals("too late to drop", itemsListFullTest.getList().get(1).getDescription());
    }
}