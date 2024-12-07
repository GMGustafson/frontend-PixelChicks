package com.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.chatterbox.App;
import com.model.CategorySystemFacade;
import com.model.CourseList;
import com.model.Progress;
import com.model.User;
import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private Button Back;

    @FXML
    void GoBack(ActionEvent event) throws IOException{
                App.setRoot("activities"); 
    }

    private CategorySystemFacade facade;
    private Progress progress; 
    private User user; 

    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Hi inside"); 

        System.out.println("null"); 
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser(); 
        System.out.println(user.getFirstName());
        progress = user.getCurrentProgress();
       
        if (this.progress == null)
        { 
            Score.setText("No Progress yet"); 
           
        }
        else { 
            System.out.println("not null"); 
            facade = CategorySystemFacade.getFacadeInstance();
            user = facade.getCurrentUser(); 
            progress = user.getCurrentProgress(); 
            TotalWrong.setText("" + (progress.getTotalQuestionsAnswered() - progress.getNumCorrectAnswers())); 
            TotalCorrect.setText("" + (progress.getNumCorrectAnswers())); 
            TotalAnswered.setText("" + (progress.getTotalQuestionsAnswered()));
            Score.setText("" + (progress.getNumCorrectAnswers() / progress.getTotalQuestionsAnswered()));
            System.out.println("Total Questions Answered: " + progress.getTotalQuestionsAnswered());
            System.out.println("Number of Correct Answers: " + progress.getNumCorrectAnswers());

        }
       
    }

}
