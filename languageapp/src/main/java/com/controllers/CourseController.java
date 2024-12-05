package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import com.model.*;

public class CourseController implements Initializable{


    @FXML
    private Label lbl_welcome_user;
    @FXML
    private Category category_Colors;
    @FXML
    private Category category_Numbers;
    @FXML
    private Category category_People;
    @FXML
    private Category category_Weather;
    @FXML
    private MenuButton chooseCategories;
    @FXML
    private MenuButton chooseCourses;
    @FXML
    private Course course_Phrases;
    @FXML
    private Course course_Words;
    @FXML
    private Button nextToActivities;


    private CourseList courseList;
    private Category category;
    private Course course;
    private CategorySystemFacade facade;
    private User user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseList = CourseList.getInstance();
        facade = CategorySystemFacade.getFacadeInstance();
        user = facade.getCurrentUser();
        lbl_welcome_user.setText("Welcome, " + user.getUsername() + ".");
       
        chooseCourse();
        chooseCategory();
    }


    //@FXML
    private void chooseCourse() {
       
    }


    //@FXML
    private void chooseCategory() {
        List<String> categoryList = facade.getCategory();
        


    }


    @FXML
    void chooseColors(ActionEvent event) throws IOException {
        Category chosenCategory = category_Colors;
        facade.chooseCategory(chosenCategory);
    };


    @FXML
    void chooseCourse(MouseEvent event) {


    };


    @FXML
    void chooseNumbers(ActionEvent event) {
        Category chosenCategory = category_Numbers;
        facade.chooseCategory(chosenCategory);
    };


    @FXML
    void choosePeople(ActionEvent event) {
        Category chosenCategory = category_People;
        facade.chooseCategory(chosenCategory);
    };


    @FXML
    void choosePhrases(ActionEvent event) {
        Course chosenCourse = course_Phrases;
        facade.chooseCourse(chosenCourse);
    };


    @FXML
    void chooseWeather(ActionEvent event) {
        Category chosenCategory = category_Weather;
        facade.chooseCategory(chosenCategory);


    };


    @FXML
    void chooseWords(ActionEvent event) {
        Course chosenCourse = course_Words;
        facade.chooseCourse(chosenCourse);


    };


    @FXML
    void showCategories(String category) {
       
    }

    @FXML
    void showCourses(MouseEvent event) {

    }

    @FXML
    void GoToNext(ActionEvent event) throws IOException {
        App.setRoot("activities");

    }


}
