package com.example.hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
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
    @FXML
    private TextField stockSupplierTextField;
    @FXML
    private TableColumn stockPurchaseValueColumn;
    @FXML
    private TableColumn stockSalesValueColumn;
    @FXML
    private TableColumn stockUnitCostPriceColumn;
    @FXML
    private ComboBox stockQuantityFormCombo;
    @FXML
    private Button stockCheckoutButton;
    @FXML
    public TextField supplierTextField;
    @FXML
    private TableColumn dispenseIdColumn;
    private int dispenseSN = 1;
    @FXML
    private Button dispenseAddButton;
    @FXML
    private Button dispenseRemoveButton;
    @FXML
    private Button dispenseCheckoutButton;
    @FXML
    private TableColumn dispenseQuantityColumn;
    @FXML
    private Button stockAddButton;
    @FXML
    private Button stockRemoveButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TableColumn stockQuantityColumn;
    @FXML
    private Button homeButton;
    @FXML
    private Button stockHomeButton;
    @FXML
    private Button stockLogoutButton;
    @FXML
    private TableColumn dispenseSalesColumn;
    @FXML
    private TableColumn stockIdColumn;
    @FXML
    private TableColumn stockSupplierColumn;
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
    private TextField stockQuantityTextField;
    @FXML
    private TableColumn<Drug, String> stockUnitSellingPriceColumn;
    @FXML
    private TextField stockUnitSellingPriceTextField;
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

    private ObservableList<Integer> drugDurationList1 = FXCollections.observableArrayList(
            1, 2, 3, 4, 5, 6);

    private ObservableList<String> drugDurationList2 = FXCollections.observableArrayList(
            "Day", "Days", "Week", "Weeks", "Months");
    private ObservableList<String> quantityList = FXCollections.observableArrayList(
            "Tabs", "Caps", "Susp", "Ampoule", "Vial", "IVF");

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();
    @FXML
    private TextField stockUnitCostPriceTextField;

    public ObservableList<Drug> getDrug() {
        ObservableList<Drug> drugs = FXCollections.observableArrayList();
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT * FROM pharmacy.stock";
            ResultSet resultSet = statement.executeQuery(newQuery);


            while (resultSet.next()) {
                drugs.add( new Drug(
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
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13)
                        ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public void dispenseAddButtonClicked(ActionEvent actionEvent) {
        Dispenser d = new Dispenser(
                dispenseFormulationCombo.getValue(),
                dispenseDrugNameCombo.getValue(),
                dispenseDrugClassCombo.getValue(),
                dispenseDoseTextField.getText(),
                dispenseDurationCombo1.getValue() + " " + dispenseDurationCombo2.getValue(),
                dispenseQuantityField.getText(),
                dispenseUnitPriceField.getText(),
                getSales(Integer.parseInt(dispenseQuantityField.getText()),
                        Double.parseDouble(dispenseUnitPriceField.getText()))
        );
        dispenseTableView.getItems().add(d);
    }
    public void dispenseCheckoutButtonClicked(ActionEvent actionEvent) {
        ObservableList<Dispenser> prescription;
        prescription = dispenseTableView.getItems();
        double sales = 0;

        try {
            for (Dispenser a : prescription) {
                double unitQuantity = Double.parseDouble(a.getdQuantity());
                double unitPrice = Double.parseDouble(a.getdUnitPrice());
                sales += unitPrice * unitQuantity;

                String checkoutQuery = "INSERT INTO `pharmacy`.`sales` (" +
                    "`formulation`, " +
                    "`name`, " +
                    "`dose`, " +
                    "`frequency`, " +
                    "`duration`, " +
                    "`quantity`, " +
                    "`unit_price`, " +
                    "`sales`, " +
                    "`date`) VALUES" +
                        a.getdFormulation() + "," +
                        a.getdName() + "," +
                        dispenseDoseColumn.getText() + "," +
                        dispenseFrequencyColumn.getText() + "," +
                        dispenseDurationColumn.getText() + "," +
                        a.getdQuantity() + "," +
                        a.getdUnitPrice() + "," +
                        sales +
                        LocalDate.now() + ")";

                Statement statement = connectDB.prepareStatement(checkoutQuery);
                statement.execute(checkoutQuery);
            }
            totalAlert.setTitle("Total Bill");
            totalAlert.setHeaderText("Total bill = " + sales);
            totalAlert.showAndWait();

            dispenseTableView.getItems().clear();
        } catch (Exception e) {
            totalAlert.setTitle("Failed");
            totalAlert.setHeaderText("Empty Unit price or Quantity field");
            totalAlert.showAndWait();
        }
    }
    public void dispenseRemoveButtonClicked(ActionEvent actionEvent) {
        int selectedIndex = dispenseTableView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            dispenseTableView.getItems().remove(selectedIndex);
        }
    }
    public String getStockId(){
        return String.valueOf(stockTableView.getItems().size());
    }

    public void stockAddButtonClicked(ActionEvent actionEvent) {
        Double purchaseValue = Double.parseDouble(
                stockUnitCostPriceTextField.getText()) *
                Double.parseDouble(stockQuantityTextField.getText());

        Double salesValue = Double.parseDouble(
                stockUnitCostPriceTextField.getText()) *
                Double.parseDouble(stockQuantityTextField.getText());

                Drug d = new Drug(
                getStockId(),
                stockDrugClassCombo.getValue(),
                stockFormulationCombo.getValue(),
                stockDrugNameCombo.getValue(),
                stockQuantityTextField.getText(),
                getUnitForm(),
                stockPurchaseDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                stockExpDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                stockUnitCostPriceTextField.getText(),
                stockUnitSellingPriceTextField.getText(),
                String.valueOf(purchaseValue), String.valueOf(purchaseValue),
                        stockSupplierTextField.getText()
                );
        stockTableView.getItems().add(d);
    }
    private String getUnitForm() {
        if(stockFormulationCombo.getValue().equals("Tabs"))
                return "Tabs";
        else if(stockFormulationCombo.getValue().equals("Caps"))
            return "Caps";
        else if(stockFormulationCombo.getValue().equals("Syrup"))
            return "Syrup";
        else if(stockFormulationCombo.getValue().equals("Susp"))
            return "Susp";
        else if (stockFormulationCombo.getValue().equals("IV") ||
                stockFormulationCombo.getValue().equals("IM"))
            return "Ampuole/Vial";
        else return "";
    }

    public void stockCheckoutButtonClicked(ActionEvent actionEvent) {

    }

    public void stockRemoveButtonClicked(ActionEvent actionEvent) {
        int selectedIndex = stockTableView.getSelectionModel().getSelectedIndex();
        Alert updateStockAlert = new Alert(Alert.AlertType.CONFIRMATION);

        try{
            String newQuery = "DELETE FROM pharmacy.stock WHERE name = '" +
                    stockDrugNameColumn.getText() + "'";
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initialize all dispense and stock TableViews
        stockIdColumn.setCellValueFactory(new PropertyValueFactory<>("drugId"));
        stockDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));
        stockDrugClassColumn.setCellValueFactory(new PropertyValueFactory<>("drugClass"));
        stockQuantityFormColumn.setCellValueFactory(new PropertyValueFactory<>("unitForm"));
        stockQuantityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        stockFormulationColumn.setCellValueFactory(new PropertyValueFactory<>("formulation"));
        stockUnitSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitSellingPrice"));
        stockUnitCostPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitCostPrice"));
        stockExpDateColumn.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        stockPurchaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        stockPurchaseValueColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseValue"));
        stockSalesValueColumn.setCellValueFactory(new PropertyValueFactory<>("salesValue"));
        stockSupplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));

        stockTableView.setItems(getDrug());
        stockTableView.setEditable(false);

        stockDrugClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockFormulationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockDrugNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockQuantityFormColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockQuantityNumberColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockUnitCostPriceColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockUnitSellingPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stockPurchaseDateColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockExpDateColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        stockSupplierColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        dispenseIdColumn.setCellValueFactory(new PropertyValueFactory<>("dispenseId"));
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

        stockQuantityFormCombo.setValue("1");
        stockQuantityFormCombo.setItems(quantityList);

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
}