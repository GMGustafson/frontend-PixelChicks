package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MatchingController {

    @FXML
    private Button Back;

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
         App.setRoot("activities");
    }




}
