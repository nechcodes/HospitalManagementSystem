package com.example.hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private TableColumn<Patient, String> ageColumn;
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
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    @FXML
    void addButtonClicked(ActionEvent event) {
        Patient p = new Patient(firstNameTextField.getText(), lastNameTextField.getText(),
                hospitalNumberTextField.getText(), ageTextField.getText(), addressTextField.getText(), phoneTextField.getText(),
                genderCombo.getValue(), occupationTextField.getText(), entryPointCombo.getValue(),
                referralCombo.getValue());
        patientTableView.getItems().add(p);
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
    void editAddressColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editEntryPointColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editFirstNameColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editHospitalNumberColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editLastNameColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editOccupationColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editPatientGenderColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editPatientPhoneColumn(TableColumn.CellEditEvent<Patient, String> event) {

    }

    @FXML
    void editReferralColumn(TableColumn.CellEditEvent<Patient, String> event) {

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

    private ObservableList<Patient> getPatient(){
        ObservableList<Patient> p = FXCollections.observableArrayList();
        p.add(new Patient("Nwenwe", "Darlington", "001", "18",
                "Port Harcourt", "0800000001", "Male", "Student",
                "GPD", "NO"));
        return p;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        hospitalNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("hospitalNumber"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("age"));
        patientGenderColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        patientPhoneColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("phone"));
        occupationColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("occupation"));
        patientAddressColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
        entryPointColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("entryPoint"));
        referralColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("referral"));

        patientTableView.setItems(getPatient());
        patientTableView.setEditable(true);

        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        hospitalNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        patientGenderColumn.setCellFactory((ComboBoxTableCell.forTableColumn()));
        patientAddressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        patientPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        occupationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        entryPointColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        referralColumn.setCellFactory(ComboBoxTableCell.forTableColumn());

    }
}