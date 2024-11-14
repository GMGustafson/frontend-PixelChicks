package com.controllers;

import com.chatterbox.App;
import java.io.IOException;
import javafx.fxml.FXML;
import com.narration.*;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        Narriator.playSound("Hi my name is Grace Gustafson");
        App.setRoot("primary");
    }
}