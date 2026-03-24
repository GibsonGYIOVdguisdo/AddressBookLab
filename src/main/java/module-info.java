module com.example.addressbookprogramminglab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;


    opens com.example.addressbookprogramminglab to javafx.fxml;
    exports com.example.addressbookprogramminglab;
}