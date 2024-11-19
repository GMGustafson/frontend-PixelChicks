package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.chatterbox.App;
import com.model.*;

public class LoginController implements Initializable {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;
    @FXML
    private Button login;

    @FXML
    private void btnLoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance();

        if (!facade.login(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        App.setRoot("user_home");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}

