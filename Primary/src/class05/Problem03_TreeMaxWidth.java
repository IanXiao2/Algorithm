package class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem03_TreeMaxWidth {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getTreeMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> levelMap = new HashMap<>();
        queue.add(head);
        levelMap.put(head, 1);
        Node cur = null;
        int curLevel = 1;
        int curLevelNodes = 0;
        int curNodeLevel = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                curLevel++;
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 1;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                levelMap.put(cur.left, curNodeLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                levelMap.put(cur.right, curNodeLevel + 1);
            }
        }
        return Math.max(max, curLevelNodes);
    }




    public static void main(String[] args) {


        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        int maxWidth = getTreeMaxWidth(head);
        System.out.println(maxWidth);

    }
}
