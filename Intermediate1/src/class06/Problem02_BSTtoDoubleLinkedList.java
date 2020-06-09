package class06;

public class Problem02_BSTtoDoubleLinkedList {


    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {

        public Node start;
        public Node end;
        public Info (Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return new Info(null, null);
        }
        Info leftData = process(node.left);
        Info rightData = process(node.right);

        node.left = leftData.end;
        if (leftData.end != null) {
            leftData.end.right = node;
        }

        node.right = rightData.start;
        if (rightData.start != null) {
            rightData.start.left = node;
        }

        Node start = leftData.start != null? leftData.start:node;
        Node end = rightData.end != null? rightData.end: node;
        return new Info(start, end);

    }

    public static Node convert(Node head) {
        if (head == null) {
            return head;
        }
        return process(head).start;
    }


    //for test
    public static void inOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }

    public static void printDoubleLinkedList(Node head) {
        if (head == null) {
            return;
        }
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");

        while (end != null) {
            System.out.print(end.value + " ");

            end = end.left;
        }
        System.out.println();
    }


    public static void main(String[] args) {


        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        inOrderPrint(head);
        System.out.println();
        head = convert(head);
        printDoubleLinkedList(head);
        System.out.println();

    }
}
