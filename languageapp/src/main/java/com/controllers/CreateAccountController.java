package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CreateAccountController {

    @FXML
    private Button next;

    @FXML
    void goToCreateAccount2(ActionEvent event) throws IOException{
        System.out.println("going to next page"); 
        App.setRoot("createAccount2");
    }

}
