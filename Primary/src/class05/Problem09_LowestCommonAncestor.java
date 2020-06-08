package class05;

import java.util.HashMap;
import java.util.HashSet;

public class Problem09_LowestCommonAncestor {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }

    }

    public static Node lowestCommonAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestCommonAncestor(head.left, o1, o2);
        Node right = lowestCommonAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }

        return left != null? left:right;
    }

    public static Node lowestCommonAncestor2(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, null);
        setMap(head, fatherMap);
        HashSet<Node> set = new HashSet<>();
        while (fatherMap.containsKey(o1)) {
            set.add(o1);
            o1 = fatherMap.get(o1);
        }

        while (!set.contains(o2)) {
            o2 = fatherMap.get(o2);
        }
        return o2;
    }

    public static void setMap(Node node, HashMap<Node, Node> fatherMap) {
        if (node == null) {
            return ;
        }
        if (node.left != null) {
            fatherMap.put(node.left, node);
        }
        if (node.right != null) {
            fatherMap.put(node.right, node);
        }
        setMap(node.left, fatherMap);
        setMap(node.right, fatherMap);
    }

    public static void main (String[] args) {


        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);

        System.out.println("===============");

        Node o1 = head.left.right;
        Node o2 = head.right.left;

        System.out.println("o1 : " + o1.value);
        System.out.println("o2 : " + o2.value);
        System.out.println("ancestor : " + lowestCommonAncestor(head, o1, o2).value);

        System.out.println("ancestor : " + lowestCommonAncestor2(head, o1, o2).value);


    }
}
