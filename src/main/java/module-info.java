module com.example.sporteventsticketsshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sporteventsticketsshop to javafx.fxml;
    exports com.example.sporteventsticketsshop;
}