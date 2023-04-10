import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть x: ");
        double x = Double.parseDouble(scanner.next().replace(',', '.'));

        double eps = 0.00001;
        double result1 = PowerSeries.powerSeriesArcctg(x, eps);
        double result2;
        if (x < -1) {
            result2 = Math.PI - Math.atan(1 / x);
        } else result2 = Math.atan(1 / x);

        double difference = Math.abs(result1 - result2);

        System.out.println("Результат отриманий за допомогою розкладу в степеневий ряд: " + result1);
        System.out.println("Результат отриманий за допомогою методів класу Math: " + result2);
        System.out.println("Модуль різниці значень: " + difference);
    }
}
