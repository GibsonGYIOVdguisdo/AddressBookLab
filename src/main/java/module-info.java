module com.example.addressbookprogramminglab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.addressbookprogramminglab to javafx.fxml;
    exports com.example.addressbookprogramminglab;
}