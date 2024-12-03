package com.controllers;

import java.io.IOException;

import com.chatterbox.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class CourseController {

    @FXML
    private MenuItem categoryColors;
    @FXML
    private MenuItem categoryNumbers;
    @FXML
    private MenuItem categoryPeople;
    @FXML
    private MenuItem categoryWeather;
    @FXML
    private MenuButton chooseCategories;
    @FXML
    private MenuButton chooseCourses;
    @FXML
    private MenuItem coursePhrases;
    @FXML
    private MenuItem courseWords;
    @FXML
    private Button next2;

    @FXML
    void chooseColors(ActionEvent event) {
        
    };

    @FXML
    void chooseCourse(MouseEvent event) {

    };

    @FXML
    void chooseNumbers(ActionEvent event) {

    };

    @FXML
    void choosePeople(ActionEvent event) {

    };

    @FXML
    void choosePhrases(ActionEvent event) {

    };

    @FXML
    void chooseWeather(ActionEvent event) {

    };

    @FXML
    void chooseWords(ActionEvent event) {

    };

    @FXML
    void showCategories(ActionEvent event) {

    }

    @FXML
    void showCourses(MouseEvent event) {

    }
    

    @FXML
    void GoToNext(ActionEvent event) throws IOException {
        App.setRoot("matching");

    }

}
