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

    private NitriteDB db = NitriteDB.getInstance();

    private Main m = new Main();
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
            try {
                db.insertUser(username.getText(), password.getText(), (String) role.getValue());
                usernameTaken.setText("Account created successfully!");
                Main m = new Main();
                if(db.findUser(username.getText()).isPresent()) {
                    db.setCurrentUser(db.findUser(username.getText()).get());
                }
                if(role.getValue().equals("Customer")) {
                    m.changeScene("customer-menu.fxml");
                } else {
                    m.changeScene("organizer-menu.fxml");
                }
            } catch (UserAlreadyExistsException e) {
                usernameTaken.setText(e.getMessage());
            }
        }
    }
    public void toLogin(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("log-in.fxml");
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public ChoiceBox<String> getRole() {
        return role;
    }

    public Button getRegister() {
        return register;
    }

    public Button getLogin() {
        return login;
    }

    public Label getUsernameTaken() {
        return usernameTaken;
    }

    public NitriteDB getDb() {
        return db;
    }

    public Main getM() {
        return m;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public void setRole(ChoiceBox<String> role) {
        this.role = role;
    }

    public void setRegister(Button register) {
        this.register = register;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public void setUsernameTaken(Label usernameTaken) {
        this.usernameTaken = usernameTaken;
    }

    public void setDb(NitriteDB db) {
        this.db = db;
    }

    public void setM(Main m) {
        this.m = m;
    }
}