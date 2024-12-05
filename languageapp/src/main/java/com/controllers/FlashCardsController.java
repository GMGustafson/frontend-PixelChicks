
package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.CategorySystemFacade;
import com.model.Flashcard;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FlashCardsController implements Initializable {
    @FXML
    private Button Back;

    @FXML
    private Button forward;

    @FXML
    private Label wordLabel;

    @FXML
    private Label categ;
    
    @FXML
    private Label showcard;
    private String[] words = {"rojo", "verde", "blanco"};
    private int index = 0;
    private CategorySystemFacade facade;
    private User user;
    private Flashcard flashcard;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        
        showcard.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
       // showcard.setCategory();
    }



}
  


    // private void showCard(){
    //     CategorySystemFacade facade = facade.getFacadeInstance();
    // }


