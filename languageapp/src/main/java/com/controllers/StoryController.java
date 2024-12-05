package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Course;
import com.model.DataLoader;
import com.model.Flashcard;
import com.model.Story;
import com.model.User;
import com.model.Word;
import com.narration.Narriator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StoryController implements Initializable {

    @FXML
    private Label SpanishText;

    @FXML
    private Button back;

    @FXML
    private Label englishText;

    @FXML
    private Button readStoryButton;

    @FXML
    private Label storyTitle;
 

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }   

    @FXML
    void readStoryAloud(ActionEvent event) {
        Narriator.playSound("En la tienda, Tom compra una manzana roja.También busca dos naranjas maduras.Finalmente compra tres plátanos amarillos."); 
    }

    private CategorySystemFacade facade;
    private User user;
    private Course course;
    private Course co;
    private Story story;
    private Story sto;

    @FXML
    void Translate(ActionEvent event) {

        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser(); 
        course = facade.getCurrentCourse();
        //co = course.getStoriesByCategory("colors");

        storyTitle.setText(story.getTitle()); 
        // englishText.setText(story.getText());
        // SpanishText.setText(story.getStoryTranslation()); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void displayStory(){
    ArrayList<Story> stories = course.getStoriesByCategory("colors");
        for (int i=0; i < stories.size(); i++) {
            Story storysentence = stories.get(i);
            

        }

    
    
  

}


