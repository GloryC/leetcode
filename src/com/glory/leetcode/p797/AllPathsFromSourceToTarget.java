package com.glory.leetcode.p797;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2022-01-23 15:54:22
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        // 记录所有路径
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            // 维护递归过程中经过的路径
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return res;
        }

        /**
         * 图的遍历框架
         */
        private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
            // 添加节点s到路径
            path.addLast(s);

            int n = graph.length;
            if (s == n-1){
                // reach the end
                res.add(new LinkedList<>(path));
                path.removeLast();
                return;
            }

            // 递归每个相邻节点
            for (int v : graph[s]) {
                traverse(graph, v, path);
            }

            // 从路径中移除节点s
            path.removeLast();
        }
    }

}
