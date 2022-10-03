package com.example.hospital;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class PharmacyController implements Initializable {
    @FXML
    private TableColumn stockQuantityFormColumn;
    @FXML
    private TableColumn stockQuantityNumberColumn;
    @FXML
    private TextField dispenseQuantityField;
    @FXML
    private TableColumn stockDrugClassColumn;
    @FXML
    private ComboBox<String> stockDrugClassCombo;
    @FXML
    private ComboBox<String> dispenseDrugClassCombo;
    @FXML
    private TextField dispenseUnitPriceField;
    @FXML
    private TableView<Dispenser> dispenseTableView;
    @FXML
    private TableColumn dispenseDoseColumn;
    @FXML
    private TextField dispenseDoseTextField;
    @FXML
    private TableColumn dispenseDrugNameColumn;
    @FXML
    private TableColumn dispenseDurationColumn;
    @FXML
    private ComboBox<Integer> dispenseDurationCombo1;
    @FXML
    private ComboBox<String> dispenseDurationCombo2;
    @FXML
    private TableColumn dispenseFormulationColumn;
    @FXML
    private ComboBox<String> dispenseFormulationCombo;
    @FXML
    private TableColumn dispenseFrequencyColumn;
    @FXML
    private ComboBox<String> dispenseFrequencyCombo;
    @FXML
    private TableColumn dispensePriceColumn;
    @FXML
    private ComboBox<String> dispenseDrugNameCombo;
    @FXML
    private TableView<Drug> stockTableView;
    @FXML
    private TableColumn<Drug, String> stockDoseColumn;
    @FXML
    private TextField stockDoseTextField;
    @FXML
    private TableColumn<Drug, String> stockDrugNameColumn;
    @FXML
    private TableColumn<Drug, Date> stockExpDateColumn;
    @FXML
    private DatePicker stockExpDatePicker;
    @FXML
    private TableColumn<Drug, String> stockFormulationColumn;
    @FXML
    private ComboBox<String> stockFormulationCombo;
    @FXML
    private ComboBox<String> stockDrugNameCombo;
    @FXML
    private TableColumn<Drug, Date> stockPurchaseDateColumn;
    @FXML
    private DatePicker stockPurchaseDatePicker;
    @FXML
    private ComboBox<String> stockQuantityCombo;
    @FXML
    private TextField stockQuantityTextField;
    @FXML
    private TextField stockTabletsPerPackTextField;
    @FXML
    private TableColumn<Drug, String> stockTabsPerPackColumn;
    @FXML
    private TableColumn<Drug, String> stockUnitPriceColumn;
    @FXML
    private TextField stockUnitPriceTextField;

    private final Alert totalAlert = new Alert(Alert.AlertType.CONFIRMATION);
    private ObservableList<String> nameOfDrugList = FXCollections.observableArrayList(
            "Paracetamol", "Diclofenac", "Ibuprofen", "Celecoxib", "Cocodamol");

    private ObservableList<String> drugFormulationList = FXCollections.observableArrayList(
            "Tabs", "Caps", "Susp", "IM", "IV", "SC", "IVF");

    private ObservableList<String> drugFrequencyList = FXCollections.observableArrayList(
            "Daily", "BD", "TDS", "QDS", "Weekly", "Others");

    private ObservableList<String> drugClassList = FXCollections.observableArrayList(
            "Analgesics", "Antihypertensives", "Anti-Diabetics", "Antiemetics",
            "IV Fluids", "Antimalaria", "Antibiotics", "Hematinics", "Antiulcer");

    private ObservableList<Integer> drugDurationList1 = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6);

    private ObservableList<String> drugDurationList2 = FXCollections.observableArrayList(
            "Day", "Days", "Week", "Weeks", "Months");
    private ObservableList<String> quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10");

    public ObservableList<Dispenser> getDispenser() {
        ObservableList<Dispenser> prescription = FXCollections.observableArrayList();
        prescription.add(new Dispenser("Tabs", "Paracetamol", "Analgesics",
                "1g", "3 Days", "TDS", "18", "20"));
        return prescription;
    }

    public ObservableList<Drug> getDrug() {
        ObservableList<Drug> drugs = FXCollections.observableArrayList();
        drugs.add(new Drug("Paracetamol", "500mg", "Tab", "Analgesic", "Pack",
                "1", "9", "20", "09-1-2022", "09-1-2023"));
        drugs.add(new Drug("Diclofenac", "100mg", "Tab", "Analgesic", "Pack",
                "1", "10", "30", "09-05-22", "09-05-2023"));
        drugs.add(new Drug("Ibuprofen", "200mg", "Tab", "Analgesic", "Pack",
                "1", "10", "20", "09-05-22", "09-05-2022"));
        drugs.add(new Drug("Celecoxib", "200mg", "Caps", "Analgesic", "Pack",
                "1", "10", "100", "05-09-22", "05-09-2023"));
        drugs.add(new Drug("Cocodamol", "80-0500mg", "Tabs", "Analgesic", "Pack",
                "1", "10", "50", "05-09-22", "05-09-2023"));
        return drugs;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stockDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));
        stockDrugClassColumn.setCellValueFactory(new PropertyValueFactory<>("drugClass"));
        stockDoseColumn.setCellValueFactory(new PropertyValueFactory<>("drugDose"));
        stockQuantityFormColumn.setCellValueFactory(new PropertyValueFactory<>("quantityForm"));
        stockQuantityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        stockFormulationColumn.setCellValueFactory(new PropertyValueFactory<>("formulation"));
        stockTabsPerPackColumn.setCellValueFactory(new PropertyValueFactory<>("tabletsPerPack"));
        stockUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        stockExpDateColumn.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        stockPurchaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));

        stockTableView.setItems(getDrug());
        stockTableView.setEditable(false);
        stockDrugNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockDoseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockQuantityFormColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockQuantityNumberColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockDrugClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockTabsPerPackColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockFormulationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockPurchaseDateColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockExpDateColumn.setCellFactory(ComboBoxTableCell.forTableColumn());

        dispenseDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("dName"));
        dispenseDoseColumn.setCellValueFactory(new PropertyValueFactory<>("dDose"));
        dispenseFormulationColumn.setCellValueFactory(new PropertyValueFactory<>("dFormulation"));
        dispenseFrequencyColumn.setCellValueFactory(new PropertyValueFactory<>("dFrequency"));
        dispensePriceColumn.setCellValueFactory(new PropertyValueFactory<>("dUnitPrice"));
        dispenseDurationColumn.setCellValueFactory(new PropertyValueFactory<> ("dDuration"));

        dispenseTableView.setEditable(false);
        dispenseTableView.setItems(getDispenser());

        dispenseDrugNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseDoseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseFormulationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispensePriceColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        dispenseDurationColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Initialize all dispense and stock Combos

        dispenseDrugNameCombo.setValue("choose drug");
        dispenseDrugNameCombo.setItems(nameOfDrugList.sorted());

        stockDrugNameCombo.setValue("choose drug");
        stockDrugNameCombo.setItems(nameOfDrugList.sorted());

        dispenseFormulationCombo.setValue("Select");
        dispenseFormulationCombo.setItems(drugFormulationList);

        stockFormulationCombo.setValue("Select");
        stockFormulationCombo.setItems(drugFormulationList);

        dispenseFrequencyCombo.setValue("Select");
        dispenseFrequencyCombo.setItems(drugFrequencyList);

        dispenseDrugClassCombo.setValue("Select");
        dispenseDrugClassCombo.setItems(drugClassList);

        stockDrugClassCombo.setValue("Select");
        stockDrugClassCombo.setItems(drugClassList);

        dispenseDurationCombo1.setValue(3);
        dispenseDurationCombo1.setItems(drugDurationList1);

        dispenseDurationCombo2.setValue("Days");
        dispenseDurationCombo2.setItems(drugDurationList2);

        stockQuantityCombo.setValue("1");
        stockQuantityCombo.setItems(quantityList);

