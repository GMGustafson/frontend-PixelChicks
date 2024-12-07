
package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.model.CategorySystemFacade;
import com.chatterbox.App;
import com.model.Category;
import com.model.Course;
import com.model.Flashcard;
import com.model.Progress;
import com.model.Story;
import com.model.User;
import com.model.Word;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class FlashCardsController implements Initializable {
    @FXML
    private Button Back;

    @FXML
    private Button forward;

    @FXML
    private Button prev;

    @FXML
    private Button Relearn;

    @FXML
    private Label wordLabel;

    @FXML
    private Label categ;

    @FXML
    private Pane pane;
    @FXML
    private Label showcard;

    @FXML
    void backtoActivites(ActionEvent event) throws IOException{
         App.setRoot("activities");
    }


    @FXML
    void tobeginning(MouseEvent event) throws IOException{
        index = 0;
        displayCard();
    }

    @FXML
    void goNext(MouseEvent event) throws IOException{
        index = (index + 1) % wordList.size();
        displayCard();
    }

    @FXML
    void goBack(MouseEvent event) throws IOException{
        index = (index - 1 + wordList.size()) % wordList.size();
        displayCard();
    }

    @FXML
    void translateCard(MouseEvent event) throws IOException{
        Word currentWord = wordList.get(index);
        if (translate) {
            wordLabel.setText(currentWord.getTranslation());
        } 
        else {
            wordLabel.setText(currentWord.getWord());
        }
        translate = !translate;
    }

    private CategorySystemFacade facade;
    private User user;
    private Course category;
    private Course course;
    private Flashcard flashcard;
    private ArrayList<Word> wordList; 
    private Word currWord;
    private int index = 0;
    private boolean translate = false; 
    private Progress progress; 
    private String userCatergory; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser(); 
        course = facade.chooseCourse(course);
        category = user.getCurrentCourse();
        progress = user.getCurrentProgress(); 
        userCatergory = progress.getCurrentCategory(); 
        wordList = category.getWordsByCategory(userCatergory);
        categ.setText(userCatergory);
         
        displayCard();
    }

    
    private void displayCard(){
        Word currentWord = wordList.get(index);
        wordLabel.setText(currentWord.getTranslation());
        translate = false;

    }

}

