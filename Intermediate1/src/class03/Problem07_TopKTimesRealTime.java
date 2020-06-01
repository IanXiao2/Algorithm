package class03;

import java.util.HashMap;

public class Problem07_TopKTimesRealTime {


    public static class Node {
        public String str;
        public int times;
        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class TopKRecord {
        private Node[] heap;  //小根堆
        private int heapSize;
        private HashMap<String, Node> strNodeMap; // 词频表
        private HashMap<Node, Integer> nodeIndexMap; //node在堆的位置表

        public TopKRecord(int K) {
            heap = new Node[K];
            heapSize = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void swap(int i, int j) {

            nodeIndexMap.put(heap[i], j);
            nodeIndexMap.put(heap[j], i);

            Node tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        public void heapInsert(int index) {
            while (heap[index].times > heap[(index - 1)/2].times) {
                swap(index, (index - 1)/2);
                index = (index - 1) / 2;
            }
        }

        public void heapify(int index, int size) {
            int left = 2 * index + 1;
            while (left < size) {
                int smallest = left + 1 < size && heap[left + 1].times < heap[left].times? left + 1: left;
                smallest = heap[smallest].times < heap[index].times? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = 2 * index + 1;
            }
        }

        public void add (String str) {
            int preIndex = -1;
            Node cur = null;
            if (!strNodeMap.containsKey(str)) {
                cur = new Node(str, 1);
                strNodeMap.put(str, cur);
                nodeIndexMap.put(cur, -1);
            } else {
                cur = strNodeMap.get(str);
                cur.times++;
                //strNodeMap.put(str, cur);
                preIndex = nodeIndexMap.get(cur);
            }

            if (preIndex == -1) {  //不在堆上

                if (heapSize == heap.length) {  //堆已满
                    if (heap[0].times < cur.times) {  //cur的出现次数超过堆的门槛
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(cur, 0);

                        heap[0] = cur;
                        heapify(0, heapSize);
                    }

                } else {  //堆未满
                    heap[heapSize] = cur;
                    nodeIndexMap.put(cur, heapSize);
                    heapInsert(heapSize++);
                }

            } else {  //在堆上
                heapify(preIndex, heapSize);
            }
        }

        public void printTopK() {
            for (int i = 0; i < heap.length; i++) {
                if (heap[i] == null) {
                    return;
                }
                System.out.print("Str : " + heap[i].str);
                System.out.println(" Times : " + heap[i].times);
            }
        }
    }


    public static void main(String[] args) {

        TopKRecord record = new TopKRecord(2);
        record.add("zuo");
        record.printTopK();
        System.out.println("---------");
        record.add("cheng");
        record.add("cheng");
        record.printTopK();
        System.out.println("---------");
        record.add("Yun");
        record.add("Yun");
        record.printTopK();

    }
}
