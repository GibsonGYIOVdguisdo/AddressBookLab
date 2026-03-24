package com.example.addressbookprogramminglab;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListPane extends TableView {
    ListPane(ContactsModel contacts, EntryPane entryPane){
        super();

        TableColumn nameColumn = new TableColumn("Name");
        TableColumn numberColumn = new TableColumn("Number");
        TableColumn addressColumn = new TableColumn("Address");
        TableColumn countryColumn = new TableColumn("Country");

        this.setItems(contacts.getContacts());

        this.getColumns().addAll(nameColumn, numberColumn, addressColumn, countryColumn);

        this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (t1 != null) {
                    entryPane.setFields((Contact) t1);
                    entryPane.setSelectedContact((Contact) t1);
                }
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
    }
}
