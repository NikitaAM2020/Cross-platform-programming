module com.example.lab6banknew {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab6banknew to javafx.fxml;
    exports com.example.lab6banknew;
}