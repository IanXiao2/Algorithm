
import java.util.*;
import java.util.Collections;

public class Main {

    public static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        int level = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            ArrayList<Integer> levelRes = new ArrayList<>();
            while (sz != 0) {
                TreeNode cur = queue.poll();
                levelRes.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);

                }
                if (cur.right != null) {
                    queue.add(cur.right);

                }
                sz--;
            }
            level++;
            if ((level & 1) == 0) {
                Collections.reverse(levelRes);
            }
            res.add(levelRes);

        }
        return res;

    }

    public static void main(String[] args) {


        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);
        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> res = Print(head);

        System.out.println("----");
    }
}
