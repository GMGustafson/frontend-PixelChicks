package com.controllers;

import com.chatterbox.App;
import java.io.IOException;
import com.narration.*;
import javafx.fxml.FXML;

public class PrimaryController {

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
