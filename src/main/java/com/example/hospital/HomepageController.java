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
    public void doctorButtonClicked(ActionEvent actionEvent) {
    }

    public void patientButtonClicked(ActionEvent actionEvent) {
    }

        @FXML
        private Button pharmacyButton;

        @FXML
        void A(ActionEvent event) {

        }

        @FXML
        void D(ActionEvent event) {

        }

        @FXML
        void P(ActionEvent event) {

        }

        @FXML
        void logout(ActionEvent event) {

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

