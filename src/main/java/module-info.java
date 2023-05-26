module com.example.sporteventsticketsshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;


    opens com.example.sporteventsticketsshop to javafx.fxml;
    exports com.example.sporteventsticketsshop;
    exports com.example.sporteventsticketsshop.controllers;
    opens com.example.sporteventsticketsshop.controllers to javafx.fxml;
    exports com.example.sporteventsticketsshop.exceptions;
    opens com.example.sporteventsticketsshop.exceptions to javafx.fxml;
    exports com.example.sporteventsticketsshop.entities;
    opens com.example.sporteventsticketsshop.entities to javafx.fxml;
    exports com.example.sporteventsticketsshop.database;
    opens com.example.sporteventsticketsshop.database to javafx.fxml;
}