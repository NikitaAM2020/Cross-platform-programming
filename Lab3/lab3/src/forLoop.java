import java.util.Scanner;

public class forLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть число: ");
        double x = input.nextDouble();
        int n = (int) x;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum += x / i;
            } else {
                sum -= x / i;
            }
        }
        System.out.println("Сума знайдена за допомогою for: " + sum);
    }
}
