package class04;

import java.util.Stack;

public class Problem04_IsPalindromeList {


    public static class Node {
        public int value;
        public Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    public static void printLinkedList (Node head) {
        System.out.println("Linked List:");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static boolean isPalindromeList1 (Node head) {

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;

    }

    public static boolean isPalindromeList2 (Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node right = head.next;
        Node cur = head;

        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<>();

        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.empty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static boolean isPalindromeList3 (Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;

        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }


        Node cur = n1;
        printLinkedList(head);
        printLinkedList(cur);

        Node pre = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        /*
        Node cur = n1.next;
        n1.next = null;

        System.out.println("==============");

        printLinkedList(head);  // 1 2 3
        printLinkedList(cur); // 2 1

        Node pre = n1;  // 3
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        */
        System.out.println("===============");
        printLinkedList(head);
        printLinkedList(pre);
        Node n3 = pre;   // 1 2 3
        n2 = head;
        boolean res = true;
        while (n2 != null && n3 != null) {
            if (n2.value != n3.value) {
                res = false;
                break;
            }
            n2 = n2.next;
            n3 = n3.next;
        }

        n3 = pre;
        pre = null;
        next = null;
        while (n3 != null) {
            next = n3.next;
            n3.next = pre;
            pre = n3;
            n3 = next;
        }

        return res;
    }


    public static void main (String[] args) {

        Node head = null;

        /*
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        */


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        printLinkedList(head);

        System.out.println(isPalindromeList3(head));

        printLinkedList(head);

    }
}
