package class04;

import java.util.Stack;

public class Problem08_IsPopOrder {


    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length < 1 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        int[] pushA = {1, 2, 3, 4, 5};
        //int[] popA = {4, 5, 3, 1, 2};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(pushA, popA));

    }
}
