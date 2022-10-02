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
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    private final ObservableList<String> entryPointList = FXCollections.observableArrayList("A/E", "CHER", "CHOP",
            "Labour Ward", "GOPD", "MOPC", "SOPC", "Gynae Clinic", "Obs Clinic");
    private final ObservableList<String> referralList = FXCollections.observableArrayList("Yes", "No");


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
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setAddress(event.getNewValue());
    }

    @FXML
    void editEntryPointColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setEntryPoint(event.getNewValue());
    }

    @FXML
    void editFirstNameColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setFirstName(event.getNewValue());
    }

    @FXML
    void editHospitalNumberColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setHospitalNumber(event.getNewValue());
    }

    @FXML
    void editLastNameColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setLastName(event.getNewValue());
    }

    @FXML
    void editOccupationColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setOccupation(event.getNewValue());
    }

    @FXML
    void editPatientGenderColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setGender(event.getNewValue());
    }

    @FXML
    void editPatientPhoneColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setPhone(event.getNewValue());
    }

    @FXML
    void editReferralColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p=(Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setReferral(event.getNewValue());
    }

    @FXML
    void editAgeColumn(TableColumn.CellEditEvent<Patient, String> event){
        Patient p = (Patient) patientTableView.getSelectionModel().getSelectedItems();
        p.setAge(event.getNewValue());
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
                "GOPD", "No"));
        p.add(new Patient("Ada", "George", "002", "32", "Abia",
                "09000000001", "Female", "Baker", "MOPC", "Yes"));
        return p;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        hospitalNumberColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalNumber"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        patientGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        patientPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        occupationColumn.setCellValueFactory(new PropertyValueFactory<>("occupation"));
        patientAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        entryPointColumn.setCellValueFactory(new PropertyValueFactory<>("entryPoint"));
        referralColumn.setCellValueFactory(new PropertyValueFactory<>("referral"));

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

        genderCombo.setValue("select");
        genderCombo.setItems(genderList);

        entryPointCombo.setValue("select");
        entryPointCombo.setItems(entryPointList);

        referralCombo.setValue("select");
        referralCombo.setItems(referralList);
    }
}