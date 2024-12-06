package com.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.Course;
import com.model.User;
import com.model.Word;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MockConvoController implements Initializable{

    @FXML
    private Label Hint;

    @FXML
    private Label Question;

    @FXML
    private Button back;

    @FXML
    void HintWillAppear(ActionEvent event) throws IOException {
        Hint.setText("Hint");
    }

    @FXML
    void QuestionWillAppear(ActionEvent event) throws IOException {
        Question.setText("Question");
    }
    @FXML
    void backtoActivites(ActionEvent event) throws IOException {
         App.setRoot("activities");
    }

    @FXML
    private ImageView parimage;

    private CategorySystemFacade facade;
    private User user;
    private Course category;
    private Course course;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();  
    }   
}

    
