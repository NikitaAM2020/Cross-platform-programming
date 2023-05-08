import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CardAccount implements Serializable {
    private String cardNumber;
    private String clientLastName;
    private String city;
    private double accountBalance;
    private boolean credit;
    private Date validityFrom;
    private Date validityTo;

    public CardAccount(String cardNumber, String clientLastName, String city, double accountBalance,
                       boolean credit, Date validityFrom, Date validityTo) {
        this.cardNumber = cardNumber;
        this.clientLastName = clientLastName;
        this.city = city;
        this.accountBalance = accountBalance;
        this.credit = credit;
        this.validityFrom = validityFrom;
        this.validityTo = validityTo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public String getCity() {
        return city;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public boolean isCredit() {
        return credit;
    }

    public Date getValidityFrom() {
        return validityFrom;
    }

    public Date getValidityTo() {
        return validityTo;
    }

    public static List<CardAccount> getCreditCardList(List<CardAccount> cardAccounts) {
        List<CardAccount> creditCardList = new ArrayList<>();
        for (CardAccount cardAccount : cardAccounts) {
            if (cardAccount.isCredit()) {
                creditCardList.add(cardAccount);
            }
        }
        return creditCardList;
    }

    public static List<CardAccount> getDepositCardList(List<CardAccount> cardAccounts) {
        List<CardAccount> depositCardList = new ArrayList<>();
        for (CardAccount cardAccount : cardAccounts) {
            if (!cardAccount.isCredit()) {
                depositCardList.add(cardAccount);
            }
        }
        return depositCardList;
    }

    public static List<CardAccount> findCardAccountsByCardNumber(List<CardAccount> cardAccounts, String cardNumberToFind) {
        List<CardAccount> foundCardAccounts = new ArrayList<>();
        for (CardAccount cardAccount : cardAccounts) {
            if (cardAccount.getCardNumber().equals(cardNumberToFind)) {
                foundCardAccounts.add(cardAccount);
            }
        }
        return foundCardAccounts;
    }
}
