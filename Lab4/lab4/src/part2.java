import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class part2 {

    public static void main(String[] args) {
        int[][] A = readMatrixFromFile("matrix.txt", 5, 5);
        if (A != null) {
            System.out.println("Матриця A:");
            printMatrix(A);
            int sumAboveDiagonal = sumAboveDiagonal(A);
            int sumBelowDiagonal = sumBelowDiagonal(A);
            int[] diagonal = getDiagonal(A);
            int[] B = createNewMatrix(A, sumAboveDiagonal, sumBelowDiagonal, diagonal);
            int sumDiagonal = sumAboveDiagonal - sumBelowDiagonal;
            System.out.println("Різниця знайдених сум = " + sumDiagonal);
            printMatrixToFile(B, "newMatrix.txt");
            System.out.println("Нова матриця була записана у файл newMatrix.txt.");

        }
    }

    // Method to read matrix from file
    private static int[][] readMatrixFromFile(String fileName, int rows, int cols) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (scanner.hasNextInt()) {
                        matrix[i][j] = scanner.nextInt();
                    } else {
                        System.out.println("Помилка: Недостатньо елементів у файлі.");
                        return null;
                    }
                }
            }
            scanner.close();
            return matrix;
        } catch (FileNotFoundException e) {
            System.out.println("Помилка: файл не знайдено.");
            return null;
        }
    }

    // Method to calculate sum of elements above diagonal
    private static int sumAboveDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("\nСума елементів над головною діагоналлю = " + sum);
        return sum;
    }

    // Method to calculate sum of elements below diagonal
    private static int sumBelowDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Сума елементів під головною діагоналлю: " + sum);
        return sum;
    }

    // Method to get diagonal elements of matrix
    private static int[] getDiagonal(int[][] matrix) {
        int[] diagonal = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            diagonal[i] = matrix[i][i];
        }
        return diagonal;
    }

    // Method to create new matrix with modified diagonal
    private static int[] createNewMatrix(int[][] matrix, int sumAboveDiagonal, int sumBelowDiagonal, int[] diagonal) {
        int[] newDiagonal = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            newDiagonal[i] = sumAboveDiagonal - sumBelowDiagonal;
        }
        int[] B = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    B[index] = newDiagonal[i];
                } else {
                    B[index] = matrix[i][j];
                }
                index++;
            }
        }
        return B;
    }

    // Method to write matrix to file
    private static void printMatrixToFile(int[] matrix, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (int i = 0; i < matrix.length; i++) {
                writer.print(matrix[i] + " ");
                if ((i + 1) % 5 == 0) {
                    writer.println();
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Помилка: файл не знайдено.");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
