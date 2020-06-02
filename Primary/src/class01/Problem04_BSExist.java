package class01;

public class Problem04_BSExist {


    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return arr[l] == num;
    }

    public static boolean exist2(int[] arr, int num) {
        if (arr == null || arr.length  < 1) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        int[] arr = {1, 3, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16};

        System.out.println(exist(arr, 3));
        System.out.println(exist(arr,16));
        System.out.println(exist(arr, 4));

        System.out.println("--------------------");

        System.out.println(exist2(arr, 3));
        System.out.println(exist2(arr,16));
        System.out.println(exist2(arr, 4));
    }
}
