package com.example.lab6kotlin

import javafx.application.Application
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.util.Callback
import java.io.*
import java.util.function.Supplier
import java.util.stream.Collectors

class BankCardAccountApp : Application() {
    private var repository: CardAccountRepository? = null
    override fun start(primaryStage: Stage) {
        // Ініціалізація репозиторію та завантаження даних
        repository = CardAccountRepository()
        loadAccounts()

        // Створення елементів вікна
        val table = TableView<CardAccount>()
        val cardNumberColumn = TableColumn<CardAccount, String>("Card Number")
        val customerNameColumn = TableColumn<CardAccount, String>("Customer Name")
        val addressColumn = TableColumn<CardAccount, String>("Address")
        val balanceColumn = TableColumn<CardAccount, Double>("Balance")
        val typeColumn = TableColumn<CardAccount, String>("Type")
        val issueDateColumn = TableColumn<CardAccount, String>("Issue Date")
        val expiryDateColumn = TableColumn<CardAccount, String>("Expiry Date")
        val cardNumberField = TextField()
        val customerNameField = TextField()
        val addressField = TextField()
        val balanceField = TextField()
        val typeComboBox: ComboBox<String> = ComboBox<String>()
        typeComboBox.getItems().addAll("Credit", "Deposit")
        val issueDatePicker = DatePicker()
        val expiryDatePicker = DatePicker()
        val addButton = Button("Add")
        val deleteButton = Button("Delete")
        val filterButton = Button("Filter")

        // Налаштування вигляду елементів вікна
        table.columns.addAll(cardNumberColumn, customerNameColumn, addressColumn,
                balanceColumn, typeColumn, issueDateColumn, expiryDateColumn)
        table.setItems(repository!!.allCardAccounts)
        cardNumberColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, String?> -> cellData.value.cardNumberProperty() })
        customerNameColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, String?> -> cellData.value.customerNameProperty() })
        addressColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, String?> -> cellData.value.customerAddressProperty() })
        balanceColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, Double?> -> cellData.value.accountBalanceProperty().asObject() })
        typeColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, String?> -> cellData.value.accountTypeProperty() })
        issueDateColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, String?> -> cellData.value.issueDateProperty() })
        expiryDateColumn.setCellValueFactory(Callback { cellData: TableColumn.CellDataFeatures<CardAccount, String?> -> cellData.value.expiryDateProperty() })
        addButton.onAction = EventHandler { event: ActionEvent? ->
            val cardNumber = cardNumberField.text
            val customerName = customerNameField.text
            val address = addressField.text
            val balance = balanceField.text.toDouble()
            val type: String = typeComboBox.getValue()
            val issueDate: String = issueDatePicker.getValue().toString()
            val expiryDate: String = expiryDatePicker.getValue().toString()
            val account = CardAccount(cardNumber, customerName, address, balance, type, issueDate, expiryDate)
            repository!!.addCardAccount(account)
            clearFields(cardNumberField, customerNameField, addressField, balanceField, typeComboBox, issueDatePicker, expiryDatePicker)
        }
        deleteButton.onAction = EventHandler { event: ActionEvent? ->
            val selectedAccount = table.selectionModel.selectedItem
            if (selectedAccount != null) {
                repository!!.removeCardAccount(selectedAccount)
            }
        }
        filterButton.onAction = EventHandler { event: ActionEvent? ->
            val filterType: String = typeComboBox.getValue()
            val filteredList: ObservableList<CardAccount> = repository!!.allCardAccounts
                    .stream()
                    .filter { account: CardAccount -> account.accountType.get() == filterType }
                    .collect(Collectors.toCollection<CardAccount, ObservableList<CardAccount>>(Supplier<ObservableList<CardAccount>> { FXCollections.observableArrayList() }))
            table.setItems(filteredList)
        }

        // Розташування елементів вікна
        val root = VBox(10.0)
        root.setPadding(Insets(10.0))
        root.getChildren().addAll(table, Label("Card Number"), cardNumberField,
                Label("Customer Name"), customerNameField, Label("Address"), addressField,
                Label("Balance"), balanceField, Label("Type"), typeComboBox,
                Label("Issue Date"), issueDatePicker, Label("Expiry Date"), expiryDatePicker,
                addButton, deleteButton, filterButton)

        // Створення сцени і показ вікна
        val scene = Scene(root)
        primaryStage.setScene(scene)
        primaryStage.setTitle("Bank Card Accounts")
        primaryStage.show()
    }

    override fun stop() {
        // Збереження даних при закритті додатку
        saveAccounts()
    }

    private fun loadAccounts() {
        try {
            ObjectInputStream(FileInputStream("accounts.dat")).use { inputStream ->
                val accounts = inputStream.readObject() as List<CardAccount>
                repository!!.addAllCardAccounts(accounts)
            }
        } catch (e: IOException) {
            println("Error loading accounts: " + e.message)
        } catch (e: ClassNotFoundException) {
            println("Error loading accounts: " + e.message)
        }
    }

    private fun saveAccounts() {
        try {
            ObjectOutputStream(FileOutputStream("accounts.dat")).use { outputStream ->
                val accounts: List<CardAccount> = repository!!.allCardAccounts
                outputStream.writeObject(accounts)
            }
        } catch (e: IOException) {
            println("Error saving accounts: " + e.message)
        }
    }

    private fun clearFields(cardNumberField: TextField, customerNameField: TextField, addressField: TextField,
                            balanceField: TextField, typeComboBox: ComboBox<String>,
                            issueDatePicker: DatePicker, expiryDatePicker: DatePicker) {
        cardNumberField.clear()
        customerNameField.clear()
        addressField.clear()
        balanceField.clear()
        typeComboBox.getSelectionModel().clearSelection()
        issueDatePicker.getEditor().clear()
        expiryDatePicker.getEditor().clear()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(BankCardAccountApp::class.java, *args)
        }
    }
}