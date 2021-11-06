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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Application.fxml")));
        Scene myScene = new Scene(root);
        initStage.setTitle("ToDo List Manager");
        initStage.setScene(myScene);
        initStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
