package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsListTest {
    ItemsList itemsListFullTest = new ItemsList();
    Items christmasTest = new Items("0000-01-01", "Jesus born", "Yes");
    Items halloweenTest = new Items("10-31-2021", "too late to drop", "No");
    ItemsList itemsListEmptyTest = new ItemsList();
    public ItemsListTest(){
        itemsListFullTest.addItem(christmasTest);
        itemsListFullTest.addItem(halloweenTest);
    }

    @Test
    void addItem() {
    }

    @Test
    void removeItem() {
    }

    @Test
    void deleteList() {
        // Delete ItemsListFullTest.
        itemsListFullTest.deleteList();
        // Assert that it is, in fact, empty.
        assertTrue(itemsListFullTest.isListEmpty());
    }

    @Test
    void getItem() {
    }

    @Test
    void getSize() {
    }

    @Test
    void isListEmpty() {
        // Assert that itemsListEmptyTest (which is an empty list) is empty.
        assertTrue(itemsListEmptyTest.isListEmpty());
    }
}