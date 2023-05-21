package com.example.lab6kotlin

import javafx.collections.FXCollections
import javafx.collections.ObservableList

class CardAccountRepository {
    val allCardAccounts: ObservableList<CardAccount>

    init {
        allCardAccounts = FXCollections.observableArrayList()
    }

    fun addCardAccount(cardAccount: CardAccount) {
        allCardAccounts.add(cardAccount)
    }

    fun removeCardAccount(cardAccount: CardAccount) {
        allCardAccounts.remove(cardAccount)
    }

    fun addAllCardAccounts(accounts: List<CardAccount>?) {
        allCardAccounts.addAll(accounts!!)
    }

    val creditCardAccounts: ObservableList<CardAccount>
        get() {
            val creditAccounts = FXCollections.observableArrayList<CardAccount>()
            for (account in allCardAccounts) {
                if (account.getAccountType() == "Credit") {
                    creditAccounts.add(account)
                }
            }
            return creditAccounts
        }
    val depositCardAccounts: ObservableList<CardAccount>
        get() {
            val depositAccounts = FXCollections.observableArrayList<CardAccount>()
            for (account in allCardAccounts) {
                if (account.getAccountType() == "Deposit") {
                    depositAccounts.add(account)
                }
            }
            return depositAccounts
        }

    fun searchByCardNumber(cardNumber: String): CardAccount? {
        for (account in allCardAccounts) {
            if (account.getCardNumber() == cardNumber) {
                return account
            }
        }
        return null
    }
}