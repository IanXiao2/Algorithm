package class02;

import java.util.Arrays;

public class Problem01_MergeSort {


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        process(arr, l, m);
        process(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2]? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    //for test

    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxSize + 1) * Math.random()) - (int)(maxSize * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {


        int testTime = 100;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "right":"wrong");

    }
}
