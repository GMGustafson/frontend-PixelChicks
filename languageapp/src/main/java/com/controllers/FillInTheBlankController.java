package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.model.*;

public class FillInTheBlankController implements Initializable{

    private Progress progress;

    @FXML
    private Button A;

    @FXML
    private Button B;

    @FXML
    private Button C;

    @FXML
    private Button D;

    @FXML
    private Button back;

    @FXML
    private Button hint;

    @FXML 
    private Label hintLabel;

    @FXML
    private Label fitbQuestion;
    private CourseList courseList;
    private CourseList course;
    private User user;
    private CategorySystemFacade facade;
    private UserList userList;
    private CategorySystemFacade currentCategory;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = CategorySystemFacade.getFacadeInstance();
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
        currentCategory = facade.chooseCategory();

        fitbQuestion.setText(" " + facade.getQuestion() + " ");
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }




    @FXML
    void chooseA(ActionEvent event) {
        
        progress.trackQuestion();
    }

    @FXML
    void chooseB(ActionEvent event) {
        B.setText("X");
        progress.trackQuestion();
    }

    @FXML
    void chooseC(ActionEvent event) {
        C.setText("X");
        progress.trackQuestion();
    }

    @FXML
    void chooseD(ActionEvent event) {
        D.setText("CORRECT!");
        progress.trackCorrectAnswer();
    }

    @FXML
    void showHint(ActionEvent event) {

        if (hintLabel.equals("Hint")) {
        hintLabel.setText("equals");
        }
        else {
        hintLabel.setText("Hint");

    @FXML
    void backtoActivities(ActionEvent event) throws IOException{
            App.setRoot("activities");
    }
}