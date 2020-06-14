package class01;

public class Problem03_InsertionSort {


    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        //0~1有序；0~2有序；0~3有序....
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] >= arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        if(arr == null) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {

        int[] arr = {4,3,1,5};
        insertionSort(arr);
        printArray(arr);

    }
}
