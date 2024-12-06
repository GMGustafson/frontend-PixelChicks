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
        private String currentCategory;
        private Progress progress;
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            facade = CategorySystemFacade.getFacadeInstance();
            user = facade.getCurrentUser();
            progress = facade.getProgress();
            course = user.getCourse();
            currentCategory = progress.getCurrentCategory();
            if (user.getCurrentProgress() != null) {
                courseLabel.setText("Welcome back, " + user.getUsername());
                currentCategory = progress.getCurrentCategory();
                categoryLabel.setText("Loading previous progress");

            }
            courseLabel.setText("Welcome, " + user.getUsername());
        }

        @FXML
        void chooseColors(ActionEvent event) throws IOException {
            currentCategory = "Colors";
        }
    
        @FXML
        void chooseNumbers(ActionEvent event) throws IOException {
            currentCategory = "Numbers";
        }
    
        @FXML
        void choosePeople(ActionEvent event) throws IOException {
            currentCategory = "People";
        }
    
        @FXML
        void choosePlaces(ActionEvent event) throws IOException{
            currentCategory = "Places";

        }
    
        @FXML
        void chooseWeather(ActionEvent event) throws IOException {
            currentCategory = "Weather";
            App.setRoot("activities");
        }
    
        @FXML
        void toActivities(ActionEvent event) throws IOException {
            App.setRoot("activities");
        }
    
}
    



