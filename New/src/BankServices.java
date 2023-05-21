import java.io.*;
import java.util.*;

public class BankServices {
    private List<CardAccount> cardAccounts;
    private List<CreditCardAccount> creditCardAccounts;
    private List<DepositCardAccount> depositCardAccounts;

    public BankServices() {
        this.cardAccounts = new ArrayList<>();
        this.creditCardAccounts = new ArrayList<>();
        this.depositCardAccounts = new ArrayList<>();
    }

    public void addCardAccount(CardAccount cardAccount) {
        this.cardAccounts.add(cardAccount);

        if (cardAccount instanceof CreditCardAccount) {
            this.creditCardAccounts.add((CreditCardAccount) cardAccount);
        } else if (cardAccount instanceof DepositCardAccount) {
            this.depositCardAccounts.add((DepositCardAccount) cardAccount);
        }
    }

    public List<CardAccount> getCardAccounts() {
        return cardAccounts;
    }

    public List<CreditCardAccount> getCreditCardAccounts() {
        return creditCardAccounts;
    }

    public List<DepositCardAccount> getDepositCardAccounts() {
        return depositCardAccounts;
    }

    public CardAccount findCardAccount(String cardNumber) {
        for (CardAccount cardAccount : cardAccounts) {
            if (cardAccount.getCardNumber().equals(cardNumber)) {
                return cardAccount;
            }
        }

        return null;
    }

    public void writeToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (CardAccount cardAccount : cardAccounts) {
                writer.println(cardAccount.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }

    public void writeToFile(String fileName, List<CardAccount> cardAccounts) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (CardAccount cardAccount : cardAccounts) {
                writer.println(cardAccount.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }

    public void readFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";");

                String cardNumber = fields[0];
                String lastName = fields[1];
                String address = fields[2];
                double balance = Double.parseDouble(fields[3]);

                if (fields[4].equals("credit")) {
                    int creditLimit = Integer.parseInt(fields[5]);
                    int creditPercent = Integer.parseInt(fields[6]);
                    String issueDate = fields[7];
                    String expiryDate = fields[8];

                    CreditCardAccount creditCardAccount = new CreditCardAccount(
                            cardNumber,
                            lastName,
                            address,
                            balance,
                            creditLimit,
                            creditPercent,
                            issueDate,
                            expiryDate
                    );

                    addCardAccount(creditCardAccount);
                } else if (fields[4].equals("deposit")) {
                    int depositTerm = Integer.parseInt(fields[5]);
                    double depositPercent = Double.parseDouble(fields[6]);
                    String startDate = fields[7];
                    String endDate = fields[8];

                    DepositCardAccount depositCardAccount = new DepositCardAccount(
                            cardNumber,
                            lastName,
                            address,
                            balance,
                            depositTerm,
                            depositPercent,
                            startDate,
                            endDate
                    );
                    cardAccountsFromFile.add(depositCardAccount);
                }
            }
            fileReader.close();
            System.out.println("Successfully read " + cardAccountsFromFile.size() + " card accounts from file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        this.cardAccounts = cardAccountsFromFile;
    }

    public CardAccount findCardAccount(String cardNumber) {
        for (CardAccount cardAccount : cardAccounts) {
            if (cardAccount.getCardNumber().equals(cardNumber)) {
                return cardAccount;
            }
        }
        return null;
    }

    public ArrayList<CardAccount> getCreditCardAccounts() {
        ArrayList<CardAccount> creditCardAccounts = new ArrayList<>();
        for (CardAccount cardAccount : cardAccounts) {
            if (cardAccount instanceof CreditCardAccount) {
                creditCardAccounts.add(cardAccount);
            }
        }
        return creditCardAccounts;
    }

    public ArrayList<CardAccount> getDepositCardAccounts() {
        ArrayList<CardAccount> depositCardAccounts = new ArrayList<>();
        for (CardAccount cardAccount : cardAccounts) {
            if (cardAccount instanceof DepositCardAccount) {
                depositCardAccounts.add(cardAccount);
            }
        }
        return depositCardAccounts;
    }

