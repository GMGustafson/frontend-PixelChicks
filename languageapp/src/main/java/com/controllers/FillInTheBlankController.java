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

    private CategorySystemFacade facade;
    private User user;
    private String userCategory;
    private FillInTheBlank fillInTheBlank;
    private Word word;
    private Phrase randomPhrase;
    private String correctAnswer;
    private String sentence;
    private Progress progress;
    private String missingWord;
    private String correctWord ;
    private Phrase sampleSentence;
    private String question;
    private ArrayList<String> answers;
    private Course course;
    private ArrayList<Phrase> phrases;
    private Random random;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance();
        fillInTheBlank = facade.getFillintheBlank();
        if (fillInTheBlank == null) {
            throw new IllegalStateException("FillInTheBlank is not initialized correctly.");
        }
        user = facade.getCurrentUser();
        course = user.getCurrentCourse();
        progress = user.getCurrentProgress();
        fillInTheBlank = facade.getFillintheBlank();
        userCategory = progress.getCurrentCategory();
        phrases = course.getPhrasesByCategory(userCategory);
        random = new Random();
        displayQuestions();
        
        /*
         * 1. Load a random spanish phrase from a specific category in Course.json using Phrase method
         * 2. Convert it into the question using a method that picks out a missing word
         *    and changes that area to "____"
         * 3. MissingWord needs to pick out a word and ensures it is a word that exists in the list of words from Course.json
         * 4. A method needs to use the word chosen to load alternatives from Course.json using Word method in ArrayList<String>
         * 5. Missing word and 3 random alternatives need to moved to 4-element ArrayList<String> and then shuffled
         * 6. The buttons need to have the different words assigned to them
         */
       
        System.out.print("FillInTheBlank" + fillInTheBlank);
  
        showCategory.setText("Category: " + userCategory);

        System.out.println("category =" + userCategory);
       
        System.out.println("Phrases available: " + phrases);
        // Load the hint by category
        System.out.println("Phrases available: " + phrases);
        if (phrases == null || phrases.isEmpty()) {
        throw new IllegalStateException("No phrases available for the selected category!");
        }
    }

        private void displayQuestions() {
            sampleSentence = phrases.get(random.nextInt(phrases.size()));
            sentence = sampleSentence.getWords();
            question = fillInTheBlank.getSentence();
            missingWord = fillInTheBlank.getMissingWord();
            fitbQuestion.setText(question);
        }


            // if (phrases != null && !phrases.isEmpty()) {
            //     Random random = new Random();
            //     int randomIndex = random.nextInt(phrases.size());
            //     randomPhrase = phrases.get(randomIndex);
            //     if (randomPhrase == null) {
            //         throw new IllegalStateException("Random phrase is null. Check data source!");
            //     }


            //     fillInTheBlank.setSampleSentence(randomPhrase);
            //     sampleSentence = fillInTheBlank.getSampleSentence();
            //     fitbQuestion.setText(fillInTheBlank.getSentence());
            //     sentence = fillInTheBlank.getSentence();


            //     System.out.println("Sample Sentence: " + sampleSentence);
            //     System.out.println("Sentence: " + sentence);
            //     System.out.println("Missing Word: " + missingWord);

            //     fillInTheBlank.setSentence(sentence);
            //     question = fillInTheBlank.getSentence();
            //     missingWord = fillInTheBlank.getMissingWord();
            //     answers = fillInTheBlank.getWordBank();



        // // Get answers
        // ArrayList<String> answers = fillInTheBlank.getOtherAnswers();
        // answers.add(correctAnswer);
        // Random random = new Random();
        // ArrayList<String> shuffledAnswers = new ArrayList<>(answers);
        // for (int i = 0; i < shuffledAnswers.size(); i++) {
        //     int swapIndex = random.nextInt(shuffledAnswers.size());
        //     String temp = shuffledAnswers.get(i);
        //     shuffledAnswers.set(i, shuffledAnswers.get(swapIndex));
        //     shuffledAnswers.set(swapIndex, temp);
        // }
        // answers = fillInTheBlank.getOtherAnswers();
        // answers.add(correctAnswer);
        // random = new Random();
        // shuffledAnswers = new ArrayList<>(answers);
        // for (int i = 0; i < shuffledAnswers.size(); i++) {
        //     int swapIndex = random.nextInt(shuffledAnswers.size());
        //     String temp = shuffledAnswers.get(i);
        //     shuffledAnswers.set(i, shuffledAnswers.get(swapIndex));
        //     shuffledAnswers.set(swapIndex, temp);
        // }


    //     fitbQuestion.setText(sentence);


    //     fitbA.setText(shuffledAnswers.get(0));
    //     fitbB.setText(shuffledAnswers.get(1));
    //     fitbC.setText(shuffledAnswers.get(2));
    //     fitbD.setText(shuffledAnswers.get(3));


    //     throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    // }


    @FXML
    void backToActivities(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

    @FXML
    void chooseA(ActionEvent event) {
        // fillInTheBlank.checkAnswer(fitbA.getText());
    if (fitbA.getText().equals(fillInTheBlank.checkAnswer(correctAnswer))) {
        progress.trackCorrectAnswer();
        fitbQuestion.setText(sentence.replace(missingWord, " "));  
    }
    else {
        fitbD.setText("X");
        progress.trackQuestion();

    }
    }

    @FXML
    void chooseC(ActionEvent event) {
        // fillInTheBlank.checkAnswer(fitbC.getText());
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
    
    //fillInTheBlank.checkAnswer(fitbD.getText());
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
        // fillInTheBlank.checkAnswer(fitbB.getText());
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
            hintLabel.setText(sampleSentence.getTranslation());
    }
}


