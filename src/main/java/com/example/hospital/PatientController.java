package com.example.hospital;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientController {

    @FXML
    private TextField addressTextField;

    @FXML
    private TableColumn<Patient, String> entryPointColumn;

    @FXML
    private ComboBox<String> entryPointCombo;

    @FXML
    private TableColumn<Patient, String> firstNameColumn;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    private TableColumn<Patient, String> hospitalNumberColumn;

    @FXML
    private TextField hospitalNumberTextField;

    @FXML
    private TableColumn<Patient, String> lastNameColumn;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TableColumn<Patient, String> occupationColumn;

    @FXML
    private TextField occupationTextField;

    @FXML
    private TableColumn<Patient, String> patientAddressColumn;

    @FXML
    private TableColumn<Patient, String> patientGenderColumn;

    @FXML
    private TableColumn<Patient, String> patientPhoneColumn;

    @FXML
    private ComboBox<String> referralCombo;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TableColumn<Patient, String> referralColumn;

    @FXML
    private TableView<Patient> patientTableView;
    @FXML
    private TextField ageTextField;


    @FXML
    void addButtonClicked(ActionEvent event) {
        Patient p = new Patient(firstNameTextField.getText(), lastNameTextField.getText(),
                hospitalNumberTextField.getText(), ageTextField.getText(), addressTextField.getText(), phoneTextField.getText(),
                genderCombo.getValue(), occupationTextField.getText(), entryPointCombo.getValue(),
                referralCombo.getValue());

    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {
        ObservableList<Patient> allPatients, selectedRow;
        allPatients = patientTableView.getItems();
        selectedRow = patientTableView.getSelectionModel().getSelectedItems();

        for (Patient p : selectedRow)
            allPatients.remove(p);
    }

    @FXML
    void editAddressColumn(ActionEvent event) {

    }

    @FXML
    void editEntryPointColumn(ActionEvent event) {

    }

    @FXML
    void editFirstNameColumn(ActionEvent event) {

    }

    @FXML
    void editHospitalNumberColumn(ActionEvent event) {

    }

    @FXML
    void editLastNameColumn(ActionEvent event) {

    }

    @FXML
    void editOccupationColumn(ActionEvent event) {

    }

    @FXML
    void editPatientGenderColumn(ActionEvent event) {

    }

    @FXML
    void editPatientPhoneColumn(ActionEvent event) {

    }

    @FXML
    void editReferralColumn(ActionEvent event) {

    }

    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
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
}