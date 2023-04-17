import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        double[] A = new double[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            A[i] = rand.nextInt(21) - 10; // Генерувати випадкове ціле число в межах від -10 до 10
        }

        double[] B = new double[10];
        for (int k = 1; k <= 9; k++) {
            B[k] = 20 * Math.cos(k) - k;
        }
        double[] C = new double[10];
        for (int i = 0; i < 10; i++) {
            C[i] = B[i] - A[i];
        }

        double minA = findMin(A);
        double maxA = findMax(A);
        double sumA = minA * minA + maxA * maxA;
        System.out.println("Масив A: ");
        printArray(A);
        System.out.println("Сума квадратів мінімального та максимального елементів масиву A: " + sumA);

        double minB = findMin(B);
        double maxB = findMax(B);
        double sumB = minB * minB + maxB * maxB;
        System.out.println("Масив B:");
        printArray(B);
        System.out.println("Сума квадратів мінімального та максимального елементів масиву B: " + sumB);

        double minC = findMin(C);
        double maxC = findMax(C);
        double sumC = minC * minC + maxC * maxC;
        System.out.println("Масив C:");
        printArray(C);
        System.out.println("Сума квадратів мінімального та максимального елементів масиву C: " + sumC);
    }

    public static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printArray(double[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
