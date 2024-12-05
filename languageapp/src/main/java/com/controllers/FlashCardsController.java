
package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.CategorySystemFacade;
import com.model.Category;
import com.model.Course;
import com.model.Flashcard;
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
    private Label wordLabel;

    @FXML
    private Label categ;

    @FXML
    private Pane pane;
    @FXML
    private Label showcard;
    private String[] words = {"rojo", "verde", "blanco"};
    private int index = 0;
  

    @FXML
    void backtoActivites(ActionEvent event) {

    }

    @FXML
    void goNext(MouseEvent event) throws IOException{
        wordLabel.setText(words[index]);
        index = (index + 1) % words.length;
    }

    @FXML
    void goBack(MouseEvent event) throws IOException{
        index = (index - 1 + words.length) % words.length; 
        wordLabel.setText(words[index]);
    }

    @FXML
    void translateCard(MouseEvent event) throws IOException{
        forward.setText(words[index]);
        index = (index + 1) % words.length;
    }

    private CategorySystemFacade facade;
    private User user;
    private Course category;
    private Course course;
    private Flashcard flashcard;
    private Story co;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser(); 
        // course = facade.chooseCourse(course);
        // co = course.getStoriesByCategory("colors");

        
        showcard.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
        
        categ.setText(category.getCategory());


    }

    
    private void displayFlashcardWords(){
        ArrayList<Word> words = category.getWordsByCategory(null);
        for (int i=0; i < words.size(); i++) {
            Word flashwords = words.get(i);
            

        }
    }

}
  


    // private void showCard(){
    //     CategorySystemFacade facade = facade.getFacadeInstance();
    // }


