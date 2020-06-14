package class07;

public class Problem02_PrintNoInArray {


    //给定一个整数数组A，长度为n，有 1 <= A[i] <= n，且对于[1,n]的整数，其中部分整数会重复出现而部分不会出现。
    // 实现算法找到[1,n]中所有未出现在A中的整数。

    public static void printNumberNoInArray(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            modify(arr, arr[i]);

        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                System.out.println(i + 1);
            }
        }

    }

    public static void modify(int[] arr, int value) {

        while (arr[value - 1] != value) {
            int tmp = arr[value - 1];
            arr[value - 1] = value;
            value = tmp;
        }

    }

    public static void main(String[] args) {

        int[] test = { 3, 2, 3, 5, 6, 1, 6 };
        //int[] test = {2, 3, 1, 0, 2, 5, 3};
        printNumberNoInArray(test);

    }
}
