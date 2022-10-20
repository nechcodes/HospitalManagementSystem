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
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class PatientController implements Initializable {
    @FXML
    private TableColumn<Patient, String> dobColumn;
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
    private TableColumn<Patient, String> patientIdColumn;
    @FXML
    private TextField emailTextField;
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
    private TableColumn<Patient, String> patientEmailColumn;
    @FXML
    private TableView<Patient> patientTableView;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField patientIdTextField;
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    private final ObservableList<String> entryPointList = FXCollections.observableArrayList("A/E", "CHER", "CHOP",
            "Labour Ward", "GOPD", "MOPC", "SOPC", "Gynae Clinic", "Obs Clinic");
    private final ObservableList<String> referralList = FXCollections.observableArrayList("Yes", "No");
    private DatabaseConnection connectNow = new DatabaseConnection();
    private Connection connectDB = connectNow.getConnection();
    private Alert databaseAlert = new Alert(Alert.AlertType.INFORMATION);
    private boolean patientDatabaseIsShown = false;

    public ObservableList<Patient> getPatient() {
        ObservableList<Patient> patients = FXCollections.observableArrayList();
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT * FROM hospital.patients";
            ResultSet resultSet = statement.executeQuery(newQuery);

            while (resultSet.next()) {
                patients.add( new Patient(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11)
                ));
            }
        }
        catch (SQLException e) {
            databaseAlert.setTitle("ERROR");
            databaseAlert.setHeaderText("Cannot access database");
            databaseAlert.setContentText("Try again or Restart program.");
            databaseAlert.showAndWait();
        }
        return patients;
    }
    @FXML
    public void patientAddButtonClicked(ActionEvent actionEvent) {
        if(patientDatabaseIsShown) {
            hidePatientDatabaseButtonClicked(actionEvent);
        }
        Patient p = new Patient(
                String.valueOf(patientTableView.getItems().size()),
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                ageTextField.getText(),
                genderCombo.getValue(),
                occupationTextField.getText(),
                addressTextField.getText(),
                emailTextField.getText(),
                phoneTextField.getText(),
                entryPointCombo.getValue(),
                referralCombo.getValue()
        );
        patientTableView.getItems().add(p);
    }
    @FXML
    public void hidePatientDatabaseButtonClicked(ActionEvent actionEvent) {
        patientTableView.getItems().clear();
        patientDatabaseIsShown = false;
    }
    @FXML
    public void showPatientDatabaseButtonClicked(ActionEvent event){
        patientTableView.setItems(getPatient());
        patientDatabaseIsShown = true;
    }
    @FXML
    public void patientCheckoutButtonClicked(ActionEvent actionEvent) {
        if (patientDatabaseIsShown) {
            databaseAlert.setTitle("WARNING!");
            databaseAlert.setHeaderText("Attempt to duplicate patient database FAILED!.");
            databaseAlert.setContentText("HINT: Hide database before you add patient and checkout");
            databaseAlert.showAndWait();
        } else {
            ObservableList<Patient> patients;
            patients = patientTableView.getItems();

            try {
                for (Patient a : patients) {

                    String checkoutQuery = "INSERT INTO hospital.patients (" +
                            "`firstname`, " +
                            "`lastname`, " +
                            "`age`, " +
                            "`gender`, " +
                            "`occupation`, " +
                            "`address`, " +
                            "`email`, " +
                            "`phone`, " +
                            "`entry_point`, " +
                            "`referral`) VALUES (\'" +
                        a.getFirstName() + "\', \'" +
                        a.getLastName() + "\', \'" +
                        a.getAge() + "\', \'" +
                        a.getGender() + "\', \'" +
                        a.getOccupation() + "\', \'" +
                        a.getAddress() + "\', \'" +
                        a.getEmail() + "\', \'" +
                        a.getPhone() + "\', \'" +
                        a.getEntryPoint() + "\', \'" +
                        a.getReferral() + "\')";

                    Statement statement = connectDB.prepareStatement(checkoutQuery);
                    statement.execute(checkoutQuery);
                }
                databaseAlert.setTitle("Success");
                databaseAlert.setHeaderText("Database Updated");
                databaseAlert.showAndWait();

                patientTableView.getItems().clear();
            } catch (Exception e) {
                databaseAlert.setTitle("Failed!");
                databaseAlert.setHeaderText("Incorrect Fields. Please confirm your input and try again.");
                databaseAlert.showAndWait();
            }
        }
    }
    @FXML
    public void patientRemoveButtonClicked(ActionEvent actionEvent) {
        if (patientDatabaseIsShown) {
            databaseAlert.setTitle("WARNING!");
            databaseAlert.setHeaderText("Cannot edit Database");
            databaseAlert.setContentText("Database is read-only");
            databaseAlert.showAndWait();
        } else {
            int selectedIndex =
                    patientTableView.getSelectionModel().getSelectedIndex();

            if (selectedIndex >= 0) {
                patientTableView.getItems().remove(selectedIndex);
            }
        }
    }
    @FXML
    void editAddressColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setAddress(event.getNewValue());
    }

    @FXML
    void editEntryPointColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setEntryPoint(event.getNewValue());
    }

    @FXML
    void editFirstNameColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setFirstName(event.getNewValue());
    }

    @FXML
    void editEmailColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setEmail(event.getNewValue());
    }

    @FXML
    void editLastNameColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setLastName(event.getNewValue());
    }

    @FXML
    void editOccupationColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setOccupation(event.getNewValue());
    }

    @FXML
    void editPatientGenderColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setGender(event.getNewValue());
    }

    @FXML
    void editPatientPhoneColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setPhone(event.getNewValue());
    }

    @FXML
    void editReferralColumn(TableColumn.CellEditEvent<Patient, String> event) {
        Patient p= patientTableView.getSelectionModel().getSelectedItem();
        p.setReferral(event.getNewValue());
    }

    @FXML
    void editAgeColumn(TableColumn.CellEditEvent<Patient, String> event){
        Patient p = patientTableView.getSelectionModel().getSelectedItem();
        p.setAge(event.getNewValue());
    }
    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homepage.fxml")));
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        patientGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        patientPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        patientEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        occupationColumn.setCellValueFactory(new PropertyValueFactory<>("occupation"));
        patientAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        entryPointColumn.setCellValueFactory(new PropertyValueFactory<>("entryPoint"));
        referralColumn.setCellValueFactory(new PropertyValueFactory<>("referral"));

        patientTableView.setEditable(true);

        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        patientIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        patientEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
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