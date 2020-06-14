package class01;

public class Problem08_ReOrderOddEvenArr {

    //简单排序应用
    //使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分

    public static void reOrderOddEvenArr(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && (array[j+1]&1)!=0 &&(array[j]&1) == 0; j--) {
                swap(array, j, j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {

        int[] arr = {4, 1, 5, 6, 7, 8};
        reOrderOddEvenArr(arr);
        printArr(arr);

    }
}
