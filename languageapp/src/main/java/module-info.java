module com.chatterbox {
    requires javafx.controls;
    requires javafx.fxml; 
    requires json.simple; 
    requires jlayer; 
    requires junit;
    requires software.amazon.awssdk.core; 
    requires software.amazon.awssdk.services.polly; 
    requires software.amazon.awssdk.regions; 
    requires software.amazon.awssdk.utils; 
    requires org.slf4j; 
    requires org.slf4j.simple; 
    requires software.amazon.awssdk.awscore; 
    requires software.amazon.eventstream;
    requires javafx.graphics; 


    opens com.chatterbox to javafx.fxml;
    exports com.chatterbox;

    opens com.controllers to javafx.fxml;
    exports com.controllers;

    opens com.narration to javafx.fxml;
    exports com.narration;

    // opens com.model to javafx.fxml;
    // exports com.model;

}
