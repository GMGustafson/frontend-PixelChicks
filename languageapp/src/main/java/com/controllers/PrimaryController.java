package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML; 
import com.chatterbox.App;
import java.io.IOException;
import com.narration.*;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Narriator.playSound("Hola Mundo");
        App.setRoot("secondary");
    }
}
