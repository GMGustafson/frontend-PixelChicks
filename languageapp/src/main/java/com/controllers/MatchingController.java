package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MatchingController {

    @FXML
    private Button next;

    @FXML
    void OnNext(ActionEvent event) throws IOException {
        App.setRoot("mockconvos");
    }

}