    public void writeToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (CardAccount cardAccount : cardAccounts) {
                if (cardAccount instanceof CreditCardAccount) {
                    CreditCardAccount creditCardAccount = (CreditCardAccount) cardAccount;
                    fileWriter.write(creditCardAccount.getCardNumber() + ","
                            + creditCardAccount.getLastName() + ","
                            + creditCardAccount.getAddress() + ","
                            + creditCardAccount.getBalance() + ","
                            + "credit" + ","
                            + creditCardAccount.getCreditLimit() + ","
                            + creditCardAccount.getCreditPercent() + ","
                            + creditCardAccount.getStartDate() + ","
                            + creditCardAccount.getEndDate() + "\n");
                } else if (cardAccount instanceof DepositCardAccount) {
                    DepositCardAccount depositCardAccount = (DepositCardAccount) cardAccount;
                    fileWriter.write(depositCardAccount.getCardNumber() + ","
                            + depositCardAccount.getLastName() + ","
                            + depositCardAccount.getAddress() + ","
                            + depositCardAccount.getBalance() + ","
                            + "deposit" + ","
                            + depositCardAccount.getDepositTerm() + ","
                            + depositCardAccount.getDepositPercent() + ","
                            + depositCardAccount.getStartDate() + ","
                            + depositCardAccount.getEndDate() + "\n");
                }
            }
            fileWriter.close();
            System.out.println("Successfully wrote " + cardAccounts.size() + " card accounts to file.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void writeToFile(String fileName, ArrayList<CardAccount> cardAccounts) {
        this.cardAccounts = cardAccounts;
        writeToFile(fileName);
    }

    public static void main(String[] args) {
        BankServices bank = new BankServices();
        bank.readFromFile("card_accounts.txt");

        // Print all credit card accounts
        System.out.println("Credit Card Accounts:");
        ArrayList<CardAccount> creditCardAccounts = bank.getCreditCardAccounts();
        for (CardAccount cardAccount : creditCardAccounts) {
            System.out.println(cardAccount);
        }
        System.out.println();

        // Print all deposit card accounts
        System.out.println("Deposit Card Accounts:");
        ArrayList<DepositCardAccount> depositCardAccounts = bank.getDepositCardAccounts();
        if (depositCardAccounts.isEmpty()) {
            System.out.println("No deposit card accounts found.");
        } else {
            for (DepositCardAccount depositCardAccount : depositCardAccounts) {
                System.out.println(depositCardAccount);
            }
        }
    }

    public class CardAccount implements Comparable<CardAccount> {
        private String cardNumber;
        private String lastName;
        private String address;
        private double balance;
        private String cardType;
        private String issueDate;
        private String expiryDate;

        public CardAccount(String cardNumber, String lastName, String address, double balance,
                           String cardType, String issueDate, String expiryDate) {
            this.cardNumber = cardNumber;
            this.lastName = lastName;
            this.address = address;
            this.balance = balance;
            this.cardType = cardType;
            this.issueDate = issueDate;
            this.expiryDate = expiryDate;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public double getBalance() {
            return balance;
        }

        public String getCardType() {
            return cardType;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        @Override
        public int compareTo(CardAccount other) {
            if (this.cardNumber.compareTo(other.cardNumber) > 0) {
                return 1;
            } else if (this.cardNumber.compareTo(other.cardNumber) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Card Number: " + cardNumber + "\n" +
                    "Last Name: " + lastName + "\n" +
                    "Address: " + address + "\n" +
                    "Balance: " + balance + "\n" +
                    "Card Type: " + cardType + "\n" +
                    "Issue Date: " + issueDate + "\n" +
                    "Expiry Date: " + expiryDate + "\n";
        }
    }

    // Implementing the compareTo method in DepositCardAccount class for sorting
    public class DepositCardAccount extends CardAccount {
        private int term;
        private double interestRate;

        public DepositCardAccount(String cardNumber, String lastName, String address, double balance,
                                  int term, double interestRate, String issueDate, String expiryDate) {
            super(cardNumber, lastName, address, balance, "deposit", issueDate, expiryDate);
            this.term = term;
            this.interestRate = interestRate;
        }

        public int getTerm() {
            return term;
        }

        public double getInterestRate() {
            return interestRate;
        }

        @Override
        public int compareTo(CardAccount other) {
            if (other instanceof DepositCardAccount) {
                DepositCardAccount otherDeposit = (DepositCardAccount) other;
                if (this.term > otherDeposit.term) {
                    return 1;
                } else if (this.term < otherDeposit.term) {
                    return -1;
                } else {
                    return super.compareTo(other);
                }
            } else {
                return super.compareTo(other);
            }
        }

        @Override
        public String toString() {
            return super.toString() +
                    "Term: " + term + "\n" +
                    "Interest Rate: " + interestRate + "\n";
        }
    }

    // Implementing the compareTo method in CreditCardAccount class for sorting
    public class CreditCardAccount extends CardAccount {
        private double creditLimit;
        private double interestRate;

        public CreditCardAccount(String cardNumber, String lastName, String address, double balance,
                                 double creditLimit, double interestRate, String issueDate, String expiryDate) {
            super(cardNumber, lastName, address, balance);
            this.creditLimit = creditLimit;
            this.interestRate = interestRate;
            this.issueDate = issueDate;
            this.expiryDate = expiryDate;
        }
    }
}