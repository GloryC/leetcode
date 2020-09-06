package p257;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2020/9/4 8:40
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                constructPaths(root.left, sb.toString(), paths);
                constructPaths(root.right, sb.toString(), paths);
            }
        }
    }

}
