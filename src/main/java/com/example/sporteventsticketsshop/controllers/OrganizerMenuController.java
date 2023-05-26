package com.example.sporteventsticketsshop.controllers;


import com.example.sporteventsticketsshop.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class OrganizerMenuController {
    @FXML
    private Button modifyEvent;

    @FXML
    private Button createEvent;

    @FXML
    public void toCreateEvent(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("add-event.fxml");
    }

    @FXML
    public void toModifyEvent(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("modify-event.fxml");
    }
}
