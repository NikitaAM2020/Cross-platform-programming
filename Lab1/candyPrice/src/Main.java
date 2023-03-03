import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Введіть вагу в кг шоколадних цукерок:");
        BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));
        float weightChocolate = Float.parseFloat(input.readLine());
        System.out.println("Введіть суму, яку заплачено за шоколадні цукерки:");
        float sumChocolate = Float.parseFloat(input.readLine());
        System.out.println("Введіть вагу в кг ірисок:");
        float weightToffee = Float.parseFloat(input.readLine());
        System.out.println("Введіть суму, яку заплачено за іриски:");
        float sumToffee = Float.parseFloat(input.readLine());
        float priceChocolate, priceToffee, p;
        priceChocolate = sumChocolate / weightChocolate;
        priceToffee = sumToffee / weightToffee;
        System.out.println("Вартість 1 кг шоколадних цукерок: " + priceChocolate + " грн.");
        System.out.println("Вартість 1 кг ірисок: " + priceToffee + " грн.");
        p = priceChocolate / priceToffee;
        System.out.println("Шоколадні цукерки дорожчі у " + p + " разів за іриски.");

    }
}