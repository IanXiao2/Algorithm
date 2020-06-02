package class01;

public class Problem06_BSLocalMinIndex {


    public static int localMinIndex(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        int N = arr.length - 1;
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }

        int l = 1;
        int r = N - 2;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        System.out.println(localMinIndex(arr));

    }
}
