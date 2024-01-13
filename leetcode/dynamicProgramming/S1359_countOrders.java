package leetcode.dynamicProgramming;

public class S1359_countOrders {



    // 一共i个包裹等会话  2i个item  2i个位置里面找到2个位置放置新的订单 这两个物品只有一种顺序有效所以说是组合不是排列
    // C[2*i][2] = 2i*(2i-1)/2
    // C[a][b] = A[a][b]/A[b][b]
    public static final int MOD = (int)1e9 + 7;

    // 和i-1个包裹时的关系是相乘： i-1个包裹例如有10种，每种都能给我现在这个插 那么就是dp[i-1] * 2i(2i-1)/2
    public int countOrders(int n) {

        long[] dp = new long[n+1];

        long ans = 1;

        for (int i = 2; i < n+1; i++) {
            long temp = (ans * i * ( 2 * i -1));

            ans =  temp % MOD;
        }

        return (int) ans;

    }



}
