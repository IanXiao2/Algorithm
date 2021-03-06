package class02;

public class Problem03_InversePairs {

    public static int inversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return process(array, 0, array.length - 1);

    }
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(arr, l, m) + process(arr, m + 1, r) + merge(arr, l, m, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int res = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] > arr[p2]? (m - p1 + 1):0;
            help[i++] = arr[p1] <= arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for ( i = 0;i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }





    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 5, 0};

        System.out.println(inversePairs(arr));


    }

}
