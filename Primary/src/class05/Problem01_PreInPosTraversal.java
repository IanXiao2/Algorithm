package class05;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Stack;

public class Problem01_PreInPosTraversal {


    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node (int data) {
            this.value = data;
        }

    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void postOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = null;

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print( head.value + " ");
                head = head.right;
            }
        }
    }

    public static void postOrderUnRecur(Node head) {
        if (head == null) {
            return ;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        Node cur = null;
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }



    public static void main(String[] args) {


        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("post-order: ");
        postOrderRecur(head);
        System.out.println();

        System.out.println("==============unrecursive==============");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);
        System.out.println();

        System.out.print("in-order: ");
        inOrderUnRecur(head);
        System.out.println();

        System.out.print("post-order: ");
        postOrderUnRecur(head);
        System.out.println();

    }
}
