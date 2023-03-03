import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        System.out.println("Hi! What's your name?");
        BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));
        String userName = input.readLine();
        System.out.println("Nice to meet you, " + userName + "!");
        int now = 2023;
        System.out.println("How old are you?");
        int age = Integer.parseInt(input.readLine());
        System.out.println("You were born in " + (now - age) + " year.");
    }
}