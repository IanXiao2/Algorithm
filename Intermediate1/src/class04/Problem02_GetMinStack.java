package class04;

import java.util.Stack;

public class Problem02_GetMinStack {


    public static class MyStack {

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int num) {

            if (stackMin.isEmpty()) {
                stackMin.push(num);
            } else if (stackMin.peek() >= num){
                stackMin.push(num);
            } else if (stackMin.peek() < num) {
                stackMin.push(stackMin.peek());
            }
            stackData.push(num);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is Empty");
            }
            int value = stackData.pop();
            stackMin.pop();
            return value;
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is Empty");
            }
            return stackMin.peek();
        }

    }


    public static void main(String[] args) {

        MyStack stack = new MyStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());

    }
}
