package p1028;

import util.TreeNode;

import java.util.Stack;

/**
 * @author Glory
 * @date 2020/6/18 8:57
 */
public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length(); ) {
            //查看在第几层，从0开始的，根节点是第0层
            int level = 0;
            while (S.charAt(i) == '-') {
                level++;
                i++;
            }

            //查看当前数字
            int val = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }

            //找到新结点的父节点
            while (stack.size() > level) {
                stack.pop();
            }
            //创建结点
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                //如果节点只有一个子节点，那么保证该子节点为左子节点。
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            //入栈
            stack.add(node);
        }
        //除了根节点，其他子节点全部出栈
        while (stack.size() > 1) {
            stack.pop();
        }
        //返回根节点
        return stack.pop();
    }
}
