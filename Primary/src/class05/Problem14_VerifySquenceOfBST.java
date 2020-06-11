package class05;

public class Problem14_VerifySquenceOfBST {

    public static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public static boolean process(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i;
        for(i = start; i < end; i ++) {
            if (seq[i] > seq[end]) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (seq[j] < seq[end]) {
                return false;
            }
        }
        return process(seq, start, i - 1) && process(seq, i, end - 1);
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length < 1) {
            return false;
        }
        return process(sequence, 0, sequence.length - 1);
    }

    public static void main(String[] args) {


        int[] seq = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(VerifySquenceOfBST(seq));
    }
}
