package class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem03_StackAndQueueConvert {



    public static class TwoStackConvertQueue {

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackConvertQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        public void add(int num) {
            stackPush.push(num);
            dao();
        }

        public int poll() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            dao();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            dao();
            return stackPop.peek();
        }

        public void dao() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }

    public static class TwoQueueConvertStack {

        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueConvertStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public void push(int num) {
            this.queue.add(num);
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public void swap() {
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
        }
    }

    public static void main(String[] args) {


        TwoStackConvertQueue queue = new TwoStackConvertQueue();
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("---------------------");

        TwoQueueConvertStack stack = new TwoQueueConvertStack();
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
