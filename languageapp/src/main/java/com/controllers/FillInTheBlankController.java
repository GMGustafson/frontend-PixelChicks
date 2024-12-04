package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.model.*;

public class FillInTheBlankController {

    private Progress progress;

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
    private Label hintLabel;

    @FXML
    private Label fitbQuestion;


    @FXML
    void backtoActivities(ActionEvent event) throws IOException{
            App.setRoot("activities");
    }

    @FXML
    void chooseA(ActionEvent event) {
        A.setText("X");
        progress.trackQuestion();
    }

    @FXML
    void chooseB(ActionEvent event) {
        B.setText("X");
        progress.trackQuestion();
    }

    @FXML
    void chooseC(ActionEvent event) {
        C.setText("X");
        progress.trackQuestion();
    }

    @FXML
    void chooseD(ActionEvent event) {
        D.setText("CORRECT!");
        progress.trackCorrectAnswer();
    }

    @FXML
    void showHint(ActionEvent event) {
        if (hintLabel.equals("Hint")) {
        hintLabel.setText("Black and white make what?");
        }
        else {
        hintLabel.setText("Hint");
        }
    }


}

