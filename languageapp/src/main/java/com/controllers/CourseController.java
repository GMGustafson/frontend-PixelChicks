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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
    
public class CourseController implements Initializable {
    
        @FXML
        private Button catColors;
    
        @FXML
        private Button catNumbers;
    
        @FXML
        private Button catPeople;
    
        @FXML
        private Button catPlaces;
    
        @FXML
        private Button catWeather;
    
        @FXML
        private Label courseLabel;
    
        @FXML
        private AnchorPane courses;
    
        @FXML
        private Button next;

        @FXML Label categoryLabel;

        private CategorySystemFacade facade;
        private User user;
        private String userCategory;
        private Progress progress;
<<<<<<< HEAD
        private Course course; 
=======
        private Course course;

>>>>>>> e312ced3ddeb7fabf663a2190e139f10373533a0
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            facade = CategorySystemFacade.getFacadeInstance();
            user = facade.getCurrentUser();
<<<<<<< HEAD
            progress = facade.getProgress();
            // course = progress.get(); 

            currentCategory = progress.getCurrentCategory();
            if (user.getCurrentProgress() != null) {
=======
            course = user.getCurrentCourse(); 
            progress = user.getCurrentProgress(); 
            userCategory = progress.getCurrentCategory(); 
            if ( progress != null) {
>>>>>>> e312ced3ddeb7fabf663a2190e139f10373533a0
                courseLabel.setText("Welcome back, " + user.getUsername());
                userCategory = progress.getCurrentCategory();
                categoryLabel.setText("Loading previous progress");

            }
            courseLabel.setText("Welcome, " + user.getUsername());
        }

        @FXML
        void chooseColors(ActionEvent event) throws IOException {
            String catType = "colors";
            userCategory = progress.setCurrentCategory(catType);
            // categoryLabel.setText("Colors");
            // App.setRoot("activities");
        }
    
        @FXML
        void chooseNumbers(ActionEvent event) throws IOException {
            String catType = "Numbers";
            userCategory = progress.setCurrentCategory(catType);
            // categoryLabel.setText("Numbers");
            // App.setRoot("activities");
        }
    
        @FXML
        void choosePeople(ActionEvent event) throws IOException {
            String catType = "people";
            userCategory = progress.setCurrentCategory(catType);
            // categoryLabel.setText("People");
            // App.setRoot("activities");

        }
    
        @FXML
        void choosePlaces(ActionEvent event) throws IOException{
            String catType = "places";
            userCategory = progress.setCurrentCategory(catType);
            // categoryLabel.setText("Places");
            // App.setRoot("activities");
        }
    
        @FXML
        void chooseWeather(ActionEvent event) throws IOException {
<<<<<<< HEAD
            currentCategory = "Weather";
=======
            String catType = "weather";
            userCategory = progress.setCurrentCategory(catType);
            // categoryLabel.setText("Weather");
            // App.setRoot("activities");
>>>>>>> e312ced3ddeb7fabf663a2190e139f10373533a0
        }
    
        @FXML
        void toActivities(ActionEvent event) throws IOException {
            App.setRoot("activities");
        }
    
}
    



