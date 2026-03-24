package com.example.addressbookprogramminglab;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContactsModel implements Serializable {
    transient ObservableList<Contact> data = FXCollections.observableArrayList();

    ContactsModel(){}

    ContactsModel(Contact[] contacts){
        data.addAll(contacts);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public void loadFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        this.data.setAll(((ContactsModel) in.readObject()).getContacts().toArray(new Contact[0]));
        in.close();
        fileIn.close();
    }

    public void addContact(Contact contact) {
        data.add(contact);
    }

    public void addContact(String name, String number, String address, String country) {
        data.add(new Contact(name, number, address, country));
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        Contact[] contacts = this.data.toArray(new Contact[0]);
        out.writeObject(contacts);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Contact[] contacts = (Contact[]) in.readObject();
        this.data = new ContactsModel(contacts).getContacts();
    }
}
