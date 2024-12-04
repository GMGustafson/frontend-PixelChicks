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
import javafx.scene.input.MouseEvent;

public class FlashCardsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Back"
    private Button Back; // Value injected by FXMLLoader

    @FXML // fx:id="word"
    private Button word; // Value injected by FXMLLoader
    
    @FXML
    private Label wordLabel;
    private String[] words = {"rojo", "verde", "blanco"};
    private String[] translated = {"red", "green", "white"};
    private int index = 0;

    @FXML
    void backtoActivites(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'FlashCards.fxml'.";
        assert word != null : "fx:id=\"word\" was not injected: check your FXML file 'FlashCards.fxml'.";

    }

    @FXML
    void GoToNext(ActionEvent event) throws IOException {
        App.setRoot("activities");

    }

    @FXML
    void goNext(MouseEvent event) throws IOException{
        wordLabel.setText(words[index]);
        index = (index + 1) % words.length;
    }

    @FXML
    void translateCard(MouseEvent event) throws IOException{
        word.setText(translated[index]);
        index = (index + 1) % translated.length;
    }

    // private void showCard(){
    //     CategorySystemFacade facade = facade.getFacadeInstance();
    // }

}
