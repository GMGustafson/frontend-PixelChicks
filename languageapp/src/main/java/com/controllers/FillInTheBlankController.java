package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.chatterbox.App;
import com.model.*;
import java.util.Random;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FillInTheBlankController implements Initializable{

    @FXML
    private Button back;

    @FXML
    private AnchorPane fillintheblank;

    @FXML
    private Button fitbA;

    @FXML
    private Button fitbB;

    @FXML
    private Button fitbC;

    @FXML
    private Button fitbD;

    @FXML
    private Label fitbQuestion;

    @FXML
    private Button hint;

    @FXML
    private Label hintLabel;

    @FXML
    private Label showCategory;

    private Progress progress;
    private CategorySystemFacade facade;
    private User user;
    private UserList userList;
    private Course course;
    private Course category;
    private CourseList courseList;
    private FillInTheBlank fillInTheBlank;
    private Phrase phrase;
    private Word word;
    private String correctAnswer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance()
        user = facade.getCurrentUser();
        category = facade.getCategory();
        course = Course.getAvailableCourse();
        showCategory.setText("Category: " + facade.getCategory());
        
        
        //String currentCategory = progress.getCurrentCategory();
        ArrayList<Word> answerList = course.getWordsByCategory(currentCategory);
        ArrayList<String> altAnswers = word.getAlternatives();
        
        ArrayList<Phrase> phrases = course.getPhrasesByCategory(currentCategory);
        fitbQuestion.setText(""+ fillInTheBlank.getSampleSentence());
        correctAnswer = fillInTheBlank.getMissingWord();

        Random random = new Random();
        while (!altAnswers.isEmpty()) {
            int index = random.nextInt(altAnswers.size());
            System.out.println(altAnswers.remove(index));
            // fitbA.setText();

        }
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @FXML
    void backToActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

    @FXML
    void chooseA(ActionEvent event) {
        fillInTheBlank.checkAnswer(fitbA.getText());
    if (fitbA.getText().equals(fillInTheBlank.checkAnswer(correctAnswer))) {
        progress.trackCorrectAnswer();
    }
    else {
        fitbD.setText("X");
        progress.trackQuestion();

    }
    }

    @FXML
    void chooseC(ActionEvent event) {
        fillInTheBlank.checkAnswer(fitbC.getText());
        if (fitbC.getText().equals(fillInTheBlank.checkAnswer(correctAnswer))) {
            progress.trackCorrectAnswer();
        }
        else {
            fitbC.setText("X");
            progress.trackQuestion();
        }
    }

    @FXML
    void chooseD(ActionEvent event) {
    
    fitbD.setText("");
    fillInTheBlank.checkAnswer(fitbD.getText());
    if (fitbD.getText().equals(fillInTheBlank.checkAnswer(correctAnswer))) {
        progress.trackCorrectAnswer();
    }
    else {
        fitbD.setText("X");
        progress.trackQuestion();
    }
    }

    @FXML
    void chooseB(ActionEvent event) {
        fillInTheBlank.checkAnswer(fitbB.getText());
    if (fitbB.getText().equals(fillInTheBlank.checkAnswer(correctAnswer))) {
        progress.trackCorrectAnswer();
    }
    else {
        fitbB.setText("X");
        progress.trackQuestion();
    }
    }

    @FXML
    void showHint(ActionEvent event) {
            hintLabel.setText(""+ phrase.getTranslation());
            hintLabel.setText("");
            
    }
}


