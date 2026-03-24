package com.example.addressbookprogramminglab;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

public class SearchPane extends TilePane {
    SearchPane() {
        TilePane searchInputsPane = new TilePane();
        TableView contactListPane = new TableView();

        this.setPrefColumns(1);
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
        this.getChildren().addAll(searchInputsPane, contactListPane);
    }
}
