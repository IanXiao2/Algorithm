package class01;

import java.util.Arrays;

public class Problem02_BubbleSort {


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0～(N-1)范围两两比较交换，(N-1)位置确定；0～(N-2)范围两两比较交换，(N-2)位置确定
        for(int e = arr.length - 1; e > 0; e--) {
            for(int i = 0; i < e; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
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

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if(arr1 == null && arr2 == null) {
            return true;
        }
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //for test

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        return newArr;
    }

    public static int[] generateRandomArray(int maxValue, int maxSize) {
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static void main(String[] args) {


        int maxValue = 100;
        int maxSize = 20;
        int testTimes = 5000;
        boolean right = true;
        for(int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxValue, maxSize);
            int[] newArr = copyArray(arr);
            bubbleSort(arr);
            comparator(newArr);
            if(!isEqual(arr, newArr)) {
                right = false;
                printArray(arr);
                printArray(newArr);
            }
        }
        System.out.println(right? "right~~" : "wrong!!");

    }
}
