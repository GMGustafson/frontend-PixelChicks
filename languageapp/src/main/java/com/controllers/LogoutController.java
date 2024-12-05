package com.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class LogoutController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="myImageView"
    private ImageView myImageView; // Value injected by FXMLLoader

    @FXML // fx:id="thanks"
    private Label thanks; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert myImageView != null : "fx:id=\"myImageView\" was not injected: check your FXML file 'logout.fxml'.";
        assert thanks != null : "fx:id=\"thanks\" was not injected: check your FXML file 'logout.fxml'.";

    }

}
