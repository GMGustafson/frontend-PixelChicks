package com.controllers;

<<<<<<< HEAD
=======
import java.io.IOException;
import javafx.fxml.FXML; 
>>>>>>> 1600995c4a90e0b8d2ef0abacbe2bcc741e532dd
import com.chatterbox.App;
import java.io.IOException;
import com.narration.*;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
    
        App.setRoot("secondary");
    }
}
