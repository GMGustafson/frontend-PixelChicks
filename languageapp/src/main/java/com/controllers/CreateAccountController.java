package com.controllers;

import java.io.IOException;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateAccountController {

    @FXML
    private Button next;

    @FXML
    private TextField txt_birthday;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_first_name;

    @FXML
    private TextField txt_last_name;

    @FXML
    private TextField txt_phone_number;

    @FXML
    void goToCreateAccount2(ActionEvent event) throws IOException{
        String firstName = txt_first_name.getText();
        String lastName = txt_last_name.getText(); 
        String birthday = txt_birthday.getText(); 
        String email = txt_email.getText(); 
        String phoneNumber = txt_phone_number.getText(); 

       UserList userList = UserList.getInstance(); 

       System.out.println("User" + firstName + lastName + email + phoneNumber + birthday);

        if (!userList.addUser(firstName, lastName, email, phoneNumber, birthday)) {
            System.out.println("Not valid"); 
            return;
        }
        else 
        { 
            userList.addUser(firstName, lastName, email, phoneNumber, birthday); 
            System.out.println("going to next page"); 
            App.setRoot("createAccount2");
        }

       
    }

}
