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
    private Button showDataBase;
    @FXML
    private Button dispenseAddButton;
    @FXML
    private Button dispenseRemoveButton;
    @FXML
    private Button dispenseCheckoutButton;
    @FXML
    private Button stockCheckoutButton;
    @FXML
    public TextField supplierTextField;
    @FXML
    private Button stockAddButton;
    @FXML
    private Button stockRemoveButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button stockHomeButton;
    @FXML
    private Button stockLogoutButton;
    @FXML
    private TextField dispenseQuantityField;
    @FXML
    private ComboBox<String> dispenseDrugClassCombo;
    @FXML
    private TextField dispenseUnitPriceField;
    @FXML
    private ComboBox stockQuantityFormCombo;
    @FXML
    private TextField dispenseDoseTextField;
    @FXML
    private ComboBox<Integer> dispenseDurationCombo1;
    @FXML
    private ComboBox<String> dispenseDurationCombo2;
    @FXML
    private ComboBox<String> dispenseFormulationCombo;
    @FXML
    private ComboBox<String> dispenseFrequencyCombo;
    @FXML
    private ComboBox<String> dispenseDrugNameCombo;
    @FXML
    private TableView<Dispenser> dispenseTableView;
    @FXML
    private TableColumn dispenseQuantityColumn;
    @FXML
    private TableColumn dispenseDoseColumn;
    @FXML
    private TableColumn dispenseDrugNameColumn;
    @FXML
    private TableColumn dispenseDurationColumn;
    @FXML
    private TableColumn dispenseFormulationColumn;
    @FXML
    private TableColumn dispenseFrequencyColumn;
    @FXML
    private TableColumn dispensePriceColumn;
    @FXML
    private TableColumn dispenseSalesColumn;
    @FXML
    private ComboBox<String> stockDrugClassCombo;
    @FXML
    private TextField stockSupplierTextField;
    @FXML
    private DatePicker stockExpDatePicker;
    @FXML
    private ComboBox<String> stockFormulationCombo;
    @FXML
    private TextField stockDrugNameTextField;
    @FXML
    private DatePicker stockPurchaseDatePicker;
    @FXML
    private TextField stockQuantityTextField;
    @FXML
    private TextField stockUnitSellingPriceTextField;
    @FXML
    private TextField stockUnitCostPriceTextField;
    @FXML
    private TableView<Drug> stockTableView;
    @FXML
    private TableColumn<Drug, String> stockIdColumn;
    @FXML
    private TableColumn<Drug, Date> stockPurchaseDateColumn;
    @FXML
    private TableColumn<Drug, Date> stockExpDateColumn;
    @FXML
    private TableColumn<Drug, String> stockSupplierColumn;
    @FXML
    private TableColumn<Drug, String> stockQuantityFormColumn;
    @FXML
    private TableColumn<Drug, String> stockQuantityNumberColumn;
    @FXML
    private TableColumn<Drug, String> stockPurchaseValueColumn;
    @FXML
    private TableColumn<Drug, String> stockSalesValueColumn;
    @FXML
    private TableColumn<Drug, String> stockUnitCostPriceColumn;
    @FXML
    private TableColumn<Drug, String> stockDrugClassColumn;
    @FXML
    private TableColumn<Drug, String> stockDrugNameColumn;
    @FXML
    private TableColumn<Drug, String> stockFormulationColumn;
    @FXML
    private TableColumn<Drug, String> stockUnitSellingPriceColumn;
    private boolean dispenseDatabaseIsShown;
    private boolean stockDatabaseIsShown;
    private final Alert totalAlert = new Alert(Alert.AlertType.CONFIRMATION);
    private final Alert databaseAlert = new Alert(Alert.AlertType.WARNING);
    private DatabaseConnection connectNow = new DatabaseConnection();
    private Connection connectDB = connectNow.getConnection();
    private ObservableList<String> drugFormulationList = FXCollections.observableArrayList(
            "Tabs", "Caps", "Susp", "IM", "IV", "SC", "IVF");
    private ObservableList<String> drugFrequencyList = FXCollections.observableArrayList(
            "Daily", "BD", "TDS", "QDS", "Weekly", "Others");
    private ObservableList<Integer> drugDurationList1 = FXCollections.observableArrayList(
            1, 2, 3, 4, 5, 6);
    private ObservableList<String> drugDurationList2 = FXCollections.observableArrayList(
            "Day", "Days", "Week", "Weeks", "Month", "Months");
    private ObservableList<String> quantityList = FXCollections.observableArrayList(
            "Tabs", "Caps", "Susp", "Ampoule", "Vial", "IVF");
    public ObservableList<Drug> getDrug() {
        ObservableList<Drug> drugs = FXCollections.observableArrayList();
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT * FROM hospital.pharmacy_stock";
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
            databaseAlert.setTitle("ERROR");
            databaseAlert.setHeaderText("Cannot access database");
            databaseAlert.setContentText("Try again or Restart program.");
            databaseAlert.showAndWait();
        }
        return drugs;
    }
    public ObservableList<Dispenser> getDispenser() {
        ObservableList<Dispenser> sales = FXCollections.observableArrayList();
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT * FROM hospital.pharmacy_sales";
            ResultSet resultSet = statement.executeQuery(newQuery);

            while (resultSet.next()) {
                int i =1;
                sales.add( new Dispenser(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                        ));
                i++;
            }
        }
        catch (SQLException e) {
            databaseAlert.setTitle("ERROR");
            databaseAlert.setHeaderText("Cannot access database");
            databaseAlert.setContentText("Try again or Restart program.");
            databaseAlert.showAndWait();
        }
        return sales;
    }
    public void dispenseAddButtonClicked(ActionEvent actionEvent) {
        if(dispenseDatabaseIsShown) {
            hideDispenseDatabaseButtonClicked(actionEvent);
        }
        Double sales = Double.parseDouble(
                dispenseUnitPriceField.getText()) *
                Double.parseDouble(dispenseQuantityField.getText());

        Dispenser d = new Dispenser(
                dispenseFormulationCombo.getValue(),
                dispenseDrugNameCombo.getValue(),
                dispenseDoseTextField.getText(),
                dispenseFrequencyCombo.getValue(),
                dispenseDurationCombo1.getValue() + " " + dispenseDurationCombo2.getValue(),
                dispenseQuantityField.getText(),
                dispenseUnitPriceField.getText(),
                String.valueOf(sales)
        );
        dispenseTableView.getItems().add(d);
    }
    public void dispenseCheckoutButtonClicked(ActionEvent actionEvent) {
        if (dispenseDatabaseIsShown) {
            databaseAlert.setTitle("WARNING!");
            databaseAlert.setHeaderText("Attempt to duplicate sales database FAILED!.");
            databaseAlert.setContentText("HINT: Hide database before you add sales and checkout");
            databaseAlert.showAndWait();
        } else {
            ObservableList<Dispenser> prescription;
            prescription = dispenseTableView.getItems();
            double totalBill = 0;

            try {
                for (Dispenser a : prescription) {
                    double unitQuantity = Double.parseDouble(a.getdQuantity());
                    double unitPrice = Double.parseDouble(a.getdUnitPrice());
                    totalBill += unitPrice * unitQuantity;

                    String checkoutQuery = "INSERT INTO hospital.pharmacy_sales (" +
                            "`formulation`, " +
                            "`name`, " +
                            "`dose`, " +
                            "`frequency`, " +
                            "`duration`, " +
                            "`quantity`, " +
                            "`unit_price`, " +
                            "`sales`, " +
                            "`date`) VALUES (\'" +
                        a.getdFormulation() + "\', \'" +
                        a.getdName() + "\', \'" +
                        a.getdDose() + "\', \'" +
                        a.getdFrequency() + "\', \'" +
                        a.getdDuration() + "\', \'" +
                        a.getdQuantity() + "\', \'" +
                        a.getdUnitPrice() + "\', \'" +
                        totalBill + "\', \'" +
                        LocalDate.now() + "\')";

                    Statement statement = connectDB.prepareStatement(checkoutQuery);
                    statement.execute(checkoutQuery);

                    double newQuantity = Double.parseDouble(a.getdQuantity());

                    String query = "SELECT quantity FROM hospital.pharmacy_stock WHERE name = '" +
                            a.getdName() + "'";

                    ResultSet rs = statement.executeQuery(query);

                    while (rs.next()) {
                        String updateQuery = "UPDATE hospital.pharmacy_stock SET `quantity` = " +
                                Double.parseDouble(rs.getString("quantity")) + " - " +
                                newQuantity + " WHERE (`name` = '" + a.getdName() + "')";

                        Statement statement1 = connectDB.prepareStatement(updateQuery);
                        statement1.execute(updateQuery);
                    }
                }
                totalAlert.setTitle("Total Bill");
                totalAlert.setHeaderText("Total bill = " + totalBill);
                totalAlert.showAndWait();

                databaseAlert.setTitle("Success");
                databaseAlert.setHeaderText("Database Updated");
                databaseAlert.showAndWait();

                dispenseTableView.getItems().clear();
            } catch (Exception e) {
                databaseAlert.setTitle("Failed!");
                databaseAlert.setHeaderText("Incorrect Fields. Please confirm your input and try again.");
                databaseAlert.showAndWait();
            }
        }
    }
    public void dispenseRemoveButtonClicked(ActionEvent actionEvent) {
        if (dispenseDatabaseIsShown) {
            databaseAlert.setTitle("WARNING!");
            databaseAlert.setHeaderText("Cannot edit Database");
            databaseAlert.setContentText("Database is read-only");
            databaseAlert.showAndWait();
        } else {
            int selectedIndex = dispenseTableView.getSelectionModel().getSelectedIndex();

            if (selectedIndex >= 0) {
                dispenseTableView.getItems().remove(selectedIndex);
            }
        }
    }
    public void stockDrugClassSelected(ActionEvent actionEvent) {
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT form FROM hospital.pharmacy_stock WHERE class = '" +
                    stockDrugClassCombo.getValue() + "' GROUP BY form";
            ResultSet resultSet = statement.executeQuery(newQuery);
            ObservableList data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            stockFormulationCombo.setItems(data);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void stockAddButtonClicked(ActionEvent actionEvent) {
        if (stockDatabaseIsShown) {
            hideStockDatabaseButtonClicked(actionEvent);
        }
        String stockId = String.valueOf(stockTableView.getItems().size() + 1);

        try {
            Double purchaseValue = Double.parseDouble(
                    stockUnitCostPriceTextField.getText()) *
                    Double.parseDouble(stockQuantityTextField.getText());
            Double salesValue = Double.parseDouble(
                    stockUnitCostPriceTextField.getText()) *
                    Double.parseDouble(stockQuantityTextField.getText());
            Drug d = new Drug(
                    stockId,
                    stockDrugClassCombo.getValue(),
                    stockFormulationCombo.getValue(),
                    stockDrugNameTextField.getText(),
                    stockQuantityTextField.getText(),
                    getUnitForm(),
                    stockPurchaseDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    stockExpDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    stockUnitCostPriceTextField.getText(),
                    stockUnitSellingPriceTextField.getText(),
                    String.valueOf(purchaseValue),
                    String.valueOf(salesValue),
                    stockSupplierTextField.getText()
            );
            stockTableView.getItems().add(d);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong input. Please check your entry");
            alert.showAndWait();
        }
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
        else if(stockFormulationCombo.getValue().equals("NONE"))
            return "NONE";
        else if (stockFormulationCombo.getValue().equals("IV") ||
                stockFormulationCombo.getValue().equals("IM"))
            return "Ampoule/Vial";
        else return "";
    }
    public void stockCheckoutButtonClicked(ActionEvent actionEvent) {
        if (stockDatabaseIsShown) {
            databaseAlert.setTitle("WARNING!");
            databaseAlert.setHeaderText("Attempt to duplicate stock database FAILED!");
            databaseAlert.setContentText("HINT: Hide database before you add stock and checkout");
            databaseAlert.showAndWait();
        } else {
            ObservableList<Drug> drug;
            drug = stockTableView.getItems();

            try {
                for (Drug a : drug) {
                    String checkoutQuery = "INSERT INTO hospital.pharmacy_stock (" +
                            "`class`, " +
                            "`form`, " +
                            "`name`, " +
                            "`quantity`, " +
                            "`unit_form`, " +
                            "`purchase_date`, " +
                            "`expiry_date`, " +
                            "`unit_cost_price`, " +
                            "`unit_selling_price`, " +
                            "`purchase_value`, " +
                            "`sales_value`, " +
                            "`supplier_name`) VALUES (\'" +
                        a.getDrugClass() + "\', \'" +
                        a.getFormulation() + "\', \'" +
                        a.getDrugName() + "\', \'" +
                        a.getQuantity() + "\', \'" +
                        a.getUnitForm() + "\', \'" +
                        a.getPurchaseDate() + "\', \'" +
                        a.getExpDate() + "\', \'" +
                        a.getUnitCostPrice() + "\', \'" +
                        a.getUnitSellingPrice() + "\', \'" +
                        a.getPurchaseValue() + "\', \'" +
                        a.getSalesValue() + "\', \'" +
                        a.getSupplier() + "\')";

                    Statement statement = connectDB.prepareStatement(checkoutQuery);
                    statement.execute(checkoutQuery);

                }
                databaseAlert.setTitle("Success");
                databaseAlert.setHeaderText("Database Updated");
                databaseAlert.showAndWait();

                stockTableView.getItems().clear();
            } catch (Exception e) {
                e.printStackTrace();
//                databaseAlert.setTitle("Failed!");
//                databaseAlert.setHeaderText("Please check your entry and try again");
//                databaseAlert.showAndWait();
            }
        }
    }
    @FXML
    public void showStockDatabaseButtonClicked(ActionEvent event){
        stockTableView.setItems(getDrug());
        stockDatabaseIsShown = true;
    }
    public void hideStockDatabaseButtonClicked(ActionEvent event){
        stockTableView.getItems().clear();
        stockDatabaseIsShown = false;
    }
    public void hideDispenseDatabaseButtonClicked(ActionEvent actionEvent) {
        dispenseTableView.getItems().clear();
        dispenseDatabaseIsShown = false;
    }
    public void showDispenseDatabaseButtonClicked(ActionEvent actionEvent) {
        dispenseTableView.setItems(getDispenser());
        dispenseDatabaseIsShown = true;
    }
    public void stockRemoveButtonClicked(ActionEvent actionEvent) {
        if (stockDatabaseIsShown) {
            databaseAlert.setTitle("WARNING!");
            databaseAlert.setHeaderText("Cannot edit Database");
            databaseAlert.setContentText("Database is read-only");
            databaseAlert.showAndWait();
        } else {
            int selectedIndex = stockTableView.getSelectionModel().getSelectedIndex();

            if (selectedIndex >= 0) {
                stockTableView.getItems().remove(selectedIndex);
            }
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

            String unitPriceQuery = "SELECT unit_selling_price FROM hospital.pharmacy_stock WHERE name = '" +
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

            String newQuery = "SELECT form FROM hospital.pharmacy_stock WHERE class = '" +
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

            String newQuery = "SELECT name FROM hospital.pharmacy_stock WHERE class = '" +
                    dispenseDrugClassCombo.getValue() + "' AND form = '" +
                    dispenseFormulationCombo.getValue() + "'";
            ResultSet resultSet = statement.executeQuery(newQuery);
            ObservableList data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            dispenseDrugNameCombo.setItems(data);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
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

        dispenseDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("dName"));
        dispenseDoseColumn.setCellValueFactory(new PropertyValueFactory<>("dDose"));
        dispenseFormulationColumn.setCellValueFactory(new PropertyValueFactory<>("dFormulation"));
        dispenseFrequencyColumn.setCellValueFactory(new PropertyValueFactory<>("dFrequency"));
        dispensePriceColumn.setCellValueFactory(new PropertyValueFactory<>("dUnitPrice"));
        dispenseQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("dQuantity"));
        dispenseDurationColumn.setCellValueFactory(new PropertyValueFactory<>("dDuration"));
        dispenseSalesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));

        dispenseTableView.setEditable(false);

        dispenseDrugNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseDoseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseFormulationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseQuantityColumn.setCellFactory((TextFieldTableCell.forTableColumn()));
        dispensePriceColumn.setCellFactory(ComboBoxTableCell.forTableColumn());
        dispenseDurationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dispenseSalesColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Initialize all dispense and stock Combos
        try {
            Statement statement = connectDB.createStatement();

            String newQuery = "SELECT class FROM hospital.pharmacy_stock GROUP BY class";
            ResultSet resultSet = statement.executeQuery(newQuery);
            ObservableList data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            dispenseDrugClassCombo.setItems(data);
            stockDrugClassCombo.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        stockFormulationCombo.setValue("Select");
        stockFormulationCombo.setItems(drugFormulationList);

        dispenseFrequencyCombo.setValue("Select");
        dispenseFrequencyCombo.setItems(drugFrequencyList);

        dispenseDurationCombo1.setValue(3);
        dispenseDurationCombo1.setItems(drugDurationList1);

        dispenseDurationCombo2.setValue("Days");
        dispenseDurationCombo2.setItems(drugDurationList2);

        stockQuantityFormCombo.setValue("select");
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
    }
}