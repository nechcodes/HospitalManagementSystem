package com.example.hospital;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button deleteButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button logoutButton;

    Patient p;
    @FXML
    private TextField PatientIdTextField;

    @FXML
    private TextField PatientNameTextField;

    @FXML
    private TableView<Appointment> tableView;
    
    @FXML
    private TableColumn<Appointment, String> PatientIdColumn;
    
    @FXML
    private TableColumn<Appointment, String> dateColumn;
    
    @FXML
    private TableColumn<Appointment, String> PatientNameColumn;

    @FXML
    private TableColumn<Appointment, String> venueColumn;

    @FXML
    private TextField venueTextField;

    class Appointment{
        String firstName;
        String lastName;
        String hospitalNumber;
        String appointmentVenue;
        String date;

        public Appointment(String firstName, String lastName,
                           String hospitalNumber, String appointmentVenue, String date) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.hospitalNumber = hospitalNumber;
            this.appointmentVenue = appointmentVenue;
            this.date = date;
        }
    }

    @FXML
    void addButtonClicked(ActionEvent event) {
        Appointment app = new Appointment(Strin)
    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {
        
    }

    @FXML
    void editDateColumn(TableColumn.CellEditEvent<Appointment, String> event) {
        
    }

    @FXML
    void editPatientId(TableColumn.CellEditEvent<Appointment, String> event) {
        
    }

    @FXML
    void editPatientNameColumn(TableColumn.CellEditEvent<Appointment, Appointment> event) {
        
    }

    @FXML
    void editVenueColumn(TableColumn.CellEditEvent<String, String> event) {
        
    }

    @FXML
    void homeButtonClicked(ActionEvent event) {
        
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}