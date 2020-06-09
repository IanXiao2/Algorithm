package class02;

public class Problem07_MaxSumInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }
    }

    public static int maxSumInTree(Node head) {

        if (head == null) {
            return 0;
        }

        return process(head);

    }

    public static int process(Node node) {

        if (node.left == null && node.right == null) {
            return node.value;
        }
        int max = Integer.MIN_VALUE;
        if (node.left != null) {
            max = process(node.left);
        }
        if (node.right != null) {
            max = Math.max(max, process(node.right));
        }

        return max + node.value;
    }


    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(1);
        head.left.right = new Node(5);
        head.right = new Node(-7);
        head.right.left = new Node(3);
        System.out.println(maxSumInTree(head));

    }
}
