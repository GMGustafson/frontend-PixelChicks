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
    private Button next;
 

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
        // System.out.print(this.course); 
    }   

    @FXML
    void readStoryAloud(ActionEvent event) {
        Narriator.playSound(concatSpanishText()); 
        // "En la tienda, Tom compra una manzana roja.También busca dos naranjas maduras.Finalmente compra tres plátanos amarillos."
    }

    private CategorySystemFacade facade;
    private Story story;
    private User user;
    private Course course; 
    private Progress progress; 
    private String category; 

    @FXML
    void Translate(ActionEvent event) {

        facade = CategorySystemFacade.getFacadeInstance();
        progress = facade.getProgress(); 
        category = progress.getCurrentCategory(); 
        story = DataLoader.getStorybyCategory(null);
        course = user.getCurrentCourse(); 
        storyTitle.setText(story.getTitle()); 

        SpanishText.setText("hola");
    
        
        SpanishText.setText(concatSpanishText()); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        englishText.setText(concatText());
        storyTitle.setText(story.getTitle()); 
        // englishText.setText("hii"); 
    }

    @FXML
    void goToNextStory(ActionEvent event) {
        // storyTitle.setText("title2" ); 
        // englishText.setText("hiiiiiii"); 

    }

    private String concatText()
    { 
        String concatText = " ";
        for (String t : story.getText()) 
        {
        concatText = concatText + story.getText(); 
         }
        return concatText;
    }

    private String concatSpanishText()
    { 
        String concatText = " ";
        for (String t : story.getStoryTranslation()) 
        {
        concatText = concatText + story.getStoryTranslation(); 
         }
        return concatText;
    }
   
   
}





