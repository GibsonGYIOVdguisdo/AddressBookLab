package com.example.addressbookprogramminglab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
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

        TableView listPane = getListPane();
        listTab.setContent(listPane);

        TilePane searchPane = getSearchPane();
        searchTab.setContent(searchPane);

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

    TableView getListPane(){
        ObservableList<Contact> data =
                FXCollections.observableArrayList(
                        new Contact("Name1", "001", "Address 1", "Country 1"),
                        new Contact("Name2", "002", "Address 2", "Country 2"),
                        new Contact("Name3", "003", "Address 3", "Country 3")
                );

        TableView listPane = new TableView();

        TableColumn nameColumn = new TableColumn("Name");
        TableColumn numberColumn = new TableColumn("Number");
        TableColumn addressColumn = new TableColumn("Address");
        TableColumn countryColumn = new TableColumn("Country");

        listPane.setItems(data);

        listPane.getColumns().addAll(nameColumn, numberColumn, addressColumn, countryColumn);

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("name")
        );
        numberColumn.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("number")
        );
        addressColumn.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("address")
        );
        countryColumn.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("country")
        );


        return listPane;
    }

    TilePane getSearchPane(){
        TilePane searchPane = new TilePane();
        TilePane searchInputsPane = new TilePane();
        TableView contactListPane = new TableView();

        searchPane.setPrefColumns(1);
        searchInputsPane.setPrefColumns(2);

        Label nameLabel = new Label("Name: ");
        Label numberLabel = new Label("Number: ");
        TextField nameTextField = new TextField();
        TextField numberTextField = new TextField();
        Button clearButton = new Button("Clear");
        Button searchButton = new Button("Search");

        searchInputsPane.getChildren().addAll(
                nameLabel,
                nameTextField,
                numberLabel,
                numberTextField,
                clearButton,
                searchButton
        );
        searchPane.getChildren().addAll(searchInputsPane, contactListPane);
        return searchPane;
    }

    public static void main(String[] args) {
        launch();
    }
}