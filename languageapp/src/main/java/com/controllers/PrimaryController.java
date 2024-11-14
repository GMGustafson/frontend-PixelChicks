package com.controllers;

<<<<<<< HEAD
import java.io.IOException;
import javafx.fxml.FXML; 
=======
>>>>>>> 887b5c48623ac388e53b844baa5ba6e0932e0d9a
import com.chatterbox.App;
import java.io.IOException;
import com.narration.*;
import javafx.fxml.FXML;

public class PrimaryController {

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
