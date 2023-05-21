package com.example.lab6banknew;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CardAccountRepository {
    private ObservableList<CardAccount> cardAccounts;

    public CardAccountRepository() {
        cardAccounts = FXCollections.observableArrayList();
    }

    public ObservableList<CardAccount> getAllCardAccounts() {
        return cardAccounts;
    }

    public void addCardAccount(CardAccount cardAccount) {
        cardAccounts.add(cardAccount);
    }

    public void removeCardAccount(CardAccount cardAccount) {
        cardAccounts.remove(cardAccount);
    }

    public void addAllCardAccounts(List<CardAccount> accounts) {
        cardAccounts.addAll(accounts);
    }

    public ObservableList<CardAccount> getCreditCardAccounts() {
        ObservableList<CardAccount> creditAccounts = FXCollections.observableArrayList();
        for (CardAccount account : cardAccounts) {
            if (account.getAccountType().equals("Credit")) {
                creditAccounts.add(account);
            }
        }
        return creditAccounts;
    }

    public ObservableList<CardAccount> getDepositCardAccounts() {
        ObservableList<CardAccount> depositAccounts = FXCollections.observableArrayList();
        for (CardAccount account : cardAccounts) {
            if (account.getAccountType().equals("Deposit")) {
                depositAccounts.add(account);
            }
        }
        return depositAccounts;
    }

    public CardAccount searchByCardNumber(String cardNumber) {
        for (CardAccount account : cardAccounts) {
            if (account.getCardNumber().equals(cardNumber)) {
                return account;
            }
        }
        return null;
    }
}
