
package com.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FlashCardsController {

    @FXML
    private Button Back;

    @FXML
    private Button forward;

    @FXML
    private Label wordLabel;
    private String[] words = {"rojo", "verde", "blanco"};
    private int index = 0;

    @FXML
    void backtoActivites(ActionEvent event) {

    }

    @FXML
    void goNext(MouseEvent event) throws IOException{
        wordLabel.setText(words[index]);
        index = (index + 1) % words.length;
    }

    @FXML
    void goBack(MouseEvent event) throws IOException{
        index = (index - 1 + words.length) % words.length; 
        wordLabel.setText(words[index]);
    }

    @FXML
    void translateCard(MouseEvent event) throws IOException{
        forward.setText(words[index]);
        index = (index + 1) % words.length;
    }

}
  


    // private void showCard(){
    //     CategorySystemFacade facade = facade.getFacadeInstance();
    // }


