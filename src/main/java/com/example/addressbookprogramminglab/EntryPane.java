package com.example.addressbookprogramminglab;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class EntryPane extends TilePane {
    ContactsModel contacts = new ContactsModel();

    enum Country {
        UK,
        US,
        DE,
        CN
    }

    EntryPane(ContactsModel contactsModel){
        super();
        this.contacts = contactsModel;
        this.createEntryPaneLayout();
    }

    void createEntryPaneLayout(){
        ContactsModel contacts = this.contacts;

        TilePane entryPane = this;
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

        ComboBox<HelloApplication.Country> countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll(HelloApplication.Country.values());

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
        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clearText(inputPane);
            }
        });

        Button editButton = new Button("Edit");

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                contacts.removeContact(nameTextField.getText(), numberTextField.getText());
            }
        });

        buttonHBox.getChildren().add(clearButton);
        buttonHBox.getChildren().add(editButton);
        buttonHBox.getChildren().add(addButton);
        buttonHBox.getChildren().add(deleteButton);

        entryPane.getChildren().add(inputPane);

        buttonHBox.setAlignment(Pos.BASELINE_CENTER);
        entryPane.getChildren().add(buttonHBox);
    }

    void clearText(Pane pane){
        ObservableList<Node> children = pane.getChildren();
        for (Node child : children){
            if (child instanceof TextInputControl){
                ((TextInputControl) child).clear();
            }
        }
    }
}
