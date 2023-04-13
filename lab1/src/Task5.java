import java.util.Random;

public class Task5 {
    static void Transposition(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                swap(array, i, j);
            }
        }
    }

    static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = rand.nextInt(10);
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        Transposition(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
