module com.chatterbox {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.chatterbox to javafx.fxml;
    exports com.chatterbox;
}
