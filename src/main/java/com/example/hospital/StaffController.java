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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button homeButton;
    @FXML
    private TableView<Staff> staffTableView;
    @FXML
    private TableColumn<Staff, String> staffGenderColumn;

    @FXML
    private TableColumn<Staff, String> staffCategoryColumn;
    @FXML
    private TableColumn<Staff, String> staffDOBColumn;
    @FXML
    private TableColumn<Staff, String> staffIdColumn;
    @FXML
    private TableColumn<Staff, String> staffNameColumn;
    @FXML
    private TableColumn<Staff, String> staffPositionColumn;
    @FXML
    private TableColumn<Staff,String> staffPhoneColumn;
    @FXML
    private TableColumn<Staff,String> staffDepartmentColumn;
    @FXML
    private ComboBox<String> staffGenderCombo;
    @FXML
    private ComboBox<String> staffCategoryCombo;
    @FXML
    private ComboBox<String> staffDepartmentCombo;
    @FXML
    private TextField staffDOBTextField;
    @FXML
    private TextField staffIdTextField;
    @FXML
    private TextField staffNameTextField;
    @FXML
    private TextField staffPhoneTextField;
    @FXML
    private ComboBox<String> staffPositionCombo;
    @FXML
    private TextField staffSpecialtyTextField;

    private ObservableList<String> categoryList = FXCollections.observableArrayList(
            "Doctor", "Nurse", "Pharmacist", "Security", "Lab Scientist", "Services", "ICT");

    private ObservableList<String> genderList = FXCollections.observableArrayList(
            "Male", "Female");
    private ObservableList<String> positionList = FXCollections.observableArrayList(
            "Intern","Resident", "Consultant", "Matron", "Team Lead");
    private ObservableList<String> departmentList = FXCollections.observableArrayList(
            "Internal Medicine","Surgery", "Obs and Gynae", "Paediatrics",
            "Laundry/Infection Control", "Sterilization Unit", "Laboratory", "Security Unit");

    public StaffController() {
    }

    @FXML
    void addButtonClicked(ActionEvent event) {
        Staff staff = new Staff(staffNameTextField.getText(), staffIdTextField.getText(), staffGenderCombo.getValue(),
                staffDOBTextField.getText(),staffPhoneTextField.getText(),staffCategoryCombo.getValue(),
                staffPositionCombo.getValue(), staffDepartmentCombo.getValue());
        staffTableView.getItems().add(staff);
    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {
        ObservableList<Staff> selectedRows, allStaff;
        allStaff = staffTableView.getItems();
        selectedRows = staffTableView.getSelectionModel().getSelectedItems();

        for(Staff a : selectedRows){
            allStaff.remove(a);
        }
    }

    @FXML
    void editStaffCategoryColumn(ActionEvent event) {

    }

    @FXML
    void editStaffDOBColumn(ActionEvent event) {

    }
    @FXML
    void editStaffGenderColumn(ActionEvent event) {

    }

    @FXML
    void editStaffIdColumn(ActionEvent event) {

    }
    @FXML
    void editStaffNameColumn(ActionEvent event) {

    }

    @FXML
    void editStaffPositionColumn(ActionEvent event) {

    }

    @FXML
    void editStaffPhoneColumn(ActionEvent event) {

    }
    @FXML
    void editStaffDepartmentColumn(TableColumn.CellEditEvent cellEditEvent) {
    }

    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 800, 600);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Homepage");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        staffGenderColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("gender"));
        staffDOBColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("age"));
        staffPhoneColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("phone"));
        staffCategoryColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("category"));
        staffPositionColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("position"));
        staffDepartmentColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("department"));

        staffTableView.setItems(getStaff());
        staffTableView.setEditable(true);

        staffNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        staffIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        staffGenderColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        staffDOBColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        staffPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        staffCategoryColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        staffPositionColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        staffDepartmentColumn.setCellFactory(ComboBoxTableCell.forTableColumn());

        staffTableView.setItems(getStaff());
        staffGenderCombo.setValue("select");
        staffGenderCombo.setItems(genderList);

        staffCategoryCombo.setValue("select");
        staffCategoryCombo.setItems(categoryList);

        staffPositionCombo.setValue("select");
        staffPositionCombo.setItems(positionList);

        staffDepartmentCombo.setValue("choose");
        staffDepartmentCombo.setItems(departmentList);
    }

    private ObservableList<Staff> getStaff() {
            ObservableList<Staff> staff = FXCollections.observableArrayList();
            staff.add(new Staff("Confidence", "1234", "Male", "26", "08107170179",
                    "Doctor", "Medical Officer", "Internal Medicine"));
            staff.add(new Staff("Gift", "1235", "Female", "21", "00000000000",
                    "Student", "Intern", "Laboratory"));
             return staff;
        }
    }