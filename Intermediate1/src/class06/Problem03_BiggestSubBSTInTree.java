package class06;

public class Problem03_BiggestSubBSTInTree {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public static class Info {

        public int max;
        public int min;
        public int maxBSTSize;
        public boolean isBST;
        public Node maxBSTHead;

        public Info(int max, int min, int maxBSTSize, boolean isBST, Node maxBSTHead) {
            this.max = max;
            this.min = min;
            this.maxBSTSize = maxBSTSize;
            this.isBST = isBST;
            this.maxBSTHead = maxBSTHead;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return null;
        }
        Info leftData = process(node.left);
        Info rightData = process(node.right);

        int max = node.value;
        int min = node.value;
        if (leftData != null) {
            max = Math.max(max, leftData.max);
            min = Math.min(min, leftData.min);
        }
        if (rightData != null) {
            max = Math.max(max, rightData.max);
            min = Math.min(min, rightData.min);
        }

        int maxBSTSize = 0;
        Node maxBSTHead = null;
        if (leftData != null) {
            maxBSTHead = leftData.maxBSTHead;
            maxBSTSize = leftData.maxBSTSize;
        }

        if (rightData != null && rightData.maxBSTSize > maxBSTSize) {
            maxBSTSize = rightData.maxBSTSize;
            maxBSTHead = rightData.maxBSTHead;
        }

        boolean isBST = false;

        if ((leftData == null || leftData.isBST) && (rightData == null || rightData.isBST)) {
            if ((leftData == null || leftData.max < node.value)
                    && (rightData == null || node.value < rightData.min)) {
                isBST = true;
                int leftSize = leftData == null? 0:leftData.maxBSTSize;
                int rightSize = rightData == null? 0:rightData.maxBSTSize;
                maxBSTSize = leftSize + rightSize + 1;
                maxBSTHead = node;
            }
        }

        return new Info(max, min, maxBSTSize, isBST, maxBSTHead);

    }


    public static Node getMaxSubBST(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).maxBSTHead;
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {

        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);

        printTree(head);
        Node bst = getMaxSubBST(head);
        printTree(bst);

    }
}
