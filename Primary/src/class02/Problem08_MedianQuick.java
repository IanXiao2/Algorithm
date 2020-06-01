package class02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem08_MedianQuick {


    public static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class MedianHolder {

        private PriorityQueue<Integer> minHeap;  //小根堆放较大的 N/2 个数
        private PriorityQueue<Integer> maxHeap;  //大根堆放较小的 N/2 个数

        public MedianHolder() {
            minHeap = new PriorityQueue<>(new MinHeapComparator());
            maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        }

        public void modifyTwoHeapSize() {

            if (minHeap.size() == maxHeap.size() + 2) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() == minHeap.size() + 2) {
                minHeap.add(maxHeap.poll());
            }
        }

        public void addNumber(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            modifyTwoHeapSize();
        }

        public Integer getMedian() {

            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();

            if (minHeapSize + maxHeapSize == 0) {
                return null;
            }

            Integer minHeapHead = minHeap.peek();
            Integer maxHeapHead = maxHeap.peek();

            if (((minHeapSize + maxHeapSize) & 1) == 0) {
                return (minHeapHead + maxHeapHead) / 2;
            }

            return maxHeapSize > minHeapSize? maxHeapHead:minHeapHead;
        }

    }


    public static void main(String[] args) {

        int[] arr = {5, 8 , 11, 12 ,7, 9, 10};
        MedianHolder medianHolder = new MedianHolder();
        for (int i = 0; i < arr.length; i++) {
            medianHolder.addNumber(arr[i]);
        }
        System.out.println(medianHolder.getMedian());

    }

}
