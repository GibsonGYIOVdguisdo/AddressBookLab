package com.example.addressbookprogramminglab;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    SimpleStringProperty name;
    SimpleStringProperty number;
    SimpleStringProperty address;
    SimpleStringProperty country;

    Contact(String name, String number, String address, String country){
        this.name = new SimpleStringProperty(name);
        this.number = new SimpleStringProperty(number);
        this.address = new SimpleStringProperty(address);
        this.country = new SimpleStringProperty(country);
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
}
