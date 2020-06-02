package class01;

public class Problem05_BSFarLeftIndex {



    public static int farLeftIndex1(int[] arr, int num) {

        if (arr == null || arr.length < 1) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] >= num? l : index;
    }

    public static int farLeftIndex2(int[] arr, int num) {

        if (arr == null || arr.length < 1) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index;

    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 5, 5, 5, 7, 8, 10, 11};
        System.out.println(farLeftIndex1(arr, 2));
        System.out.println(farLeftIndex1(arr, 5));
        System.out.println(farLeftIndex1(arr, 6));

        System.out.println(farLeftIndex2(arr, 2));
        System.out.println(farLeftIndex2(arr, 5));
        System.out.println(farLeftIndex2(arr, 6));

    }

}
