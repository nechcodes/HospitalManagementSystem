package com.example.hospital;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class loginPageController implements Initializable {
    private String hospitalName;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    private Alert logInAlert = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert signUpAlert = new Alert(Alert.AlertType.CONFIRMATION);
    @FXML
    private Label welcomeText;


    @FXML
    private Label hospitalInfo = new Label();

    public void setText() {
        hospitalInfo.setText(getHospitalName());
    }

    @FXML
    public void loginButtonClicked(ActionEvent event) throws IOException {
        setText();

        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Homepage");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void signUpButtonClicked(ActionEvent event) {
        signUpAlert.setTitle("Success");
        signUpAlert.setHeaderText("You successfully created an account");
        signUpAlert.setContentText("Never share your password please");
        signUpAlert.showAndWait();
    }


    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = "NECH Hospitals";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
