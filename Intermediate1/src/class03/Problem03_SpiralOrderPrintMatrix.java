package class03;

public class Problem03_SpiralOrderPrintMatrix {

    public static void spiralOrderPrintMatrix(int[][] m) {
        int ar = 0;
        int ac = 0;
        int br = m.length - 1;
        int bc = m[0].length - 1;
        while (ar <= br && ac <= bc) {
            printEdge(m, ar++, ac++, br--, bc--);
        }

    }

    public static void printEdge(int[][] m, int ar, int ac, int br, int bc) {
        if (ar == br) {
            for(int i = ac; i <= bc; i++) {
                System.out.print(m[ar][i] + " ");
            }
        } else if (ac == bc) {
            for(int i = ar; i <= br; i++) {
                System.out.print(m[i][ac] + " ");
            }
        } else {
            int curR = ar;
            int curC= ac;
            while (curC < bc) {
                System.out.print(m[ar][curC++] + " ");
            }
            while (curR < br) {
                System.out.print(m[curR++][curC] + " ");
            }
            while (curC > ac) {
                System.out.print(m[curR][curC--] + " ");
            }
            while (curR > ar) {
                System.out.print(m[curR--][curC] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrintMatrix(matrix);
    }
}
