import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Цей клас представляє програму для генерації ромбовидної матриці з заповненням символами.
 * Розмір матриці та символ-заповнювач вводяться користувачем.
 */
public class Lab1_Sobol_KI_303 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір квадратної матриці: ");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("Розмір квадратної матриці повинен бути непарним числом.");
            return;
        }

        System.out.print("Введіть символ-заповнювач: ");
        String fillChar = scanner.next();

        if (fillChar.length() != 1) {
            System.out.println("Введено більше одного символу-заповнювача.");
            return;
        }

        char[][] matrix = new char[n][n];

        char fillSymbol = fillChar.charAt(0);

        int middle = n / 2;

        // Заповнюємо матрицю символом-заповнювачем
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = fillSymbol;
            }
        }

        // Заповнюємо ромб пробілами
        for (int i = 0; i <= middle; i++) {
            for (int j = middle - i; j <= middle + i; j++) {
                matrix[i][j] = ' ';
                matrix[n - 1 - i][j] = ' ';
            }
        }

        // Виводимо матрицю на екран
        System.out.println("Матриця:");
        printMatrix(matrix);

        // Записуємо матрицю в текстовий файл
        try {
            FileWriter fileWriter = new FileWriter("matrix.txt");
            fileWriter.write("Матриця:\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    fileWriter.write(matrix[i][j]);
                }
                fileWriter.write('\n');
            }
            fileWriter.close();
            System.out.println("Матрицю також збережено у файлі 'matrix.txt'.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл.");
            e.printStackTrace();
        }
    }

    /**
     * Метод для виведення матриці на екран.
     *
     * @param matrix Двовимірний масив, який представляє матрицю для виведення.
     */
    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
