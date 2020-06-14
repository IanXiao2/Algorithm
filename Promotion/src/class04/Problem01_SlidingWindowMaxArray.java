package class04;

import java.util.LinkedList;

public class Problem01_SlidingWindowMaxArray {


    public static class WindowMax {

        private int L;
        private int R;
        private int[] arr;                  // arr[L, R) 滑动窗口
        private LinkedList<Integer> qmax;  //维持一个从大到小的双向链表

        public WindowMax(int[] a) {
            L = -1;
            R = 0;
            arr = a;
            qmax = new LinkedList<>();
        }

        public void addNumFromRight() {
            if (R == arr.length) {
                return;
            }
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            R++;
        }

        public void removeNumFromLeft() {
            if (L >= R - 1) {
                return;
            }
            L++;
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
        }

        public int getMax() {
            if (!qmax.isEmpty()) {
                return arr[qmax.peekFirst()];
            }
            return Integer.MIN_VALUE;
        }

    }

    public static int[] slidingWindowMax1(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        WindowMax windowMax = new WindowMax(arr);
        for (int i = 0; i < w; i++) {
            windowMax.addNumFromRight();
        }
        res[index++] = windowMax.getMax();
        for (int i = w; i < arr.length; i++) {
            windowMax.addNumFromRight();
            windowMax.removeNumFromLeft();
            res[index++] = windowMax.getMax();
        }
        return res;
    }

    public static int[] slidingWindowMax2(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {  // i - w是当前过期位置
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    //for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {


        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;

        printArray(slidingWindowMax1(arr, w));
        System.out.println();
        printArray(slidingWindowMax2(arr, w));

    }
}
