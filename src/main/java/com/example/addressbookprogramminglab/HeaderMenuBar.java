package com.example.addressbookprogramminglab;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class HeaderMenuBar extends MenuBar {
    HeaderMenuBar(){
        super();
        this.getMenus().add(this.getFileMenu());
    }

    Menu getFileMenu(){
        Menu menu = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        menu.getItems().add(save);
        menu.getItems().add(load);
        return menu;
    }

}
