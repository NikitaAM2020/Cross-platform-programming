package com.example.lab6banknew;

import com.example.lab6banknew.CardAccount;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class BankCardAccountApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private CardAccountRepository repository;

    @Override
    public void start(Stage primaryStage) {
        // Ініціалізація репозиторію та завантаження даних
        repository = new CardAccountRepository();
        loadAccounts();

        // Створення елементів вікна
        TableView<CardAccount> table = new TableView<>();
        TableColumn<CardAccount, String> cardNumberColumn = new TableColumn<>("Card Number");
        TableColumn<CardAccount, String> customerNameColumn = new TableColumn<>("Customer Name");
        TableColumn<CardAccount, String> addressColumn = new TableColumn<>("Address");
        TableColumn<CardAccount, Double> balanceColumn = new TableColumn<>("Balance");
        TableColumn<CardAccount, String> typeColumn = new TableColumn<>("Type");
        TableColumn<CardAccount, String> issueDateColumn = new TableColumn<>("Issue Date");
        TableColumn<CardAccount, String> expiryDateColumn = new TableColumn<>("Expiry Date");

        TextField cardNumberField = new TextField();
        TextField customerNameField = new TextField();
        TextField addressField = new TextField();
        TextField balanceField = new TextField();
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Credit", "Deposit");
        DatePicker issueDatePicker = new DatePicker();
        DatePicker expiryDatePicker = new DatePicker();

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button filterButton = new Button("Filter");

        // Налаштування вигляду елементів вікна
        table.getColumns().addAll(cardNumberColumn, customerNameColumn, addressColumn,
                balanceColumn, typeColumn, issueDateColumn, expiryDateColumn);
        table.setItems(repository.getAllCardAccounts());

        cardNumberColumn.setCellValueFactory(cellData -> cellData.getValue().cardNumberProperty());
        customerNameColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().customerAddressProperty());
        balanceColumn.setCellValueFactory(cellData -> cellData.getValue().accountBalanceProperty().asObject());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().accountTypeProperty());
        issueDateColumn.setCellValueFactory(cellData -> cellData.getValue().issueDateProperty());
        expiryDateColumn.setCellValueFactory(cellData -> cellData.getValue().expiryDateProperty());

        addButton.setOnAction(event -> {
            String cardNumber = cardNumberField.getText();
            String customerName = customerNameField.getText();
            String address = addressField.getText();
            double balance = Double.parseDouble(balanceField.getText());
            String type = typeComboBox.getValue();
            String issueDate = issueDatePicker.getValue().toString();
            String expiryDate = expiryDatePicker.getValue().toString();

            CardAccount account = new CardAccount(cardNumber, customerName, address, balance, type, issueDate, expiryDate);
            repository.addCardAccount(account);
            clearFields(cardNumberField, customerNameField, addressField, balanceField, typeComboBox, issueDatePicker, expiryDatePicker);
        });

        deleteButton.setOnAction(event -> {
            CardAccount selectedAccount = table.getSelectionModel().getSelectedItem();
            if (selectedAccount != null) {
                repository.removeCardAccount(selectedAccount);
            }
        });

        filterButton.setOnAction(event -> {
            String filterType = typeComboBox.getValue();
            ObservableList<CardAccount> filteredList = repository.getAllCardAccounts()
                    .stream()
                    .filter(account -> account.getAccountType().equals(filterType))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            table.setItems(filteredList);
        });

        // Розташування елементів вікна
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(table, new Label("Card Number"), cardNumberField,
                new Label("Customer Name"), customerNameField, new Label("Address"), addressField,
                new Label("Balance"), balanceField, new Label("Type"), typeComboBox,
                new Label("Issue Date"), issueDatePicker, new Label("Expiry Date"), expiryDatePicker,
                addButton, deleteButton, filterButton);

        // Створення сцени і показ вікна
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Card Accounts");
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Збереження даних при закритті додатку
        saveAccounts();
    }

    private void loadAccounts() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("accounts.dat"))) {
            List<CardAccount> accounts = (List<CardAccount>) inputStream.readObject();
            repository.addAllCardAccounts(accounts);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }

    private void saveAccounts() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("accounts.dat"))) {
            List<CardAccount> accounts = repository.getAllCardAccounts();
            outputStream.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    private void clearFields(TextField cardNumberField, TextField customerNameField, TextField addressField,
                             TextField balanceField, ComboBox<String> typeComboBox,
                             DatePicker issueDatePicker, DatePicker expiryDatePicker) {
        cardNumberField.clear();
        customerNameField.clear();
        addressField.clear();
        balanceField.clear();
        typeComboBox.getSelectionModel().clearSelection();
        issueDatePicker.getEditor().clear();
        expiryDatePicker.getEditor().clear();
    }

}
