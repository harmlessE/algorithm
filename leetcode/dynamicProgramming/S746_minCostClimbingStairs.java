package leetcode.dynamicProgramming;

public class S746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        // dian

        int[] dp = new int[cost.length-1];

        dp[0] = 0;
        dp[1] = 0;

        // bian

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.max(dp[i-1] + cost[i], dp[i-2] + cost[i]);
        }

        return dp[cost.length-1];

        // xu

        // 先序FOR



    }
}
