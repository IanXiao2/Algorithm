package class03;

public class Problem05_FindNumInSortedMatrix {

    public static boolean findNumInSortedMatrix(int[][] m, int target) {

        int r = 0;
        int c = m[0].length - 1;
        while (r < m.length && c >= 0) {
            if (target == m[r][c]) {
                return true;
            } else if (target > m[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        int[][] matrix = new int[][] {{1, 5, 9, 10},
                {2, 6, 11, 13},
                {7, 9, 15, 17}};

        System.out.println(findNumInSortedMatrix(matrix, 6));

    }
}
