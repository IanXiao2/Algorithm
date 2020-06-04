package class04;

public class Problem09_FindFirstCommonNode {


    public static class Node {

        public int value;
        public Node next;

        public Node (int data) {
            value = data;
        }
    }

    // 两个无环单链表，返回第一个相交节点，如果不想交，返回null
    public static Node findFirstCommonNode (Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }
        System.out.println(n);
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0? head1: head2; //谁长谁的头为cur1
        cur2 = cur1 == head1? head2:head1; // 谁短谁的头为cur2
        n = Math.abs(n);

        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }




    public static void main (String[] args) {

        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        Node head2 = null;
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2

        System.out.println(findFirstCommonNode(head1, head2).value);

    }

}
