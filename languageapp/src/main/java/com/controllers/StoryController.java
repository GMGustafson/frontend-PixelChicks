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

    @FXML
    void Translate(ActionEvent event){ 
        // Story Story = course.getStoriesByCategory("numbers");
        CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance(); 
        // user = facade.getCurrentUser(); 
        // course = user.
        // course.getCourse();
        
        facade.chooseCourse(course).getStoriesByCategory("numbers"); 

        // facade.getCurrentUsegetCurrentCourse().getStoriesByCategory("numbers"); 

        storyTitle.setText(story.getTitle()); 
        // englishText.setText(story.getText());
        // SpanishText.setText(story.getStoryTranslation()); 
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

<<<<<<< HEAD
    // @Override
    // public void initialize(URL location, ResourceBundle resources) {
    // }

   
=======
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    private Story co;
    course = facade.chooseCourse(course);
    co = course.getStoriesByCategory("colors");
>>>>>>> db62429f698719d9c5f0a4c9efee26e62408b593

    // @Override
    // public void initialize(URL location, ResourceBundle resources) {
    //     story = Story.getStorybycategory("numbers");
    //     CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance(); 

    //     storyTitle.setText(story.getTitle()); 
    //     englishText.setText(story.getText());
    //     SpanishText.setText(story.getStoryTranslation()); 
    // }

  

}




