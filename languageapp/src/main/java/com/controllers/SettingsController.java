package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import com.chatterbox.App;
import com.model.*;

public class SettingsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txt_birthday;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_firstname;
    @FXML
    private TextField txt_lastname;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_phonenumber;
    @FXML
    private TextField txt_username;
    @FXML
    private MenuItem Dictionary;
    @FXML
    private MenuItem Activities;
    @FXML
    private MenuItem Logout;

    @FXML
    private Button next;

    @FXML
    void GotoNext(ActionEvent event) throws IOException {
        App.setRoot("dictionary");
    }
    

    @FXML
    void initialize() {

    }
    
    @FXML
    void switchToDictionary(ActionEvent event) throws IOException{
        CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance();
    }

    @FXML
    void switchToActivities(ActionEvent event) throws IOException{

    }

    @FXML
    void switchToLogout(ActionEvent event) throws IOException{
        CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance();
        //App.setRoot("courses");
    }
}
