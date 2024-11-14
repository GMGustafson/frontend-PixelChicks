module com.chatterbox {
    requires javafx.controls;
    requires javafx.fxml; 
    requires json.simple; 
    requires jlayer; 
    requires software


    opens com.chatterbox to javafx.fxml;
    exports com.chatterbox;
}
