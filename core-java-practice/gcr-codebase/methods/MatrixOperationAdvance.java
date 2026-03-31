import java.util.*;
class MatrixOperationAdvance {
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        return matrix;
    }
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] trans = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        return trans;
    }
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])- m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])+ m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) {
            return null;
        }
        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] =  m[0][0] / det;
        return inv;
    }
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) {
            return null;
        }
        double[][] inv = new double[3][3];
        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = (m[0][2]*m[2][1] - m[0][1]*m[2][2]) / det;
        inv[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;
        inv[1][0] = (m[1][2]*m[2][0] - m[1][0]*m[2][2]) / det;
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = (m[0][2]*m[1][0] - m[0][0]*m[1][2]) / det;
        inv[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = (m[0][1]*m[2][0] - m[0][0]*m[2][1]) / det;
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;
        return inv;
    }
    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Inverse does not exist");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (2 or 3): ");
        int size = sc.nextInt();
        double[][] matrix = createRandomMatrix(size, size);
        System.out.println("Matrix:");
        displayMatrix(matrix);
        System.out.println("Transpose:");
        displayMatrix(transpose(matrix));
        if (size == 2) {
            System.out.println("Determinant: " + determinant2x2(matrix));
            System.out.println("Inverse:");
            displayMatrix(inverse2x2(matrix));
        } else {
            System.out.println("Determinant: " + determinant3x3(matrix));
            System.out.println("Inverse:");
            displayMatrix(inverse3x3(matrix));
        }
        sc.close();
    }
}