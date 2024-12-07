package com.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Course;
import com.model.Progress;
import com.model.User;
import com.model.Word;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MockConvoController implements Initializable{

    @FXML
    private Button hint;

    @FXML
    private Button submit;

    @FXML
    private Label hintLabel;

    @FXML
    void giveHint(MouseEvent event) throws IOException{
        hintLabel.setText("hint");
    }

    @FXML
    private Label Question;

    @FXML
    private Button back;


    @FXML
    private RadioButton ansone;

    @FXML
    private RadioButton ansthree;

    @FXML
    private RadioButton anstwo;


    @FXML
    void QuestionWillAppear(ActionEvent event) throws IOException {
        Question.setText("Ques");
    }

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
         App.setRoot("activities");
    }

    @FXML
    private ImageView parimage;

    private CategorySystemFacade facade;
    private User user;
    private Course category;
    private Course course;
    private Random random; 
    //private String userCategory; 
    private Progress progress;
    private ArrayList<Word> wordList; 
    private Word currWord;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser(); 
        course = user.getCurrentCourse();  
        category = course;
        progress = user.getCurrentProgress(); 
        random = new Random();
         
        wordList = category.getWordsByCategory("colors");
        
        random = new Random();
        displayQuestion();
        
    }   

    private void displayQuestion(){
        currWord = wordList.get(random.nextInt(wordList.size()));
        String q = " What is " + currWord.getTranslation() + " in Spanish? ";
        Question.setText(q);
        
        ArrayList<String> options = new ArrayList<>(currWord.getAlternatives());
        Collections.shuffle(options);

        String correctAnswer = currWord.getWord();
        options = new ArrayList<>(options.subList(0, 2)); // Take two random alternatives
        options.add(correctAnswer);
        Collections.shuffle(options);

        ansone.setText(options.get(0));
        anstwo.setText(options.get(1));
        ansthree.setText(options.get(2));

    }
}
