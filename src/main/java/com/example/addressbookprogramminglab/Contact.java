package com.example.addressbookprogramminglab;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    SimpleStringProperty name;
    SimpleStringProperty number;
    SimpleStringProperty address;
    SimpleStringProperty country;

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
