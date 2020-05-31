package class03;

public class Problem02_ZigZagPrintMatrix {


    public static void zigZagPrintMatrix(int[][] m) {
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endR = m.length - 1;
        int endC = m[0].length - 1;
        boolean fromUp = false;
        while (ar <= endR) {
            printLevel(m, ar, ac, br, bc, fromUp);
            ar = ac == endC? ar+1 : ar;
            ac = ac == endC? ac: ac+1;

            bc = br == endR? bc+1 : bc;  //顺序
            br = br == endR? br: br+1;


            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] m, int ar, int ac, int br, int bc, boolean fromUp) {
        if (fromUp) {
            while (ar <= br) {
                System.out.print(m[ar++][ac--]+ " ");
            }
        } else {
            while (br >= ar) {
                System.out.print(m[br--][bc++] + " ");
            }
        }
    }




    public static void main(String[] args) {
        int[][] m = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 14}};
        zigZagPrintMatrix(m);
    }
}
