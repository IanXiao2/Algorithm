package class04;

public class Problem02_ReverseList {

    public static class Node{

        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printLinkedList(Node head) {
        System.out.println("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.println("Double Linked List:");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;

    }

    public static void main(String[] args) {


        Node head1 = null;
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        head1 = node1;

        printLinkedList(head1);

        head1 = reverseLinkedList(head1);

        printLinkedList(head1);

        DoubleNode head2 = null;

        DoubleNode dNode1 = new DoubleNode(1);
        DoubleNode dNode2 = new DoubleNode(2);
        DoubleNode dNode3 = new DoubleNode(3);
        DoubleNode dNode4 = new DoubleNode(4);

        dNode1.next = dNode2;
        dNode2.last = dNode1;
        dNode2.next = dNode3;
        dNode3.last = dNode2;
        dNode3.next = dNode4;
        dNode4.last = dNode3;

        head2 = dNode1;
        printDoubleLinkedList(head2);

        head2 = reverseDoubleLinkedList(head2);

        printDoubleLinkedList(head2);

    }
}
