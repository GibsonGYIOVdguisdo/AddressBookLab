package com.example.addressbookprogramminglab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        stage.setTitle("Address Book");

        TabPane tabPane = new TabPane();
        Tab t1 = new Tab("Entry");
        Tab t2 = new Tab("List");
        Tab t3 = new Tab("Search");
        
        tabPane.getTabs().add(t1);
        tabPane.getTabs().add(t2);
        tabPane.getTabs().add(t3);

        t1.setClosable(false);
        t2.setClosable(false);
        t3.setClosable(false);

        root.setLeft(tabPane);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}