package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.chatterbox.App;
import com.model.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FillInTheBlankController implements Initializable{

    @FXML
    private Button back;

    @FXML 
    private Button hintButton;

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
    private Label showCategory;

    @FXML Label hintLabel;
    
    private CategorySystemFacade facade;
    private User user;
    private Course course;
    private Progress progress;
    private Phrase currPhrase;
    private String missingWord;
    private ArrayList<String> ansOptions;
    private String correctAnswer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        course = user.getCurrentCourse();
        progress = user.getCurrentProgress();

        String userCategory = progress.getCurrentCategory();
        showCategory.setText(userCategory);

        displayQuestion(userCategory);
    }

    private void displayQuestion(String category) {
        ArrayList<Phrase> phrases = course.getPhrasesByCategory(category);
        Random random = new Random();
        currPhrase = phrases.get(random.nextInt(phrases.size()));
        String phraseText = currPhrase.getWords();

        ArrayList<Word> words = course.getWordsByCategory(category);
        ArrayList<String> wordsInPhrase = getWordsFromPhrase(phraseText, words);
        missingWord = wordsInPhrase.get(random.nextInt(wordsInPhrase.size()));
        correctAnswer = missingWord;

        String q = phraseText.replaceFirst(missingWord, "____");
        fitbQuestion.setText(q);
        ansOptions = new ArrayList<>(getRandomAlternatives(missingWord, words));
        ansOptions.add(correctAnswer);
        Collections.shuffle(ansOptions);
        fitbA.setText(ansOptions.get(0));
        fitbB.setText(ansOptions.get(1));
        fitbC.setText(ansOptions.get(2));
        fitbD.setText(ansOptions.get(3));
    }

    private ArrayList<String> getWordsFromPhrase(String phrase, ArrayList<Word> words) {
        ArrayList<String> ans = new ArrayList<>();
        for (Word word : words) {
            if (phrase.contains(word.getWord())) {
                ans.add(word.getWord());
            }
        }
        return ans;
    }

    private ArrayList<String> getRandomAlternatives(String correct, ArrayList<Word> words) {
        ArrayList<String> alternatives = new ArrayList<>();
        for (Word word : words) {
            if (!word.getWord().equals(correct)) {
                alternatives.add(word.getWord());
            }
        }
        Collections.shuffle(alternatives);
        return new ArrayList<>(alternatives.subList(0, 3));
    }

    @FXML
    void submitAnswer(ActionEvent event) {
        Button pickbutton = (Button) event.getSource();
        String chosenans = pickbutton.getText();

        if (chosenans.equals(correctAnswer)) {
            fitbQuestion.setText("Correct!");
            progress.trackCorrectAnswer();
        } 
        else {
            fitbQuestion.setText("Wrong, go to next question.");
            progress.trackQuestion();
        }
    }

    @FXML
    void gotonext(ActionEvent event) {
        currPhrase = null;
        missingWord = null;
        correctAnswer = null;

        fitbQuestion.setText("");
        enableButtons();

        String userCategory = progress.getCurrentCategory();
        displayQuestion(userCategory);
    }


     @FXML
    void backtoActivities(ActionEvent event) throws IOException {
        //progress.saveProgress();
        App.setRoot("activities");
    }

    @FXML 
    void showHint(ActionEvent event) throws IOException {
        hintLabel.setText(currPhrase.getTranslation());
    }

    @FXML
    void disableButtons() {
        fitbA.setDisable(true);
        fitbB.setDisable(true);
        fitbC.setDisable(true);
        fitbD.setDisable(true);
    }

    @FXML
    void enableButtons() {
        fitbA.setDisable(false);
        fitbB.setDisable(false);
        fitbC.setDisable(false);
        fitbD.setDisable(false);
    }
}