package com.controllers;

import java.io.IOException;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Flashcard;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;



public class FlashCardsController {

    @FXML
    private Button Back;

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
         App.setRoot("activities");
    }

    private void showCard(){
        CategorySystemFacade facade = facade.getFacadeInstance();
    }

}
