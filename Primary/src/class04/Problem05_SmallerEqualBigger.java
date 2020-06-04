package class04;

public class Problem05_SmallerEqualBigger {


    public static class Node {
        public int value;
        public Node next;

        public Node (int data) {
            value = data;
        }
    }

    public static void printLinkedList (Node head) {
        System.out.println("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node listPartition1 (Node head, int pivot) {

        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;
        int N = 0;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[N];
        cur = head;
        for (int i = 0; i < N; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        partition(nodeArr, pivot);

        for (int i = 1; i < N; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }

        nodeArr[N - 1].next = null;
        return nodeArr[0];

    }

    public static void partition(Node[] nodeArr, int pivot) {
        int less = -1;
        int more = nodeArr.length;
        int index = 0;
        while (index < more) {

            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++less, index++);
            } else if (nodeArr[index].value > pivot) {
                swap(nodeArr, --more, index);
            } else {
                index++;
            }
        }
    }

    public static void swap(Node[] nodeArr, int i, int j) {
        Node tmp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmp;
    }

    public static Node listPartition2 (Node head, int pivot) {

        Node SH = null;
        Node ST = null;
        Node EH = null;
        Node ET = null;
        Node BH = null;
        Node BT = null;

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.value < pivot) {
                if (SH == null) {
                    SH = cur;
                    ST = cur;
                } else {
                    ST.next = cur;
                    ST = cur;
                }
            } else if (cur.value == pivot) {
                if (EH == null) {
                    EH = cur;
                    ET = cur;
                } else {
                    ET.next = cur;
                    ET = cur;
                }
            } else {
                if (BH == null) {
                    BH = cur;
                    BT = cur;
                } else {
                    BT.next = cur;
                    BT = cur;
                }
            }
            cur = next;
        }

        if (ST != null) {
            ST.next = EH;
            ET = ET == null? ST : ET;
        }
        if (ET != null) {
            ET.next = BH;
        }

        return SH != null? SH : EH != null? EH : BH;


    }

    public static void main (String[] args) {


        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);

        //head1 = listPartition1(head1, 5);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);



    }
}
