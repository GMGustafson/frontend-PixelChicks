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
    void backtoActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

    @FXML
    void changeColor(MouseEvent event) {
        Button1.setOnMouseClicked(e -> {
            Button1.setStyle("-fx-background-color: yellow");
        });
        Button2.setOnMouseClicked(e -> {
            Button2.setStyle("-fx-background-color: pink");
        });
        Button3.setOnMouseClicked(e -> {
            Button3.setStyle("-fx-background-color: blue");
        });
        Button4.setOnMouseClicked(e -> {
            Button4.setStyle("-fx-background-color: green");
        });
        Button5.setOnMouseClicked(e -> {
            Button5.setStyle("-fx-background-color: red");
        });
        Button6.setOnMouseClicked(e -> {
            Button6.setStyle("-fx-background-color: white");
        });
        Button7.setOnMouseClicked(e -> {
            Button7.setStyle("-fx-background-color: orange");
        });
        Button8.setOnMouseClicked(e -> {
            Button8.setStyle("-fx-background-color: purple");
        });
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
        buttons1.get(i).setOnMouseClicked(e -> {
            // buttons1.get(index).setStyle("-fx-background-color: " + getColor(words.get(index)));
        });
        // buttons1.get(i).setStyle("-fx-background-color: " + getColor(words.get(i)));
    }

    int wordCount2 = buttons2.size();
    for (int i = 0; i < wordCount2; i++) {
        final int index = i;
        buttons2.get(i).setText(translations.get(i).getTranslation());
        buttons2.get(i).setOnMouseClicked(e -> {
            // buttons2.get(index).setStyle("-fx-background-color: " + getColor(englishWords.get(index)));
        });
        // buttons2.get(i).setStyle("-fx-background-color: " + getColor(englishWords.get(i)));
    }   
}

// private String getColor(Word word){
//     switch (word) {
//         case "rojo":
//             return "red";
//         case "verde":
//             return "green";
//         case "blanco":
//             return "white";
//         case "azul":
//             return "blue";
//         case "amarillo":
//             return "yellow";
//         case "naranja":
//             return "orange";
//         case "rosa":
//             return "pink";
//         case "morado":
//             return "purple";
//         case "gris":
//             return "gray";
//         case "red":
//             return "red";
//         case "green":
//             return "green";
//         case "white":
//             return "white";
//         case "blue":
//             return "blue";
//         case "yellow":
//             return "yellow";
//         case "orange":
//             return "orange";
//         case "pink":
//             return "pink";
//         case "purple":
//             return "purple";
//         case "gray":
//             return "gray";
//         default:
//             return "black";
//     }
// }
}



