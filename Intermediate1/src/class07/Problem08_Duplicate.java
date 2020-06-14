package class07;

public class Problem08_Duplicate {

    //在一个长度为n的数组里的所有数字都在0到n-1的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字是重复的。
    // 也不知道每个数字重复几次。请找出数组中任意一个重复的数字

    public static boolean duplicate(int[] numbers,int length,int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] != numbers[numbers[i]]) {
                    swap(numbers, i, numbers[i] );
                } else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] test = {2, 3, 1, 0, 2, 5, 3};

        int[] duplication = new int[1];

        System.out.println(duplicate(test,test.length, duplication));
        System.out.println();
    }
}
