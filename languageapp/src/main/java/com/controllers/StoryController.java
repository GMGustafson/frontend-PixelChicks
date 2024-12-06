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

    private Story story;  // Updated to use Story object

    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
        App.setRoot("activities");
    }

    @FXML
    void readStoryAloud(ActionEvent event) {
        // For reading the story aloud (here you can loop over the text and translate it)
        for (String sentence : story.getText()) {
            Narriator.playSound(sentence);
        }
    }

    @FXML
    void Translate(ActionEvent event) {
        // Ensure the 'story' object is loaded
        if (story != null) {
            storyTitle.setText(story.getTitle());
            englishText.setText(String.join(" ", story.getText()));  // Join lines into a single text block
            SpanishText.setText(String.join(" ", story.getStoryTranslation()));  // Join lines of translation
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Assuming the story is loaded here
        story = StoryLoader.loadStory("languageapp/src/main/java/com/data/course.json");
    }
}
