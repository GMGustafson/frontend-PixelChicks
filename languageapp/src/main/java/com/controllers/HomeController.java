package com.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
import com.chatterbox.App;


public class HomeController {

    @FXML
    private Button createAccountButton;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) throws IOException{
        System.out.println("Welcome back!");
        App.setRoot("login");
    }

    @FXML
    void createAccount(ActionEvent event) throws IOException{
        System.out.println("Welcome. Let's create an account!");
        App.setRoot("createAccount");
    }

   
}
