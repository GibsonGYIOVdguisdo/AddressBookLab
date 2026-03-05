package com.example.addressbookprogramminglab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    enum Country {
        UK,
        US,
        DE,
        CN
    }

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        stage.setTitle("Address Book");

        TabPane tabPane = new TabPane();

        Tab entryTab = new Tab("Entry");
        Tab listTab = new Tab("List");
        Tab searchTab = new Tab("Search");

        entryTab.setClosable(false);
        listTab.setClosable(false);
        searchTab.setClosable(false);

        tabPane.getTabs().add(entryTab);
        tabPane.getTabs().add(listTab);
        tabPane.getTabs().add(searchTab);

        root.setLeft(tabPane);

        TilePane entryPane = getEntryPane();

        entryTab.setContent(entryPane);


        stage.setScene(scene);
        stage.show();
    }

    TilePane getEntryPane(){
        TilePane entryPane = new TilePane();
        entryPane.setPrefColumns(1);

        TilePane inputPane = new TilePane();
        inputPane.setPrefColumns(2);

        Label nameLabel = new Label("Name: ");
        Label numberLabel = new Label("Number: ");
        Label addressLabel = new Label("Address: ");
        Label countryLabel = new Label("Country: ");

        TextField nameTextField = new TextField();
        TextField numberTextField = new TextField();
        TextField addressTextField = new TextField();

        ComboBox<Country> countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll(Country.values());

        inputPane.getChildren().add(nameLabel);
        inputPane.getChildren().add(nameTextField);
        inputPane.getChildren().add(numberLabel);
        inputPane.getChildren().add(numberTextField);
        inputPane.getChildren().add(addressLabel);
        inputPane.getChildren().add(addressTextField);
        inputPane.getChildren().add(countryLabel);
        inputPane.getChildren().add(countryComboBox);

        HBox buttonHBox = new HBox();

        Button clearButton = new Button("Clear");
        Button editButton = new Button("Edit");
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        buttonHBox.getChildren().add(clearButton);
        buttonHBox.getChildren().add(editButton);
        buttonHBox.getChildren().add(addButton);
        buttonHBox.getChildren().add(deleteButton);

        entryPane.getChildren().add(inputPane);

        buttonHBox.setAlignment(Pos.BASELINE_CENTER);
        entryPane.getChildren().add(buttonHBox);

        return entryPane;
    }

    public static void main(String[] args) {
        launch();
    }
}