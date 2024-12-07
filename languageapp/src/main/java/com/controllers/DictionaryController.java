package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class DictionaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea dictionaryWords;

    @FXML
    private Button back;

    // @FXML
    // void NextPage(ActionEvent event) throws IOException {
    //     // App.setRoot("logout");
    //     App.setRoot("settings"); 
    // }

    @FXML
    void BacktoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

}
