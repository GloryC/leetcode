package o09;

import java.util.LinkedList;

/**
 * @author Glory
 * @date 2020/6/30 8:45
 */
public class CQueue {

    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public CQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            if (in.isEmpty()) return -1;
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        } else {
            return out.pop();
        }
    }
}
