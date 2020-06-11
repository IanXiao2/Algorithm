package class05;

import java.util.ArrayList;

public class Problem13_SumEqualTargetPath {

    public static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }



    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        process(ret, path, target, root.val, root);
        return ret;
    }

    public static void process( ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path, int target, int cur, TreeNode node) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (cur == target) {

                ret.add(new ArrayList<>(path));
                //ret.add(path);

            }
        }
        if (node.left != null) {

            process(ret, path, target, cur+node.left.val, node.left);
        }
        if (node.right != null) {
            process(ret, path, target, cur+node.right.val, node.right);
        }
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {


        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.right = new TreeNode(12);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(7);


        ArrayList<ArrayList<Integer>> res = FindPath(head, 22);

        System.out.println("----");
    }
}
