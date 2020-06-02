package class01;

public class Problem07_EvenTimesOddTimes {


    public static void printOddTimesOneNum(int[] arr) {
        int e0 = 0;
        for (int cur:arr) {
            e0 ^= cur;
        }
        System.out.println(e0);
    }

    public static void printOddTimesTwoNum(int[] arr) {

        int e0 = 0;
        for (int cur:arr) {
            e0 ^= cur;
        }
        //e0 = a^b

        int e1 = 0;
        int mostRightOne = e0 & (~e0 + 1);
        for (int cur:arr) {
            if ((cur & mostRightOne) == 1) {  //错误
                e1 ^= cur;
            }
        }
        int a = e1;
        int b = e0^e1;
        System.out.println(a + ", " + b);
    }


    public static void printOddTimesTwoNum2(int[] arr) {
        int eor = 0;
        for (int i = 0 ; i < arr.length;i++) {
            eor ^= arr[i];
        }
        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0; // eor'

        for (int cur:arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesOneNum(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesTwoNum(arr2);

        int[] arr3 = {2,4,3,6,3,2,5,5};
        printOddTimesTwoNum(arr3);
        printOddTimesTwoNum2(arr3);

    }
}
