package com.example.lab6banknew;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class CardAccount implements Serializable {
    private SimpleStringProperty cardNumber;
    private SimpleStringProperty customerName;
    private SimpleStringProperty customerAddress;
    private SimpleDoubleProperty accountBalance;
    private SimpleStringProperty accountType;
    private SimpleStringProperty issueDate;
    private SimpleStringProperty expiryDate;

    public CardAccount(String cardNumber, String customerName, String customerAddress,
                       double accountBalance, String accountType, String issueDate, String expiryDate) {
        this.cardNumber = new SimpleStringProperty(cardNumber);
        this.customerName = new SimpleStringProperty(customerName);
        this.customerAddress = new SimpleStringProperty(customerAddress);
        this.accountBalance = new SimpleDoubleProperty(accountBalance);
        this.accountType = new SimpleStringProperty(accountType);
        this.issueDate = new SimpleStringProperty(issueDate);
        this.expiryDate = new SimpleStringProperty(expiryDate);
    }

    public String getCardNumber() {
        return cardNumber.get();
    }

    public SimpleStringProperty cardNumberProperty() {
        return cardNumber;
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress.get();
    }

    public SimpleStringProperty customerAddressProperty() {
        return customerAddress;
    }

    public double getAccountBalance() {
        return accountBalance.get();
    }

    public SimpleDoubleProperty accountBalanceProperty() {
        return accountBalance;
    }

    public String getAccountType() {
        return accountType.get();
    }

    public SimpleStringProperty accountTypeProperty() {
        return accountType;
    }

    public String getIssueDate() {
        return issueDate.get();
    }

    public SimpleStringProperty issueDateProperty() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate.get();
    }

    public SimpleStringProperty expiryDateProperty() {
        return expiryDate;
    }
}
