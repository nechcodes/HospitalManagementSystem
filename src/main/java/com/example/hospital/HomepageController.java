package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {
    @FXML
    private Button pharmacyButton;
    @FXML
    private Button doctorButton;
    @FXML
    private Button patientButton;
    @FXML
    private Button appointmentButton;
    @FXML
    private Button logoutButton;
    @FXML
    void appointmentButtonClicked(ActionEvent event) throws IOException{

    }
    @FXML
    void staffButtonClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("staff.fxml"));
        Scene scene = new Scene(root, 1200, 600);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Staff");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void patientButtonClicked(ActionEvent event) throws IOException{

    }
    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void pharmacyButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Scene scene = new Scene(root, 1200, 600);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Pharmacy");
        stage.setScene(scene);
        stage.show();
    }

}