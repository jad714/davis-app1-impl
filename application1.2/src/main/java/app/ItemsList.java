/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemsList {
    private final ObservableList<Items> items = FXCollections.observableArrayList();
    private int size;
    public ItemsList(){
        this.size = 0;
    }


    public void addItem(Items item){
        // Adds a new entry to items.
        items.add(item);
        size++;
    }

    public void removeItem(int index){
        // Removes the item at the specified index.
        if(!items.isEmpty()) {
            items.remove(index);
            size--;
        }
    }

    public void deleteList(){
        // Clears the entire list (a warning should appear to user that they should save the list first).
        items.clear();
        size = 0;
    }

    public Items getItem(int index) {
        // Gets an item (for display or edit).
        return items.get(index);
    }

    public void setItem(int index, Items item){
        items.set(index, item);
    }

    public int getSize(){
        return this.size;
    }

    public boolean isListEmpty(){
        return items.isEmpty();
    }

    public ObservableList<Items> getList(){
        return items;
    }
}