//        THE FOLLOWING CODE CAN BE USED TO INSERT NEW COLUMNS (REMEMBER TO FIRST CREATE TableView FIELDS FOR THESE COLUMNS
//        AND REPLACE THE PARAMETERS BELOW WITH THE NAMES OF THE FIELDS

//        drugTableView.getColumns().add(drugNameColumn);
//        drugTableView.getColumns().add(drugReferenceNo);
//        drugTableView.getColumns().add(drugDose);
//        drugTableView.getColumns().add(numberOfTablets);
//        drugTableView.getColumns().add(LOT);
//
//        drugTableView.getItems();
//
//
    }
    public void dispenseRemoveButtonClicked(ActionEvent actionEvent) {
        int selectedIndex = dispenseTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
                dispenseTableView.getItems().remove(selectedIndex);
            }
    }
    public void dispenseAddButtonClicked(ActionEvent actionEvent) {
        Dispenser d = new Dispenser(dispenseFormulationCombo.getValue(), dispenseDrugNameCombo.getValue(),
                dispenseDrugClassCombo.getValue(), dispenseDoseTextField.getText(),
                dispenseDurationCombo1.getValue() + " " + dispenseDurationCombo2.getValue(),
                dispenseFrequencyCombo.getValue(), dispenseQuantityField.getText(),
                dispenseUnitPriceField.getText());
        dispenseTableView.getItems().add(d);
    }

    public void stockAddButtonClicked(ActionEvent actionEvent) {
        Drug d = new Drug(stockDrugNameCombo.getValue(), stockDoseTextField.getText(), stockFormulationCombo.getValue(),
        stockDrugClassCombo.getValue(), stockQuantityCombo.getValue(),stockQuantityTextField.getText(),
                stockTabletsPerPackTextField.getText(), stockUnitPriceTextField.getText(),
                stockPurchaseDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                stockExpDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        stockTableView.getItems().add(d);
    }
    public void stockRemoveButtonClicked(ActionEvent actionEvent) {
        int selectedIndex = stockTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0)
            stockTableView.getItems().remove(selectedIndex);
    }
    public void dispenseCheckoutButtonClicked(ActionEvent actionEvent) {
        ObservableList<Dispenser> prescription;
        prescription = dispenseTableView.getItems();
        double total = 0;

        for (Dispenser a : prescription) {
            total += Double.parseDouble(a.getdQuantity()) *
                    Double.parseDouble(a.getdUnitPrice());
        }

            totalAlert.setTitle("Total Bill");
            totalAlert.setHeaderText("Total bill = " + total);
            totalAlert.showAndWait();

            dispenseTableView.getItems().clear();
    }
}