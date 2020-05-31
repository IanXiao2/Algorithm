package class02;

public class Problem05_QuickSort {


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int)((r - l + 1)*Math.random()), r);
            int[] p = partition(arr, l, r);
            process(arr, l, p[0] - 1);
            process(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int i = l;
        while (i < more) {
            if (arr[i] < arr[r]) {
                swap(arr, ++less, i++);
            } else if (arr[i] > arr[r]) {
                swap(arr, --more, i);
            } else {
                i++;
            }
        }
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    // for test

    public static int[] generateArray(){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 10);
        }
        return arr;
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


    public static void main(String[] args) {

        int[] test = generateArray();
        printArray(test);
        int[] arr = copyArray(test);
        quickSort(arr);
        printArray(arr);

    }
}
