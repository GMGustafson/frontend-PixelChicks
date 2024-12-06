package com.controllers;

import java.io.IOException;
import java.net.URL;
// import java.util.ArrayList;
// import java.util.Map;
import java.util.ResourceBundle;
// import java.util.Locale.Category;

// import org.json.simple.JSONObject;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Course;
import com.model.DataLoader;
import com.model.Progress;
import com.model.Story;
import com.model.User;
// import com.model.Word;
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
    private Button translate;
 

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }   

    @FXML
    void readStoryAloud(ActionEvent event) {
        Narriator.playSound(concatSpanishText()); 
    }

    private CategorySystemFacade facade;
    private Story story;
    private User user;
    private Course course; 
    private String userCategory; 
    private Progress progress; 

    @FXML
    void Translate(ActionEvent event) {

        
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        course = user.getCurrentCourse(); 
        progress = user.getCurrentProgress(); 
        userCategory = progress.getCurrentCategory();
        
        story = course.getStoriesByCategory(userCategory); 
         
        System.out.println(userCategory);
        storyTitle.setText(story.getTitle());
        SpanishText.setText(concatSpanishText()); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        course = user.getCurrentCourse(); 
        progress = user.getCurrentProgress(); 
        userCategory = progress.getCurrentCategory(); 
        
        System.out.println(userCategory); 


        story = course.getStoriesByCategory(userCategory); 
        englishText.setText(concatText());
        storyTitle.setText(story.getTitle());
         
        
    }


    private String concatText()
    { 
        String concatText = ""; // Start with an empty string
        for (String t : story.getText()) 
        {
            concatText = concatText + t; // Append each individual string `t`
        }
        return concatText;
    }
    

    private String concatSpanishText()
{ 
    String concatText = ""; 
    for (String t : story.getStoryTranslation()) 
    {
        concatText = concatText + t;
    }
    return concatText;
}
   
   
}





