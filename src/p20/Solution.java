package p20;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Glory
 * @date 2019/10/28 8:54
 */
public class Solution {

    private HashMap<Character, Character> map;

    public Solution() {
        map = new HashMap<>(4);
        this.map.put(')', '(');
        this.map.put('}', '{');
        this.map.put(']', '[');
    }

    /**
     * 思路：如果是左括号进入则先压入栈底 push
     * 如果是右括号则取出栈顶进行比对 peek，如果匹配成功则取出 pop
     * 匹配结束后判断是否为空
     */
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                char pop = stack.isEmpty() ? '#' : stack.pop();
                if (pop != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("([)]"));
    }
}
