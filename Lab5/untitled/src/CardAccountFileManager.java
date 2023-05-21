import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardAccountFileManager {

    /**
     * Записує список карткових рахунків у файл
     * @param cardAccounts Список карткових рахунків
     * @param fileName Ім'я файлу
     */
    public static void saveCardAccountsToFile(List<CardAccount> cardAccounts, String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(cardAccounts);
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error saving card accounts to file: " + e.getMessage());
        }
    }

    /**
     * Зчитує список карткових рахунків з файлу
     * @param fileName Ім'я файлу
     * @return Список карткових рахунків
     */
    public static List<CardAccount> loadCardAccountsFromFile(String fileName) {
        List<CardAccount> cardAccounts = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            cardAccounts = (List<CardAccount>) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading card accounts from file: " + e.getMessage());
        }
        return cardAccounts;
    }
}
