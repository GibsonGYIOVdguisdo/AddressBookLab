package com.example.addressbookprogramminglab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddressBookApplication extends Application {
    private ContactsModel contacts;

    enum Country {
        UK,
        US,
        DE,
        CN
    }

    @Override
    public void start(Stage stage) throws IOException {
        ContactsModel contacts = new ContactsModel();
        BorderPane root = new BorderPane();

        MenuBar header = new HeaderMenuBar(contacts, stage);
        root.setTop(header);

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

        EntryPane entryPane = new EntryPane(contacts);
        entryTab.setContent(entryPane);

        ListPane listPane = new ListPane(contacts, entryPane);
        listTab.setContent(listPane);

        TilePane searchPane = new SearchPane();
        searchTab.setContent(searchPane);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}