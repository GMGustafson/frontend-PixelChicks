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
        System.out.println("Hi inside"); 
        if (this.progress == null)
        { 
            System.out.println("null"); 
            facade = CategorySystemFacade.getFacadeInstance();
            progress = facade.getProgress(); 
            Score.setText("No Progress yet"); 
        }
        else { 
            System.out.println("not null"); 
            facade = CategorySystemFacade.getFacadeInstance();
            progress = facade.getProgress(); 
            TotalWrong.setText("" + (progress.getTotalQuestionsAnswered() - progress.getNumCorrectAnswers())); 
            TotalCorrect.setText("" + (progress.getNumCorrectAnswers())); 
            TotalAnswered.setText("" + (progress.getTotalQuestionsAnswered()));
            Score.setText("" + (progress.getNumCorrectAnswers() / progress.getTotalQuestionsAnswered()));

        }
       
    }

}
