package class05;

public class Problem06_IsFullBT {


    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType {

        public int height;
        public int nodesNum;

        public ReturnType(int height, int nodesNum) {
            this.height = height;
            this.nodesNum = nodesNum;
        }
    }

    public static boolean isFullBT(Node head) {
        if (head == null) {
            return true;
        }

        ReturnType headData = process(head);

        return headData.nodesNum == (1 << headData.height) - 1;

    }

    public static ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(0, 0);
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodesNum = leftData.nodesNum + rightData.nodesNum + 1;

        return new ReturnType(height, nodesNum);
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        //head.left.left.left = new Node(1);  //
        head.right.left = new Node(7);
       //head.right.left.left = new Node(6);  //
        head.right.right = new Node(10);
        //head.right.right.left = new Node(9);  //
        //head.right.right.right = new Node(11);  //

        System.out.println(isFullBT(head));

    }
}
