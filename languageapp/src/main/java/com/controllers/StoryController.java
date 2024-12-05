package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Course;
import com.model.Story;
import com.narration.Narriator;
import com.model.User;
import com.model.*; 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StoryController  {

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

   private User user; 
   private Course course; 
   private Story co;
   

    @FXML
    void Translate(ActionEvent event){ 
        CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance(); 
        course = facade.chooseCourse(course);
        co = course.getStoriesByCategory("colors");
        
       
        storyTitle.setText(story.getTitle()); 
        englishText.setText(story.getText());
        SpanishText.setText(story.getStoryTranslation()); 
    }
    
    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }   

    @FXML
    void readStoryAloud(ActionEvent event) {
        Narriator.playSound("En la tienda, Tom compra una manzana roja.También busca dos naranjas maduras.Finalmente compra tres plátanos amarillos."); 
    }

    private Story story;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    

    // @Override
    // public void initialize(URL location, ResourceBundle resources) {
    //     story = Story.getStorybycategory("numbers");
    //     CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance(); 

    //     storyTitle.setText(story.getTitle()); 
    //     englishText.setText(story.getText());
    //     SpanishText.setText(story.getStoryTranslation()); 
    // }

  

}




