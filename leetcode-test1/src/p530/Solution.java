package p530;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2020/10/12 9:31
 */
public class Solution {

    private TreeNode preNode = null;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
        //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
        getMin(root);
        return result;
    }

    private void getMin(TreeNode root){
        if(root == null) return;

        getMin(root.left);
        if(preNode != null) {
            result = Math.min(Math.abs(root.val - preNode.val), result);
        }
        preNode = root;
        getMin(root.right);
    }

}
