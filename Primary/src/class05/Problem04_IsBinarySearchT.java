package class05;

public class Problem04_IsBinarySearchT {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int data) {
            this.value = data;
        }
    }

    public static class ReturnType {

        public int max;
        public int min;
        public boolean isBST;

        public ReturnType(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public static ReturnType process(Node node) {
        if (node == null) {
            return null;
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int max = node.value;
        int min = node.value;

        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }

        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= node.value)) {
            isBST = false;
        }

        if (rightData != null && (!rightData.isBST || node.value >= rightData.min)) {
            isBST = false;
        }

        return new ReturnType(max, min, isBST);

    }

    public static boolean isBinaryST(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
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
        head.right.right = new Node(10); // 10(true) 、8(false)
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.println(isBinaryST(head));

    }
}
