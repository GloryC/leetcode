package p20;

import java.util.Stack;

/**
 * @author Glory
 * @date 2019/10/28 8:54
 */
public class Solution3 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.isValid("()[]{}"));
    }
}
