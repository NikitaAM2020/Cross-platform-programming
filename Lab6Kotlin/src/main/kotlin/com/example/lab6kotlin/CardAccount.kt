package com.example.lab6kotlin

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import java.io.Serializable

class CardAccount(cardNumber: String?, customerName: String?, customerAddress: String?,
                  accountBalance: Double, accountType: String?, issueDate: String?, expiryDate: String?) : Serializable {
    private val cardNumber: SimpleStringProperty
    private val customerName: SimpleStringProperty
    private val customerAddress: SimpleStringProperty
    private val accountBalance: SimpleDoubleProperty
    val accountType: SimpleStringProperty
    private val issueDate: SimpleStringProperty
    private val expiryDate: SimpleStringProperty

    init {
        this.cardNumber = SimpleStringProperty(cardNumber)
        this.customerName = SimpleStringProperty(customerName)
        this.customerAddress = SimpleStringProperty(customerAddress)
        this.accountBalance = SimpleDoubleProperty(accountBalance)
        this.accountType = SimpleStringProperty(accountType)
        this.issueDate = SimpleStringProperty(issueDate)
        this.expiryDate = SimpleStringProperty(expiryDate)
    }

    fun getCardNumber(): String {
        return cardNumber.get()
    }

    fun cardNumberProperty(): SimpleStringProperty {
        return cardNumber
    }

    fun getCustomerName(): String {
        return customerName.get()
    }

    fun customerNameProperty(): SimpleStringProperty {
        return customerName
    }

    fun getCustomerAddress(): String {
        return customerAddress.get()
    }

    fun customerAddressProperty(): SimpleStringProperty {
        return customerAddress
    }

    fun getAccountBalance(): Double {
        return accountBalance.get()
    }

    fun accountBalanceProperty(): SimpleDoubleProperty {
        return accountBalance
    }

    fun getAccountType(): String {
        return accountType.get()
    }

    fun accountTypeProperty(): SimpleStringProperty {
        return accountType
    }

    fun getIssueDate(): String {
        return issueDate.get()
    }

    fun issueDateProperty(): SimpleStringProperty {
        return issueDate
    }

    fun getExpiryDate(): String {
        return expiryDate.get()
    }

    fun expiryDateProperty(): SimpleStringProperty {
        return expiryDate
    }
}