package com.example.sporteventsticketsshop.controllers;

import com.example.sporteventsticketsshop.Main;
import com.example.sporteventsticketsshop.database.NitriteDB;
import com.example.sporteventsticketsshop.entities.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowOrdersController implements Initializable {
    @FXML
    private Button back;

    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event,String> name;
    @FXML
    private TableColumn<com.example.sporteventsticketsshop.entities.Event, String> date;
    @FXML
    private TableColumn<com.example.sporteventsticketsshop.entities.Event,Double> price;
    NitriteDB db = NitriteDB.getInstance();
    ObservableList<Event> list = FXCollections.observableList(db.getCurrentUser().getEvents());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<Event,String>("eventName"));
        date.setCellValueFactory(new PropertyValueFactory<com.example.sporteventsticketsshop.entities.Event,String>("eventDate"));
        price.setCellValueFactory(new PropertyValueFactory<com.example.sporteventsticketsshop.entities.Event,Double>("ticketPrice"));

        table.setItems(list);
    }
    @FXML
    public void toCustomerMenu(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("customer-menu.fxml");
    }
}
