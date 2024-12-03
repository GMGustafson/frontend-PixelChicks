package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FillInTheBlankController {

    @FXML 
    private Label hintLabel;

    @FXML
    private Button A;

    @FXML
    private Button B;

    @FXML
    private Button C;

    @FXML
    private Button D;

    @FXML
    private Button back;

    @FXML
    private Button hint;

    @FXML
    void backtoActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

    @FXML
    void chooseA(ActionEvent event) {
        
    }

    @FXML
    void chooseB(ActionEvent event) {

    }

    @FXML
    void chooseC(ActionEvent event) {

    }

    @FXML
    void chooseD(ActionEvent event) {

    }

    @FXML
    void showHint(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Hint");
        alert.setHeaderText(null);
        alert.setContentText("This is your hint for the question!");
        alert.showAndWait();
    }

}

