package p225;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 思路：负负得正，从输入栈压入输出栈，则能完成元素的调换
 *
 * @author Glory
 * @date 2019/9/18 8:43
 */
public class MyStack {

    private Queue<Integer> input;
    private Queue<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        input.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int res = 0;
        while (!input.isEmpty()) {
            if (input.size() == 1) {
                res = input.remove();
            } else {
                output.add(input.remove());
            }
        }
        while (!output.isEmpty()) {
            input.add(output.remove());
        }
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int res = 0;
        while (!input.isEmpty()) {
            if (input.size() == 1) {
                res = input.peek();
            }
            output.add(input.remove());
        }
        while (!output.isEmpty()) {
            input.add(output.remove());
        }
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return input.isEmpty();
    }

}
