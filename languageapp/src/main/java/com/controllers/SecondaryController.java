package com.controllers;

import com.chatterbox.App;
import java.io.IOException;
import javafx.fxml.FXML;
import com.narration.Main;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        System.out.println("YOU CICKED THE BUTTON");
        App.setRoot("primary");
    }
}