package class05;

public class Problem07_IsBalancedBT {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }

    }

    public static class ReturnType {

        public int height;
        public boolean isBBT;

        public ReturnType(int height, boolean isBBT) {
            this.height = height;
            this.isBBT = isBBT;
        }
    }

    public static boolean isBalancedBT(Node head) {
        if (head == null) {
            return  true;
        }
        return process(head).isBBT;
    }

    public static ReturnType process(Node node) {

        if (node == null) {
            return new ReturnType(0, true);
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBBT = leftData.isBBT && rightData.isBBT
                && Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(height, isBBT);
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        //head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println(isBalancedBT(head));

    }
}
