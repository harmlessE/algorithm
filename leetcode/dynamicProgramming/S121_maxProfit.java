package leetcode.dynamicProgramming;

public class S121_maxProfit {






        public int maxProfit1(int[] prices) {
            if(prices.length<2)
                return 0;


            int[][] dp = new int[prices.length][2];

            // dp[][0]代表不持有这只股票 时 i天手中最大的现金
            // dp[][1]代表持有这只股票 时 i天手中最大的现金


            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            //找前一天卖出的最大利润
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);

                // 这里为什么是 0-prices[i] 因为只能进行一次买卖所以跟前一天的最大现金没关系
                // dp代表的是可能的最大现金（最大利润） 前一天如果不持有股票 那么手中现金一定是0
                dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
            }

            return dp[prices.length-1][0];
        }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int res = 0;
        // 前一天卖出可以获得的最大利润
        int pre = 0;
        for (int i = 1; i < len; i++) {
            // 利润差
            int diff = prices[i] - prices[i - 1];
            // 状态转移方程：第i天卖出可以获得的最大利润 = 第i-1天卖出的最大利润 + 利润差
            pre = Math.max(pre + diff, 0);
            res = Math.max(res, pre);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int[][] dp = new int [len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            // 这里dp[i - 1][1] + prices[i]为什么能保证只卖了一次，因为下面一行代码买的时候已经保证了只买一次，所以这里自然就保证了只卖一次，不管是只允许交易一次还是允许交易多次，这行代码都不用变，因为只要保证只买一次（保证了只卖一次）或者买多次（保证了可以卖多次）即可。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //  - prices[i]这里可以理解为dp[0][0] - prices[i]，这里为什么是dp[0][0] - prices[i]，因为只有这样才能保证只买一次，所以需要用一开始初始化的未持股的现金dp[0][0]减去当天的股价
            dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
            // 如果题目允许交易多次，就说明可以从直接从昨天的未持股状态变为今天的持股状态，因为昨天未持股状态可以代表之前买过又卖过后的状态，也就是之前交易过多次后的状态。也就是下面的代码。
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }



}
