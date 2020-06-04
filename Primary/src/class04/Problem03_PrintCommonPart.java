package class04;

public class Problem03_PrintCommonPart {


    public static class Node {
        public int value;
        public Node next;
        public Node (int value) {
            this.value = value;
        }
    }

    public static void printLinkedList (Node head) {

        System.out.println("Linke List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printCommonPart(Node head1, Node head2) {

        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head2.value < head1.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {

        Node head1 = null;
        Node head2 = null;
        head1 = new Node(2);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(6);

        head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(8);

        printLinkedList(head1);
        printLinkedList(head2);
        printCommonPart(head1, head2);
    }

}
