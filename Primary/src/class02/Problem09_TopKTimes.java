package class02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem09_TopKTimes {


    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.times - o2.times;
        }
    }

    public static void topKTimes (String[] arr, int K) {

        if (arr == null || arr.length < 1) {
            return;
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());
        int heapSize = Math.min(arr.length, K);

        //建立词频表
        HashMap<String, Integer> map = new HashMap<>();
        for (String str:arr) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            if (minHeap.size() < heapSize) {
                minHeap.add(node);
            } else {
                if (minHeap.peek().times < node.times) {
                    minHeap.poll();
                    minHeap.add(node);
                }
            }
        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.peek().str + " : " + minHeap.peek().times);
            minHeap.poll();
        }

    }



    public static void main(String[] args) {

        String[] arr1 = { "A", "B", "A", "C", "A", "C", "B", "B", "K" };
        topKTimes(arr1, 3);

    }
}
