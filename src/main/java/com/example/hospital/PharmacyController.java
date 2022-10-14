package com.example.hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

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

public class PharmacyController implements Initializable {
    private int dispenseSN = 1;
    public Button dispenseAddButton;
    public Button dispenseRemoveButton;
    public Button dispenseCheckoutButton;
    public TableColumn dispenseQuantityColumn;
    public Button stockAddButton;
    public Button stockRemoveButton;
    public Button logoutButton;
    public TableColumn stockQuantityColumn;
    public Button homeButton;
    public Button stockHomeButton;
    public Button stockLogoutButton;
    public TableColumn dispenseSalesColumn;
    public TableColumn stockId;
    public TableColumn stockSupplierColumn;
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
    private TableView<ObservableList> dispenseTableView;
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
    private final Alert databaseAlert = new Alert(Alert.AlertType.INFORMATION);
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

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    public ObservableList<Drug> getDrug() {
        ObservableList<Drug> drugs = FXCollections.observableArrayList();
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT * FROM pharmacy.stock";
            ResultSet resultSet = statement.executeQuery(newQuery);


            while (resultSet.next()) {
                drugs.add( new Drug(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                        ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public void dispenseRemoveButtonClicked(ActionEvent actionEvent) {
        int selectedIndex = dispenseTableView.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
            dispenseTableView.getItems().remove(selectedIndex);
        }
    }

    public void dispenseAddButtonClicked(ActionEvent actionEvent) {
        ObservableList<String[]> items = FXCollections.observableArrayList();
        String[] list = {
                String.valueOf(getDispenseSN()),
                dispenseFormulationCombo.getValue(),
                dispenseDrugNameCombo.getValue(),
                dispenseDrugClassCombo.getValue(),
                dispenseDoseTextField.getText(),
                dispenseFrequencyCombo.getValue(),
                dispenseDurationCombo1.getValue() + " " + dispenseDurationCombo2.getValue(),
                dispenseQuantityField.getText(),
                dispenseUnitPriceField.getText(),
                getSales(Integer.parseInt(dispenseQuantityField.getText()),
                        Double.parseDouble(dispenseUnitPriceField.getText()))
                };
        items.add(list);
        dispenseTableView.getItems().add(items);
    }

    public String getSales(int quantity, double unitPrice){
        double sales = quantity * unitPrice;

        return String.valueOf(sales);
    }

    public int getDispenseSN() {
        setDispenseSN(dispenseSN);

        return dispenseSN;
    }

    public void setDispenseSN(int dispenseSN) {
        this.dispenseSN = dispenseSN + 1;
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
        Alert updateStockAlert = new Alert(Alert.AlertType.CONFIRMATION);

        try{
            String newQuery = "DELETE FROM pharmacy.stock WHERE name = '" +
                    stockDrugNameCombo.getValue() + "'";
            Statement statement = connectDB.prepareStatement(newQuery);

                if (selectedIndex >= 0) {

                    updateStockAlert.setHeaderText("Save changes?");
                    updateStockAlert.setTitle("Database Notification");
                    Optional<ButtonType> optional = updateStockAlert.showAndWait();

                    if(optional.get() == ButtonType.OK){
                        statement.execute(newQuery);
                        stockTableView.getItems().remove(selectedIndex);
                    }
                }
        }
        catch(Exception e){
            updateStockAlert.setTitle("Database Notification");
            updateStockAlert.setHeaderText("Error while trying to modify database");
            updateStockAlert.showAndWait();
        }
    }

    public void dispenseCheckoutButtonClicked(ActionEvent actionEvent) {
        ObservableList<String[]> prescription;
        prescription = dispenseTableView.getItems();
        double total = 0;

        try {
            for (Dispenser a : prescription) {
                double unitQuantity = Double.parseDouble(a.getdQuantity());
                double unitPrice = Double.parseDouble(a.getdUnitPrice());
                total += unitPrice * unitQuantity;
            }
                totalAlert.setTitle("Total Bill");
                totalAlert.setHeaderText("Total bill = " + total);
                totalAlert.showAndWait();

                dispenseTableView.getItems().clear();
        }
            catch(Exception e){
                totalAlert.setTitle("Failed");
                totalAlert.setHeaderText("Empty Unit price or Quantity field");
                totalAlert.showAndWait();
            }
        }

    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homepage.fxml")));
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initialize all dispense and stock TableViews
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
        dispenseQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("dQuantity"));
        dispenseDurationColumn.setCellValueFactory(new PropertyValueFactory<>("dDuration"));

        dispenseTableView.setEditable(false);

        dispenseDrugNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseDoseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseFormulationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseQuantityColumn.setCellFactory((TextFieldTableCell.forTableColumn()));
        dispensePriceColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        dispenseDurationColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Initialize all dispense and stock Combos

        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT class FROM pharmacy.stock GROUP BY class";
            ResultSet resultSet = statement.executeQuery(newQuery);
            ObservableList data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                    data.add(resultSet.getString(1));
            }
            dispenseDrugClassCombo.setItems(data);
            stockDrugClassCombo.setItems(data);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

            stockFormulationCombo.setValue("Select");
            stockFormulationCombo.setItems(drugFormulationList);

            dispenseFrequencyCombo.setValue("Select");
            dispenseFrequencyCombo.setItems(drugFrequencyList);

//            dispenseDrugClassCombo.setValue("Select");
//            dispenseDrugClassCombo.setItems(drugClassList);
//
//            stockDrugClassCombo.setValue("Select");
//            stockDrugClassCombo.setItems(drugClassList);

            dispenseDurationCombo1.setValue(3);
            dispenseDurationCombo1.setItems(drugDurationList1);

            dispenseDurationCombo2.setValue("Days");
            dispenseDurationCombo2.setItems(drugDurationList2);

            stockQuantityCombo.setValue("1");
            stockQuantityCombo.setItems(quantityList);

            dispenseUnitPriceField.setText("0");
            dispenseQuantityField.setText("0");

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

    public void dispenseDrugNameSelected(ActionEvent actionEvent) {
        try {
            Statement statement = connectDB.createStatement();

            String unitPriceQuery = "SELECT unit_selling_price FROM pharmacy.stock WHERE name = '" +
                    dispenseDrugNameCombo.getValue() + "' AND form = '" +
                    dispenseFormulationCombo.getValue() + "'";
            ResultSet unitPriceResultSet = statement.executeQuery(unitPriceQuery);

            while (unitPriceResultSet.next()) {
                dispenseUnitPriceField.setText(unitPriceResultSet.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dispenseDrugClassSelected(ActionEvent actionEvent) {
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT form FROM pharmacy.stock WHERE class = '" +
                    dispenseDrugClassCombo.getValue() + "' GROUP BY form";
            ResultSet resultSet = statement.executeQuery(newQuery);
            ObservableList data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            dispenseFormulationCombo.setItems(data);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dispenseFormulationSelected(ActionEvent actionEvent) {
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT name FROM pharmacy.stock WHERE class = '" +
                    dispenseDrugClassCombo.getValue() + "' AND form = '" +
                    dispenseFormulationCombo.getValue() + "'";
            ResultSet resultSet = statement.executeQuery(newQuery);
            ObservableList data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            dispenseDrugNameCombo.setItems(data);
            stockDrugNameCombo.setItems(data);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stockCheckoutButtonClicked(ActionEvent actionEvent) {

    }
}