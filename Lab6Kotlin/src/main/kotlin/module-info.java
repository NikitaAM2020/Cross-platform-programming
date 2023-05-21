module com.example.lab6kotlin {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.lab6kotlin to javafx.fxml;
    exports com.example.lab6kotlin;
}