package class01;

import java.util.Arrays;

public class Problem01_SelectionSort {


    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //使得0位置有序， 0~(N-1)选出最小; 使得0～1位置有序，1~(N-1)选出最小;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr, i, minIndex);
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

    public static void main (String[] args) {

        int maxValue = 100;
        int maxSize = 20;
        int testTimes = 5000;
        boolean right = true;
        for(int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxValue, maxSize);
            int[] newArr = copyArray(arr);
            selectionSort(arr);
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
