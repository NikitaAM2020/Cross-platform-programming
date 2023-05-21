//import java.io.*;
//import java.time.LocalDate;
//
//public CardAccount(String cardNumber, String lastName, String address, double balance,
//        String cardType, String issueDate, String expiryDate) {
//        this.cardNumber = cardNumber;
//        this.lastName = lastName;
//        this.address = address;
//        this.balance = balance;
//        this.cardType = cardType;
//        this.issueDate = issueDate;
//        this.expiryDate = expiryDate;
//        }
//
//public String getCardNumber() {
//        return cardNumber;
//        }
//
//public String getLastName() {
//        return lastName;
//        }
//
//public String getAddress() {
//        return address;
//        }
//
//public double getBalance() {
//        return balance;
//        }
//
//public String getCardType() {
//        return cardType;
//        }
//
//public String getIssueDate() {
//        return issueDate;
//        }
//
//public String getExpiryDate() {
//        return expiryDate;
//        }
//
//@Override
//public int compareTo(CardAccount other) {
//        if (this.cardNumber.compareTo(other.cardNumber) > 0) {
//        return 1;
//        } else if (this.cardNumber.compareTo(other.cardNumber) < 0) {
//        return -1;
//        } else {
//        return 0;
//        }
//        }
//
//@Override
//public String toString() {
//        return "Card Number: " + cardNumber + "\n" +
//        "Last Name: " + lastName + "\n" +
//        "Address: " + address + "\n" +
//        "Balance: " + balance + "\n" +
//        "Card Type: " + cardType + "\n" +
//        "Issue Date: " + issueDate + "\n" +
//        "Expiry Date: " + expiryDate + "\n";
//        }
