import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c, d;
        System.out.println("Розглядаємо систему, яка має вигляд:");
        System.out.println("x - a >= 0");
        System.out.println("x^2 + bx +c < 0");
        System.out.println("Введіть коефіцієнти нерівності a, b, c\nКоефіцієнт a = ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        System.out.println("Коефіцієнт b = ");
        b = scanner.nextDouble();
        System.out.println("Коефіцієнт c = ");
        c = scanner.nextDouble();
        d = b * b - 4 * c;
        if (d <= 0) { //друга нерівність не має коренів
            System.out.println("Дана система немає коренів");
        } else {//вітка, що виконується лише коли d > 0
            double x1 = (-b - Math.sqrt(d)) / 2;
            double x2 = (-b + Math.sqrt(d)) / 2;
            //формули для x1 та x2 обрані так, що x1 < x2
            if (a <= x1) {
                System.out.printf(
                        "Розв'язок має вигляд: x Є (%.3f; %.3f)\n", x1, x2);
            } else {
                if (x1 < a && a < x2)
                    System.out.printf("Розв'язок має вигляд: x Є [%.3f; %.3f)\n", a, x2);
            }
        }
    }
}

