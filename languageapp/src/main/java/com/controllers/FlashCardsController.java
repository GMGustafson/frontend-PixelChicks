package com.controllers;

import java.io.IOException;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Flashcard;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FlashcardsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Back"
    private Button Back; // Value injected by FXMLLoader

    @FXML
    void backtoActivites(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'FlashCards.fxml'.";

    }

    @FXML
    private Label word;

    @FXML


    // private void showCard(){
    //     CategorySystemFacade facade = facade.getFacadeInstance();
    // }

}
