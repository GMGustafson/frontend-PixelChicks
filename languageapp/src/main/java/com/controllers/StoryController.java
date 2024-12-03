package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StoryController {

    @FXML
    private Label englishText;

    @FXML
    private Button readStoryButton;

    @FXML
    private Label storyTitle;

    @FXML
    private Button back;


    @FXML
    void readStoryAloud(ActionEvent event) {
        
    }

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }   


}
