package com.example.addressbookprogramminglab;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContactsModel {
    ObservableList<Contact> data = FXCollections.observableArrayList();



    public void addContact(Contact contact) {
        data.add(contact);
    }

    public ObservableList<Contact> getContacts(){
        return data;
    }

    public Contact removeContact(String name, String number){
        for (int i = 0; i < data.size(); i++){
            Contact contact = data.get(i);
            if (contact.getName().equals(name) && contact.getNumber().equals(number)){
                return data.remove(i);
            }
        }
        return null;
    }
}
