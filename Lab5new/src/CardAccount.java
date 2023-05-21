import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;

public class CardAccount implements Comparable<CardAccount> {

    private String cardNumber;
    private String clientSurname;
    private String clientAddress;
    private double balance;
    private boolean isCredit;
    private String dateIssued;
    private String expirationDate;

    public CardAccount(String cardNumber, String clientSurname, String clientAddress,
                       double balance, boolean isCredit, String dateIssued, String expirationDate) {
        this.cardNumber = cardNumber;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.balance = balance;
        this.isCredit = isCredit;
        this.dateIssued = dateIssued;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isCredit() {
        return isCredit;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(CardAccount other) {
        if (this.isCredit() && !other.isCredit()) {
            return -1;
        } else if (!this.isCredit() && other.isCredit()) {
            return 1;
        } else {
            return this.getCardNumber().compareTo(other.getCardNumber());
        }
    }

    public static void main(String[] args) {
        ArrayList<CardAccount> accounts = new ArrayList<>();
        accounts.add(new CardAccount("1111 2222 3333 4444", "Smith", "123 Main St", 100200, true, "01/01/2020", "01/01/2025"));
        accounts.add(new CardAccount("5555 6666 7777 8888", "Johnson", "456 Oak St", 505600, false, "01/01/2019", "01/01/2024"));
        accounts.add(new CardAccount("5005 6676 7677 0388", "Williams", "789 Maple St", 20000, true, "01/01/2018", "01/01/2023"));
        accounts.add(new CardAccount("1281 0022 0253 4964", "Ander", "123 Main St", 10010, true, "01/01/2020", "01/01/2025"));
        accounts.add(new CardAccount("1581 2722 0253 4534", "Davidson", "456 Oak St", 99000, false, "01/01/2019", "01/01/2024"));
        accounts.add(new CardAccount("7855 0266 1234 8858", "Mitchell ", "789 Maple St", 2080, true, "01/01/2018", "01/01/2023"));
        accounts.add(new CardAccount("1355 7896 7677 1478", "Holland", "123 Main St", 889157.35, false, "01/01/2020", "01/01/2025"));
        accounts.add(new CardAccount("5095 6000 7677 0318", "Anderson", "456 Oak St", 5000, false, "01/01/2019", "01/01/2024"));
        accounts.add(new CardAccount("1281 2722 0253 4534", "Baker", "789 Maple St", 2000, true, "01/01/2018", "01/01/2023"));
        accounts.add(new CardAccount("9927 0266 1234 8858", "Taylor", "123 Main St", 1000, true, "01/01/2020", "01/01/2025"));
        accounts.add(new CardAccount("1955 7861 7677 1978", "Mason", "456 Oak St", 5000, false, "01/01/2019", "01/01/2024"));

        Collections.sort(accounts);
        ArrayList<CardAccount> creditAccounts = new ArrayList<>();
        ArrayList<CardAccount> depositAccounts = new ArrayList<>();

        try (FileWriter writer = new FileWriter("accounts.txt")) {
            for (CardAccount account : accounts) {
                writer.write("Card number: " + account.getCardNumber() + ", " +
                        "| Client surname: " + account.getClientSurname() + ", " +
                        "| Client address: " + account.getClientAddress() + ", " +
                        "| Balance: " + account.getBalance() + ", " +
                        "Is credit: " + account.isCredit() + ", " +
                        "| Date issued: " + account.getDateIssued() + ", " +
                        "| Expiration date: " + account.getExpirationDate() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CardAccount account : accounts) {
            if (account.isCredit()) {
                creditAccounts.add(account);
            } else {
                depositAccounts.add(account);
            }
        }

        System.out.println("Credit accounts:");
        for (CardAccount account : creditAccounts) {
            System.out.println("Card number: " + account.getCardNumber() + "| Client surname: " +
                    account.getClientSurname() + "| Client address: " + account.getClientAddress() +
                    "| Balance: " + account.getBalance() + "| Date issued: " + account.getDateIssued() +
                    "| Expiration date: " + account.getExpirationDate());
        }

        System.out.println("Deposit accounts:");
        for (CardAccount account : depositAccounts) {
            System.out.println("Card number: " + account.getCardNumber() + "| Client surname: " + account.getClientSurname() + "| Client address: " + account.getClientAddress() + "| Balance: " + account.getBalance() + "| Date issued: " + account.getDateIssued() + "| Expiration date: " + account.getExpirationDate());
        }

        String searchNumber = "1355 7896 7677 1478";
        for (CardAccount account : accounts) {
            if (account.getCardNumber().equals(searchNumber)) {
                System.out.println("\nFound account:");
                System.out.println("Card number: " + account.getCardNumber());
                System.out.println("Client surname: " + account.getClientSurname());
                System.out.println("Client address: " + account.getClientAddress());
                System.out.println("Balance: " + account.getBalance());
                System.out.println("Is credit: " + account.isCredit());
                System.out.println("Date issued: " + account.getDateIssued());
                System.out.println("Expiration date: " + account.getExpirationDate());
                return;
            }
        }
        System.out.println("Account with card number " + searchNumber + " not found.");
    }
}