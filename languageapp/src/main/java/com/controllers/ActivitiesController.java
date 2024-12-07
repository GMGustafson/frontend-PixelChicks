package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ActivitiesController implements Initializable {

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
    private Button Progress;

    @FXML
    private Label WelcomeText;
    
    @FXML
    private Button Settings;

    @FXML
    private Button logout;

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
        App.setRoot("mockconvos");
    }

    @FXML
    void GoToStory(ActionEvent event)  throws IOException{
        App.setRoot("story");
    }

    @FXML
    void GoToLogout(ActionEvent event) throws IOException{
        App.setRoot("logout");
    }


    @FXML
    void GoToProgress(ActionEvent event) throws IOException{
        System.out.println("In go to progress");
        App.setRoot("progress");
    }


    @FXML
    void GoToSettings(ActionEvent event) throws IOException{
        App.setRoot("settings");
    }

    private User user; 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        if(user == null) {
            System.out.println("User is null");
        }
        else{
            WelcomeText.setText("Welcome, " + user.getFirstName());
        }
    }


    



}
