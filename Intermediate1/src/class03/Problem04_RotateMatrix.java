package class03;

import java.util.ArrayList;

public class Problem04_RotateMatrix {


    public static void rotateMatrix(int[][] m) {
        int ar = 0;
        int ac = 0;
        int br = m.length - 1;
        int bc = m[0].length - 1;

        while(ar <= br && ac <= bc) {
            rotateEdge(m, ar++, ac++, br--, bc--);
        }


    }

    public static void rotateEdge(int[][] m, int ar, int ac, int br, int bc) {
        for(int i = 0; i < bc - ac; i++) {
            int tmp = m[ar][ac + i];
            m[ar][ac + i] = m[br - i][ac];
            m[br - i][ac] = m[br][bc - i];
            m[br][bc - i] = m[ar + i][bc];
            m[ar + i][bc] = tmp;
        }
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotateMatrix(matrix);
        printMatrix(matrix);
    }

}
