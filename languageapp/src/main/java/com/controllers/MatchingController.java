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
import com.controllers.WordLoader;

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
    
    @FXML
    void initialize() {
        List<Button> buttons1 = List.of(Button1, Button2, Button3, Button4); 
        List<Button> buttons2 = List.of(Button5, Button6, Button7, Button8);


   
    List<String> words = new ArrayList<>(List.of("rojo", "verde", "blanco", "azul", "amarillo", "naranja", "rosa", "morado", "gris"));
    List<String> wordList = new ArrayList<>(WordLoader.getRandomizedWords(words));

    
    int wordCount = buttons1.size();

    for (int i = 0; i < wordCount; i++) {
        buttons1.get(i).setText(wordList.get(i));
    }

    List<String> words2 = new ArrayList<>(List.of("red", "green", "white", "blue", "yellow", "orange", "pink", "purple", "gray"));
    List<String> wordList2 = new ArrayList<>(WordLoader.getRandomizedWords(words2));

    int wordCount2 = buttons2.size();

    for (int i = 0; i < wordCount2; i++) {
        buttons2.get(i).setText(wordList2.get(i));
    }

    Map<String, String> wordMap = new HashMap<String, String>();
    wordMap.put("rojo", "red");
    wordMap.put("verde", "green");
    wordMap.put("blanco", "white");
    wordMap.put("azul", "blue");
    wordMap.put("amarillo", "yellow");
    wordMap.put("naranja", "orange");
    wordMap.put("rosa", "pink");
    wordMap.put("morado", "purple");
    wordMap.put("gris", "gray");
}

}

