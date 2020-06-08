package p394;

import java.util.Stack;

/**
 * @author Glory
 * @date 2020/5/28 8:34
 */
public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ']') {
                StringBuilder valueStr = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    valueStr.insert(0, stack.pop());
                }
                stack.pop();

                // 注意多位数字
                StringBuilder countStr = new StringBuilder();
                while ((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countStr.insert(0, stack.pop());
                }
                int count = Integer.parseInt(countStr.toString());

                StringBuilder res = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    res.append(valueStr);
                }
                stack.push(res.toString());
            } else {
                String putStr = String.valueOf(c);
                stack.push(putStr);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("23[a]2[bc]"));
    }

}

