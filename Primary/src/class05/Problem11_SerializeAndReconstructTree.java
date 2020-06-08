package class05;

import java.util.LinkedList;
import java.util.Queue;

public class Problem11_SerializeAndReconstructTree {


    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }

    }

    public static String serialByPre (Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr) {

        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }

        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {

        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node node = new Node(Integer.valueOf(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);

        return node;
    }

    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void main(String[] args) {

        Node head = null;

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);


        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");

        preOrder(head);

    }

}
