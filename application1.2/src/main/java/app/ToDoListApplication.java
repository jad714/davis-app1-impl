/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ToDoListApplication extends Application {

    @Override
    public void start(Stage initStage) throws Exception{
        // Set the root to the FXML file.
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ToDoListApplication.fxml")));
        // Set up a new scene.
        Scene myScene = new Scene(root);
        // Title the scene.
        initStage.setTitle("ToDo List Manager");
        // Start up the GUI.
        initStage.setScene(myScene);
        initStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
