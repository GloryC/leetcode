package p746;

/**
 * @author Glory
 * @date 2020/3/8 22:37
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0;
        for (int i = 0; i < cost.length; i++) {
            int cur = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = cur; // 指针后移
        }
        return Math.min(f0, f1);
    }

    public int minCostClimbingStairs2(int[] cost) {
        //我是这样理解的,感觉比较好理解
        //dp数组的每一个元素表示到达当前楼层所需的最小花费
        //也就是dp的第i个值是不包含cost[i]的，因为还没从第i层走出去，没消耗体力
        //dp的长度=cost+1，dp的最后一个元素就是到达楼顶所需的最小花费
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;//因为最开始可以选择起点，而选择起点是不消耗体力的
        for (int i = 2; i < dp.length; i++) {
            //要么从第i-2层走到第i层，从要么第i-1层走到第i层
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[dp.length - 1];
    }

}
