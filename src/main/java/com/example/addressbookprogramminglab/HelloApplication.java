package com.example.addressbookprogramminglab;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class HelloApplication extends Application {
    private ContactsModel contacts;
    EntryPane entryPane;
    TableView listPane;

    enum Country {
        UK,
        US,
        DE,
        CN
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.contacts = new ContactsModel();

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

        this.entryPane = new EntryPane(contacts);
        entryTab.setContent(this.entryPane);

        TableView listPane = getListPane();
        this.listPane = listPane;
        listTab.setContent(listPane);

        TilePane searchPane = getSearchPane();
        searchTab.setContent(searchPane);

        stage.setScene(scene);
        stage.show();
    }

    TableView getListPane(){

        TableView listPane = new TableView();

        TableColumn nameColumn = new TableColumn("Name");
        TableColumn numberColumn = new TableColumn("Number");
        TableColumn addressColumn = new TableColumn("Address");
        TableColumn countryColumn = new TableColumn("Country");

        listPane.setItems(this.contacts.getContacts());

        listPane.getColumns().addAll(nameColumn, numberColumn, addressColumn, countryColumn);

        EntryPane entryPane = this.entryPane;
        listPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                entryPane.setFields((Contact) t1);
                entryPane.setSelectedContact((Contact) t1);
            }
        });

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("name")
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

    void clearText(Pane pane){
        ObservableList<Node> children = pane.getChildren();
        for (Node child : children){
            if (child instanceof TextInputControl){
                ((TextInputControl) child).clear();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}