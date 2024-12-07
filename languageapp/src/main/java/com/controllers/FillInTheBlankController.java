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
    private ArrayList<String> answers;
    private Course course;
    private ArrayList<Phrase> phrases;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance();
        fillInTheBlank = facade.getFillintheBlank();
        user = facade.getCurrentUser();
        progress = user.getCurrentProgress();
        course = user.getCurrentCourse();
        fillInTheBlank = facade.getFillintheBlank();
        userCategory = progress.getCurrentCategory();
        phrases = course.getPhrasesByCategory(userCategory);
        

        //phrases = fillInTheBlank.getPhrases();


        fitbQuestion.setText(getPhraseQuestion());

       
        //fillInTheBlank = facade.getFillintheBlank();

        
      
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
       


        
        // Load the hint by category
        System.out.println("phrases" + phrases); 

            if (phrases != null && !phrases.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(phrases.size());
                sampleSentence = phrases.get(randomIndex); // Get the random Phrase object from the list
                System.out.println("randomPhrase" + sampleSentence); 
                sentence = fillInTheBlank.getSampleSentence();
                System.out.println("Sentence" + sentence); 
                missingWord = fillInTheBlank.getMissingWord();
                System.out.println("Missing Word" + missingWord);
                answers = fillInTheBlank.getWordBank();
                System.out.println("Word Bank" + answers);
                //missingWord = randomPhrase.getWords().getMissingWord(); // Assuming `getMissingWord` returns the correct word
                //fitbQuestion.setText(randomPhrase.getSampleSentence());
            }


        

    //     fillInTheBlank = new FillInTheBlank(
    //         "Fill in the Blank: ",
    //         .getSampleSentence(),
    //         randomPhrase.getTranslation(),
    //         new ArrayList<>(),
    //         new ArrayList<>(),
    //         ""
    // );

        sentence = fillInTheBlank.getSampleSentence();
        missingWord = fillInTheBlank.getMissingWord();
        correctAnswer = missingWord;

        fitbQuestion.setText(sentence);

        //Load the missing word
        String questionString = randomPhrase.getWords();
         

        fitbQuestion.setText(""+ fillInTheBlank.getSampleSentence());
        correctAnswer = fillInTheBlank.getMissingWord();
        //Load the other answers



        //ArrayList<String> wordBank = new ArrayList<>(randomPhrase)
        // load the word and randomly place the missing word in one of the answers
        //ArrayList<Word> altWords = new ArrayList<>(alternatives)
        // Load the rest of the answer choices
        


        
        //ArrayList<Phrase> phrases = course.getPhrasesByCategory(currentCategory);
        // fitbQuestion.setText(""+ fillInTheBlank.getSampleSentence());
        // correctAnswer = fillInTheBlank.getMissingWord();



        // Get answers
        ArrayList<String> answers = fillInTheBlank.getOtherAnswers();
        answers.add(correctAnswer);
        Random random =new Random();
        ArrayList<String> shuffledAnswers = new ArrayList<>(answers);
        for (int i = 0; i < shuffledAnswers.size(); i++) {
            int swapIndex = random.nextInt(shuffledAnswers.size());
            String temp = shuffledAnswers.get(i);
            shuffledAnswers.set(i, shuffledAnswers.get(swapIndex));
            shuffledAnswers.set(swapIndex, temp);
        }

        String sentence = fillInTheBlank.getSampleSentence();

        answers = fillInTheBlank.getOtherAnswers();
        answers.add(correctAnswer);
        random = new Random();
        shuffledAnswers = new ArrayList<>(answers);
        for (int i = 0; i < shuffledAnswers.size(); i++) {
            int swapIndex = random.nextInt(shuffledAnswers.size());
            String temp = shuffledAnswers.get(i);
            shuffledAnswers.set(i, shuffledAnswers.get(swapIndex));
            shuffledAnswers.set(swapIndex, temp);
        }

        fitbQuestion.setText(sentence);

        fitbA.setText(shuffledAnswers.get(0));
        fitbB.setText(shuffledAnswers.get(1));
        fitbC.setText(shuffledAnswers.get(2));
        fitbD.setText(shuffledAnswers.get(3));

        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    private String getPhraseQuestion() {
        if (phrases != null && !phrases.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(phrases.size());
            sampleSentence = phrases.get(randomIndex); // Get the random Phrase object from the list
            System.out.println("randomPhrase" + sampleSentence); 
            sentence = fillInTheBlank.getSampleSentence();
            System.out.println("Sentence" + sentence); 
            missingWord = fillInTheBlank.getMissingWord();
            System.out.println("Missing Word" + missingWord);
            answers = fillInTheBlank.getWordBank();
            System.out.println("Word Bank" + answers);
        }
            return sentence;

    }

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
            hintLabel.setText(sampleHint.getSampleHint());
            
    }


}


