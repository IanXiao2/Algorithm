package class05;

public class Problem01_SortedRatateArrayFindMin {

    // 旋转有序数组后，找出最小值
    public static int sortedRatateArrayFindMin(int[] arr) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        //假设 L..R 范围，有min
        while (L < R) {
            if (L == R - 1) { //只剩两个数
                break;
            }
            if (arr[L] < arr[R]) { // L..R 范围上没有旋转
                return arr[L];
            }

            mid = (L + R) / 2;
            if (arr[L] > arr[mid]) { // arr[L] >= arr[R] && arr[L] > arr[mid] => 在左侧
                R = mid;
                continue;
            }
            if (arr[mid] > arr[R]) { // arr[L] >= arr[R] && arr[L] <= arr[mid] && arr[mid] > arr[R] => 在右侧
                L = mid;
                continue;
            }

            // arr[L] >= arr[R] && arr[L] <= arr[mid] && arr[mid] <= arr[R]
            // => arr[L] = arr[mid] = arr[R]
            while (L < mid) {  // 2 3 3 1 2 2 2 2 2
                if (arr[L] == arr[mid]) {
                    L++;
                } else if (arr[L] < arr[mid]) {
                    return arr[L];
                } else {
                    R = mid;
                    break;
                }
            }
        }

        return Math.min(arr[L], arr[R]);
    }


    public static void main(String[] args) {

        int[] test = { 4, 5, 5, 5, 1, 2, 3 };
        System.out.println(sortedRatateArrayFindMin(test));
    }
}
