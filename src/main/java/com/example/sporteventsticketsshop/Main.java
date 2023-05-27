package com.example.sporteventsticketsshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setResizable(false);
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml_files/log-in.fxml"));
        primaryStage.setTitle("Sport Events!");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_files/" + fxml));
        stage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }
}
