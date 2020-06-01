package class02;

import java.util.PriorityQueue;

public class Problem07_SortArrayDistanceLessK {


    public static void sortedArrDistLessK(int[] arr, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //系统自带的堆是小根堆
        int index = 0;
        for (; index < Math.min(arr.length, K); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 5, 4, 3, 6, 7, 9, 8 };
        sortedArrDistLessK(arr, 3);

        printArray(arr);
    }
}
