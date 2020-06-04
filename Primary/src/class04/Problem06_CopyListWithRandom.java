package class04;

import java.util.HashMap;

public class Problem06_CopyListWithRandom {


    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node (int value) {
            this.value = value;
        }
    }

    public static void printRandLinkedList (Node head) {
        Node cur = head;
        System.out.print("order : ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }

        System.out.println();

        cur = head;
        System.out.print("rand : ");
        while (cur != null) {
            System.out.print(cur.rand == null? "-":cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();

    }

    public static Node copyListWithRandom (Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node (cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }

        return map.get(head);

    }

    public static void main (String[] args) {


        Node head = null;
        Node res1 = null;
        Node res2 = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRandom(head);
        printRandLinkedList(res1);

    }

}
