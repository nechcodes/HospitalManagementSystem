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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField hospitalNumberTextField;
    @FXML
    private TextField firstNameTextField;
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

    @FXML
    private TableView<Appointment> appointmentTableView;
    
    @FXML
    private TableColumn<Appointment, String> hospitalNumberColumn;
    
    @FXML
    private TableColumn<Appointment, String> dateColumn;
    
    @FXML
    private TableColumn<Appointment, String> firstNameColumn;

    @FXML
    private TableColumn<Appointment, String> lastNameColumn;

    @FXML
    private TableColumn<Appointment, String> venueColumn;

    @FXML
    private TextField venueTextField;

    public void editPatientFirstNameColumn(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void editPatientLastNameColumn(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void editHospitalNumber(TableColumn.CellEditEvent cellEditEvent) {
    }

    private ObservableList<Appointment> getAppointment(){
        ObservableList<Appointment> app = FXCollections.observableArrayList();
        app.add(new Appointment("Christy", "DAng", "010", "Gynae Clinic",
                "22-10-2022"));
       return app;
    }
    @FXML
    void addButtonClicked(ActionEvent event) {
        Appointment app = new Appointment(firstNameTextField.getText(), lastNameTextField.getText(),
                hospitalNumberTextField.getText(), venueTextField.getText(),
                datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        appointmentTableView.getItems().add(app);
    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {
        ObservableList<Appointment> allAppointments, selectedRows;
        allAppointments = appointmentTableView.getItems();
        selectedRows = appointmentTableView.getSelectionModel().getSelectedItems();

        for (Appointment app : selectedRows){
            allAppointments.remove(app);
        }
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
    void editVenueColumn(TableColumn.CellEditEvent<Appointment, String> event) {
        
    }

    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        hospitalNumberColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalNumber"));
        venueColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentVenue"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        appointmentTableView.setItems(getAppointment());
        appointmentTableView.setEditable(true);

        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        hospitalNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        venueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
    }
}