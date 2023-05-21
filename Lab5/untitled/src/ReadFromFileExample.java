import java.io.*;
import java.util.*;

public class ReadFromFileExample {
    public static void main(String[] args) {
        List<CardAccount> cardAccounts = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cardAccounts.txt"))) {
            while (true) {
                CardAccount cardAccount = (CardAccount) ois.readObject();
                cardAccounts.add(cardAccount);
            }
        } catch (EOFException e) {
            // Кінець файлу
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        // Вивести список на екран
        for (CardAccount cardAccount : cardAccounts) {
            System.out.println(cardAccount);
        }
    }
}
