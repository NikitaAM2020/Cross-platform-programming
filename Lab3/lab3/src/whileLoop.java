import java.util.Scanner;

public class whileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть число: ");
        double x = input.nextDouble();
        int n = (int) x;
        double sum = 0;
        int i = 1;
        while (i <= n) {
            if (i % 2 == 1) {
                sum += x / i;
            } else {
                sum -= x / i;
            }
            i++;
        }
        System.out.println("Сума знайдена за допомогою while: " + sum);
    }
}
