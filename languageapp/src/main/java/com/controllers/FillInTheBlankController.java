package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.chatterbox.App;
import com.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;

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

    private Progress progress;
    private CategorySystemFacade facade;
    private UserList userList;
    private Course course;
    private CourseList courseList;
    private FillInTheBlank fillInTheBlank;
    private Phrase phrase;
    private Word word;
    private String correctAnswer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CourseList currentCourse = courseList.getInstance();
        UserList currentUser = userList.getInstance();
        
        String currentCategory = progress.getCurrentCategory();
        ArrayList<Word> answerList = course.getWordsByCategory(currentCategory);
        ArrayList<String> altAnswers = word.getAlternatives();
        
        ArrayList<Phrase> phrases = course.getPhrasesByCategory(currentCategory);
        fitbQuestion.setText(""+ fillInTheBlank.getSampleSentence());
        correctAnswer = fillInTheBlank.getMissingWord();

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


