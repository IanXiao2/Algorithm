package class07;

public class Problem05_CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            value = data;
        }
    }

    // head必须为完全二叉树
    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * 以node为头的完全二叉树的节点个数
     * h 总深度
     * level node节点所在层
     */
    public static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else  {
            return (1 << (h - level -1)) + bs(node.left, level + 1, h);
        }

    }

    //以node 为头的完全二叉树子树的最大深度是多少
    //node节点当前在level层
    public static int mostLeftLevel(Node node, int level) {

        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
