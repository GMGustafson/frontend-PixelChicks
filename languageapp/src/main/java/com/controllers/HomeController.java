package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.chatterbox.App;
import java.io.IOException;
import com.narration.*;
import javafx.fxml.FXML;

public class HomeController {

    // @FXML
    // private TextField txtUserName;


    @FXML
    private void login() throws IOException {
        //Narriator.playSound("Hola Mundo");

        // System.out.println("Welcome " + txtUserName.getText().toString());
        System.out.println("Welcome back!");
        App.setRoot("login");
    }

    @FXML
    private void createAccount() throws IOException {
       // Narriator.playSound("Hola Mundo");

        System.out.println("Welcome. Let's create an account!");
        App.setRoot("createAccount");
    }
}
