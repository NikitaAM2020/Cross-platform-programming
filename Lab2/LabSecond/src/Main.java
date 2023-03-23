import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float a, b, c, sum;

        System.out.print("Введіть перше число: ");
        while (!input.hasNextFloat()) {
            System.out.println("Ви ввели некоректні дані! \nВведіть перше число: ");
            input.next(); // consume the invalid input
        }
        a = input.nextFloat();

        System.out.print("Введіть друге чило: ");
        while (!input.hasNextFloat()) {
            System.out.println("Ви ввели некоректні дані! \nВведіть друге чило: ");
            input.next(); // consume the invalid input
        }
        b = input.nextFloat();

        System.out.print("Введіть третє число: ");
        while (!input.hasNextFloat()) {
            System.out.println("Ви ввели некоректні дані! \nВведіть третє число: ");
            input.next(); // consume the invalid input
        }
        c = input.nextFloat();


        if (a >= b && a >= c) {
            sum = a;
            if (b >= c) {
                sum += b;
            } else {
                sum += c;
            }
        } else if (b >= a && b >= c) {
            sum = b;
            if (a >= c) {
                sum += a;
            } else {
                sum += c;
            }
        } else {
            sum = c;
            if (a >= b) {
                sum += a;
            } else {
                sum += b;
            }
        }

        System.out.println("Суму двох найбільших чисел = " + sum);
    }
}