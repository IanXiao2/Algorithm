package class04;

public class Problem08_GetLoopNode {


    public static class Node {
        public int value;
        public Node next;

        public Node (int data) {
            value = data;
        }
    }

    //// 找到链表第一个入环节点，如果无环，返回null

    public static Node getLoopNode (Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // slow
        Node n2 = head.next.next; //fast
        while (n1 != n2) {
            if (n1.next == null|| n2.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }



    public static void main(String[] args) {

        Node head1 = null;

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        System.out.println(getLoopNode(head1).value);

    }
}
