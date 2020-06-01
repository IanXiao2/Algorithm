package class02;

public class Problem06_HeapSort {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        /*

        for (int i = 0; i < arr.length; i++) { //O(NlogN)
            heapInsert(arr, i);
        }
        */

        //O(N)
        for (int i = arr.length - 1; i >=0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;

        swap(arr, 0, --heapSize);

        while (heapSize > 0) {

            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left]? left+1 : left;
            largest = arr[largest] > arr[index]? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {


        int[] arr = {7, 10, 8, 6, -1, 0};
        heapSort(arr);
        printArray(arr);

    }

}
