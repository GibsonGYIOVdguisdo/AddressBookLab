package com.example.addressbookprogramminglab;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Contact implements Serializable {
    transient SimpleStringProperty name;
    transient SimpleStringProperty number;
    transient SimpleStringProperty address;
    transient SimpleStringProperty country;

    Contact(){
        this.name = new SimpleStringProperty();
        this.number = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.country = new SimpleStringProperty();
    }

    Contact(String name, String number, String address, String country){
        this();
        this.setName(name);
        this.setNumber(number);
        this.setAddress(address);
        this.setCountry(country);
    }

    public String getAddress() {
        return address.get();
    }

    public String getCountry() {
        return country.get();
    }

    public String getName() {
        return name.get();
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(this.getName() != null ? this.getName() : "");
        out.writeUTF(this.getNumber() != null ? this.getNumber() : "");
        out.writeUTF(this.getAddress() != null ? this.getAddress() : "");
        out.writeUTF(this.getCountry() != null ? this.getCountry() : "");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.name = new SimpleStringProperty(in.readUTF());
        this.number = new SimpleStringProperty(in.readUTF());
        this.address = new SimpleStringProperty(in.readUTF());
        this.country = new SimpleStringProperty(in.readUTF());
    }
}
