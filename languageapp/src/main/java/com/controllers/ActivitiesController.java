package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ActivitiesController {

    @FXML
    private Button FillInTheBlankButton;

    @FXML
    private Button FlashcardButton;

    @FXML
    private Button MatchingButton;

    @FXML
    private Button MockConvosButton;

    @FXML
    private Button StoryButton;
    @FXML
    private Button dictionary;

    @FXML
    void GoToDictionary(ActionEvent event) throws IOException{
        App.setRoot("dictionary");
    }

    @FXML
    void GoToFillInTheBlank(ActionEvent event) throws IOException {
        App.setRoot("fillintheblank");
    }   

    @FXML
    void GoToFlashCards(ActionEvent event) throws IOException {
        App.setRoot("FlashCards");
    }

    @FXML
    void GoToMatching(ActionEvent event)  throws IOException{
        App.setRoot("matching");
    }

    @FXML
    void GoToMockConvo(ActionEvent event) throws IOException {
        App.setRoot("MockConvo");
    }

    @FXML
    void GoToStory(ActionEvent event)  throws IOException{
        App.setRoot("Story");
    }

}
