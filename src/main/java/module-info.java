module com.example.hospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hospital to javafx.fxml;
    exports com.example.hospital;
}