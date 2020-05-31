package class02;

public class Problem04_NetherlandsFlag {



    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int i = l;
        while (i < more) {
            if (arr[i] < p) {
                swap(arr, ++less, i++);
            } else if (arr[i] > p) {
                swap(arr, --more, i);
            } else {
                i++;
            }
        }
        return new int[] {less + 1, more - 1};
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
            arr[i] = (int)(Math.random() * 3);
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

    public static void main(String[] args) {

        int[] test = generateArray();
        printArray(test);
        int[] res = partition(test, 0, test.length-1, 1);
        printArray(res);
        printArray(test);

    }
}
