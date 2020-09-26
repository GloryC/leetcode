package p113;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/9/26 11:10
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        List<Integer> subList = new ArrayList<>(list);
        subList.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(subList);
            }
            return;
        }
        dfs(root.left, sum - root.val, subList, res);
        dfs(root.right, sum - root.val, subList, res);
    }
}
