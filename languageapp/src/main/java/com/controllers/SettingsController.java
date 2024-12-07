package com.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsController implements Initializable {

    @FXML
    private Button back;

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
    private Button update;
    
    @FXML
    private Label Update;

   

    @FXML
    void UpdateFields(ActionEvent event) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();

        facade.addUser();

        Update.setText("Updated");


    }

    @FXML
    void GoBack(ActionEvent event) throws IOException{
        App.setRoot("activities");
    }

    private CategorySystemFacade facade;
    private User user; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();

        
        System.out.println(user.getFormattedDateOfBirth());

        txt_firstname.setText(user.getFirstName());
        txt_lastname.setText(user.getLastName());
        txt_username.setText(user.getUsername());
        txt_password.setText(user.getPassword());
        txt_email.setText(user.getEmail());
        txt_phonenumber.setText(user.getPhoneNumber());
        // birthday.setValue(user.getDateOfBirth());
    }

}
