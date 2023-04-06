import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть x: ");
        double x = Double.parseDouble(scanner.next().replace(',', '.'));
        if (x <= 1 && x >= -1) {
            System.out.print("Введіть eps: ");
            double eps = Double.parseDouble(scanner.next().replace(',', '.'));
            double result1 = PowerSeries.powerSeriesArcctg(x, eps);
            double result2 = Math.atan(x);
            double difference = Math.abs(result1 - result2);

            System.out.println("Результат отриманий за допомогою розкладу в степеневий ряд: " + result1);
            System.out.println("Результат отриманий за допомогою методів класу Math: " + result2);
            System.out.println("Модуль різниці значень: " + difference);
        } else {
            System.out.println("Помилка: x повинно бути в діапазоні [-1, 1]");
        }
    }
}
