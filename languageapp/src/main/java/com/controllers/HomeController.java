package com.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import com.chatterbox.App;
import com.narration.*;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private Button createAccountButton;

    @FXML
    private Button loginButton;

    @FXML
    void createAccount(ActionEvent event) throws IOException{
        System.out.println("Welcome. Let's create an account!");
        App.setRoot("createAccount");
    }

    @FXML
    void login(ActionEvent event) throws IOException{
        System.out.println("Welcome back!");
        App.setRoot("login");
       
    }
}
