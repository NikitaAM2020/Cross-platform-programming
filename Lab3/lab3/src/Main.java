import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double x = random.nextDouble() * 25;
        int n = (int) x; // найближче до Х натуральне число, менше за Х
        double sum = 0;

        // цикл з while
        int i = 1;
        while (i <= n) {
            double term = x / i;
            if (i % 2 == 0) {
                sum -= term;
            } else {
                sum += term;
            }
            i++;
        }
        System.out.println("x = " + x);
        System.out.println("Сума (while): " + sum);

        // цикл з do-while
        i = 1;
        sum = 0;
        do {
            double term = x / i;
            if (i % 2 == 0) {
                sum -= term;
            } else {
                sum += term;
            }
            i++;
        } while (i <= n);
        System.out.println("x = " + x);
        System.out.println("Сума (do-while): " + sum);

        // цикл з for
        sum = 0;
        for (i = 1; i <= n; i++) {
            double term = x / i;
            if (i % 2 == 0) {
                sum -= term;
            } else {
                sum += term;
            }
        }
        System.out.println("x = " + x);
        System.out.println("Сума (for): " + sum);
    }
}
