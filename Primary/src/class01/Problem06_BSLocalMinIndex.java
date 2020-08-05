package class01;

public class Problem06_BSLocalMinIndex {

    public static int localMinIndex(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int N = arr.length;
        if (arr.length == 1 || arr[0] < arr[1]) {
            return arr[0];
        }

        if (arr[N - 1] < arr[N -2]) {
            return arr[N - 1];
        }
        int l = 1;
        int r = N - 2;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] > arr[m - 1]) {
                r = m - 1;
            } else if (arr[m] > arr[m + 1]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        System.out.println(localMinIndex(arr));

    }
}
