package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FillInTheBlankController {

    @FXML
    private Button back;

    @FXML
    void backtoActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

}
