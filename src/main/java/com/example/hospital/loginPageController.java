package com.example.hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    private final Alert logInAlert = new Alert(Alert.AlertType.CONFIRMATION);
    private final Alert signUpAlert = new Alert(Alert.AlertType.CONFIRMATION);

    private final Alert databaseAlert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    public void loginButtonClicked(ActionEvent event) throws IOException {
//        if (Objects.equals(usernameTextField.getText(), "nechcodes") &&
//                Objects.equals(passwordTextField.getText(), "1234")) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homepage.fxml")));
            Scene scene = new Scene(root, 800, 600);
            Stage stage = new Stage();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            stage.setTitle("Homepage");
            stage.setScene(scene);
            stage.show();
//        }
//        else {
//            logInAlert.setTitle("Failed");
//            logInAlert.setHeaderText("Incorrect username or password");
//            logInAlert.setContentText("Click 'sign Up'");
//            logInAlert.showAndWait();
//        }
    }

    @FXML
    public void signUpButtonClicked() {
        signUpAlert.setTitle("Success");
        signUpAlert.setHeaderText("You successfully created an account");
        signUpAlert.setContentText("USERNAME: nechcodes\nPASSWORD: 1234");
        signUpAlert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
