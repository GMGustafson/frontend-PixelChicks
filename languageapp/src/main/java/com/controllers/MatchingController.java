package com.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import com.model.Word;
import com.model.CategorySystemFacade;
import com.chatterbox.App;
import com.model.Category;
import com.model.Course;
import com.controllers.WordLoader;
import com.model.User;
import com.model.Progress;
import com.model.*;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.model.CategorySystemFacade;



/** 
  * She wants us to like randomly pick them with an arraylist 
  */

public class MatchingController {
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
    private Button Check;

    @FXML
    private Label lblCheck;

    @FXML
    void CheckAnswers(ActionEvent event) {

        // if (Button1 == Button2)
        // {
        //     lblCheck.setText("Correct!");
        // } else {
        //     lblCheck.setText("Incorrect!");
        // }
        // lblCheck.setText("Correct!");
        if(Button1 != Button5 || Button2 != Button6 || Button3 != Button7 || Button4 != Button8){
            lblCheck.setText("Correct!");
            // progress.trackQuestion();
            progress.trackCorrectAnswer();
        } else {
            lblCheck.setText("Incorrect!");
            // progress.trackQuestion();
            // progress.addMissedWords(userCatergory);
        }

    }
    
    @FXML
    void backtoActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }



    private CategorySystemFacade facade;
    private User user;
    // private Word word;
    private Course course;
    private Category category;
    private Progress progress;
    private List<Word> word;
    private String userCatergory;

    private List<Word> words;
    private List<Word> translations;
    
    @FXML
    void initialize() {

        List<Button> buttons1 = List.of(Button1, Button2, Button3, Button4); 
        List<Button> buttons2 = List.of(Button5, Button6, Button7, Button8);

        
        
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        course = user.getCurrentCourse();
        progress = user.getCurrentProgress();
        userCatergory= progress.getCurrentCategory();
        
        words = course.getWordsByCategory(userCatergory);
        translations = course.getTranslationByCategory(userCatergory);
        
        System.out.println("Progress" + progress);
        System.out.println("Words" + words);
        System.out.println("Translations" + translations);
        Collections.shuffle(words);
        Collections.shuffle(translations);
    
        int wordCount = buttons1.size();

    for (int i = 0; i < wordCount; i++) {
        final int index = i;
        buttons1.get(i).setText(words.get(i).getWord());
        Button1.setOnMouseClicked(e ->{
            Button1.setStyle("-fx-background-color: lightblue");
        });;
        Button1.setStyle("-fx-background-color: gray");
        Button2.setOnMouseClicked(e ->{
            Button2.setStyle("-fx-background-color: lightyellow");
        });;
        Button2.setStyle("-fx-background-color: gray");
        Button3.setOnMouseClicked(e ->{
            Button3.setStyle("-fx-background-color: lightgreen");
        });;
        Button3.setStyle("-fx-background-color: gray");
        Button4.setOnMouseClicked(e ->{
            Button4.setStyle("-fx-background-color: lightpink");
        });;
        Button4.setStyle("-fx-background-color: gray");
        }

        int wordCount2 = buttons2.size();
        for (int i = 0; i < wordCount2; i++) {
        final int index = i;
        buttons2.get(i).setText(translations.get(i).getTranslation());
        Button5.setOnMouseClicked(e ->{
            Button5.setStyle("-fx-background-color: lightblue");
        });;
        Button5.setStyle("-fx-background-color: gray");
        Button6.setOnMouseClicked(e ->{
            Button6.setStyle("-fx-background-color: lightyellow");
        });;
        Button6.setStyle("-fx-background-color: gray");
        Button7.setOnMouseClicked(e ->{
            Button7.setStyle("-fx-background-color: lightgreen");
        });;
        Button7.setStyle("-fx-background-color: gray");
        Button8.setOnMouseClicked(e ->{
            Button8.setStyle("-fx-background-color: lightpink");
        });;
        Button8.setStyle("-fx-background-color: gray");

        }
    }   
}





