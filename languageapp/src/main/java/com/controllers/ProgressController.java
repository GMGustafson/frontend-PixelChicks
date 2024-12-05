package com.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.CategorySystemFacade;
import com.model.CourseList;
import com.model.Progress;
import com.model.User;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProgressController implements Initializable{

    @FXML
    private Label Score;

    @FXML
    private Label TotalAnswered;

    @FXML
    private Label TotalCorrect;

    @FXML
    private Label TotalWrong;


    private CategorySystemFacade facade;
    private Progress progress; 

    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance();
        progress = facade.getProgress(); 
        TotalWrong.setText("" + (progress.getTotalQuestionsAnswered() - progress.getNumCorrectAnswers())); 
        TotalCorrect.setText("" + (progress.getNumCorrectAnswers())); 
        TotalAnswered.setText("" + (progress.getTotalQuestionsAnswered()));
        Score.setText("" + (progress.getNumCorrectAnswers() / progress.getTotalQuestionsAnswered())); 
    }

}
