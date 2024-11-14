package com.controllers;

import java.io.IOException;
import com.chatterbox.App;
import com.narration.*;
import javafx.fxml.FXML;

public class PrimaryController {

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
