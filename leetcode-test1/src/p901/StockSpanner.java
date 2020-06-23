package p901;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Glory
 * @date 2020/6/23 10:44
 */
public class StockSpanner {

    private Map<Integer, Integer> map = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >= stack.peek()) {
            count += map.get(stack.peek());
            stack.pop();
        }
        stack.push(price);
        map.put(price, count);
        return count;
    }
}
