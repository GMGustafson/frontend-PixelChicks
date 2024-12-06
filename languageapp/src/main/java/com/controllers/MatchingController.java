package com.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

import com.model.Word;
import com.model.CategorySystemFacade;
import com.chatterbox.App;
import com.model.Category;
import com.model.Course;
import com.chatterbox.App;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MatchingController {
    private String[] words = {"rojo", "verde", "blanco", "azul", "amarillo", "naranja", "rosa", "morado", "gris"};
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;   
    
    @FXML
    void backtoActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }
    
    private Course category;
    @FXML
    void initialize() {
        List<Button> buttons = List.of(Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8);

   
    List<String> wordList = new ArrayList<>(List.of("rojo", "verde", "blanco", "azul", "amarillo", "naranja", "rosa", "morado", "gris"));
    List<String> englishList = new ArrayList<>(List.of("red", "green", "white", "blue", "yellow", "orange", "pink", "purple", "gray"));
    Collections.shuffle(wordList);
    Collections.shuffle(englishList);

    

    }
}

