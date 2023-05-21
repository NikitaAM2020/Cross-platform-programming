import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CardAccount> cardAccounts = new ArrayList<>();
        cardAccounts.add(new CardAccount("1111 2222 3333 4444", "Smith", "New York", 1000.0,
                true, new Date(2023, 4, 1), new Date(2028, 4, 1)));
        cardAccounts.add(new CardAccount("5555 6666 7777 8888", "Johnson", "Chicago", 2000.0,
                false, new Date(2021, 4, 1), new Date(2026, 3, 1)));
        cardAccounts.add(new CardAccount("5005 6676 7677 0388", "Anderson", "Chicago", 28600.85,
                false, new Date(2023, 1, 1), new Date(2028, 1, 1)));
        cardAccounts.add(new CardAccount("1281 2722 0253 4534", "Davidson ", "New York", 591.0,
                true, new Date(2019, 4, 1), new Date(2024, 4, 8)));
        cardAccounts.add(new CardAccount("7855 0266 1234 8858", "Mitchell ", "Bristol", 99610.0,
                true, new Date(2021, 4, 1), new Date(2026, 3, 1)));
        cardAccounts.add(new CardAccount("1355 7896 7677 1478", "Holland", "London", 889157.35,
                false, new Date(2023, 5, 1), new Date(2028, 5, 1)));
        cardAccounts.add(new CardAccount("5095 6000 7677 0318", "Anderson", "Chicago", 18960.85,
                false, new Date(2023, 1, 1), new Date(2028, 1, 1)));
        cardAccounts.add(new CardAccount("1281 2722 0253 4534", "Baker", "New York", 9591.0,
                true, new Date(2019, 4, 1), new Date(2024, 4, 8)));
        cardAccounts.add(new CardAccount("7855 0266 1234 8858", "Taylor", "Bristol", 39610.0,
                true, new Date(2021, 4, 1), new Date(2026, 3, 1)));
        cardAccounts.add(new CardAccount("1355 7896 7677 1478", "Mason", "London", 6157.35,
                true, new Date(2023, 5, 1), new Date(2028, 5, 1)));
        String fileName = "cardAccounts.txt";
        CardAccountFileManager.saveCardAccountsToFile(cardAccounts, fileName);
        CardAccountFileManager.loadCardAccountsFromFile(fileName);

        // вивести список кредитних карток
        List<CardAccount> creditCardList = CardAccount.getCreditCardList(cardAccounts);
        System.out.println("Credit Card List:");
        for (CardAccount cardAccount : creditCardList) {
            System.out.println("Card Number: " + cardAccount.getCardNumber() +
                    ", Client Last Name: " + cardAccount.getClientLastName() +
                    ", Account Balance: " + cardAccount.getAccountBalance());
        }

        // вивести список депозитних карток
        List<CardAccount> depositCardList = CardAccount.getDepositCardList(cardAccounts);
        System.out.println("\nDeposit Card List:");
        for (CardAccount cardAccount : depositCardList) {
            System.out.println("Card Number: " + cardAccount.getCardNumber() +
                    ", Client Last Name: " + cardAccount.getClientLastName() +
                    ", Account Balance: " + cardAccount.getAccountBalance());
        }
        // знайти картковий рахунок за номером картки

        String cardNumberToFind = "5005 6676 7677 0388";

        List<CardAccount> foundCardAccounts = CardAccount.findCardAccountsByCardNumber(cardAccounts, cardNumberToFind);
        if (!foundCardAccounts.isEmpty()) {
            System.out.println("\nFound Card Accounts:");
            for (CardAccount cardAccount : foundCardAccounts) {
                System.out.println("Card Number: " + cardAccount.getCardNumber() +
                        ", Client Last Name: " + cardAccount.getClientLastName() +
                        ", Account Balance: " + cardAccount.getAccountBalance());
            }
        } else {
            System.out.println("No Card Accounts Found");
        }

    }
}
