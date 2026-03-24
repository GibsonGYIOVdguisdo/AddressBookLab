package com.example.addressbookprogramminglab;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;

public class HeaderMenuBar extends MenuBar {
    ContactsModel contacts;
    Stage mainStage;

    HeaderMenuBar(ContactsModel contactsModel, Stage stage){
        super();
        this.mainStage = stage;
        this.contacts = contactsModel;
        this.getMenus().add(this.getFileMenu());
    }

    Menu getFileMenu(){
        Menu menu = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Contacts File");
        fileChooser.getExtensionFilters().add(
                new ExtensionFilter("Contact File", "*.ser")
        );

        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    File selectedFile = fileChooser.showOpenDialog(mainStage);
                    if (selectedFile != null) {
                        contacts.loadFromFile(selectedFile);
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    File selectedFile = fileChooser.showSaveDialog(mainStage);
                    if (selectedFile != null) {
                        contacts.saveToFile(selectedFile);
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        menu.getItems().add(save);
        menu.getItems().add(load);

        return menu;
    }

}
