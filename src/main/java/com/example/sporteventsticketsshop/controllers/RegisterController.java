package com.example.sporteventsticketsshop.controllers;

import com.example.sporteventsticketsshop.Main;
import com.example.sporteventsticketsshop.database.NitriteDB;
import com.example.sporteventsticketsshop.exceptions.UserAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Button register;
    @FXML
    private Button login;
    @FXML
    private Label usernameTaken;

    private final String[] roles = {"Customer", "Organizer"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(roles);
    }

    public void userRegister(ActionEvent event) throws IOException {
        checkRegister();
    }

    private void checkRegister() throws IOException {
        if (username.getText().isEmpty()) {
            usernameTaken.setText("Please fill in the username field");
        } else if (password.getText().isEmpty()) {
            usernameTaken.setText("Please fill in the password field");
        } else if (role.getValue() == null) {
            usernameTaken.setText("Please fill in the role field");
        } else {
            usernameTaken.setText("Account created successfully!");
        }
    }
}