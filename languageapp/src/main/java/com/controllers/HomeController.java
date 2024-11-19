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
    void createAccount(ActionEvent event) {
        System.out.println("Welcome. Let's create an account!");
        try {
            App.setRoot("createAccount");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void login(ActionEvent event) {
        System.out.println("Welcome back!");
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
