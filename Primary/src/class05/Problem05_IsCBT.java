package class05;

import java.util.LinkedList;
import java.util.Queue;

public class Problem05_IsCBT {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean isLeft = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node l = cur.left;
            Node r = cur.right;

            if ((isLeft && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            } else {
                isLeft = true;
            }
        }

        return true;

    }

    public static void main(String[] args) {


        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        //head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        //head.right.right.left = new Node(9);
        //head.right.right.right = new Node(11);

        System.out.println(isCBT(head));

    }
}
