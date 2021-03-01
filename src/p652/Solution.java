package p652;

import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2021/3/1 20:12
 */
public class Solution {

    /**
     * 记录所有子树以及出现的次数
     */
    private HashMap<String, Integer> memo = new HashMap<>();

    /**
     * 记录重复的子树根节点
     */
    private LinkedList<TreeNode> res = new LinkedList<>();

    /**
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     * 你需要以列表的形式返回上述重复子树的根结点。
     * <p>
     * 使用后序遍历实现
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }

}
