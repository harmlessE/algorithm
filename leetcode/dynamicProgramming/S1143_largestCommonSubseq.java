package leetcode.dynamicProgramming;

import java.util.Arrays;

public class S1143_largestCommonSubseq {

    // 子序列问题 就用二维动态规划！
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化dp[0][] 和dp[][0]为0，因为当一个字符串长度为0时，那么他们的LCS长度也为0
        Arrays.fill(dp[0], 0);
        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1))//该字符可以加入LCS
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else{//该位置的字符不相等，至少有一个不能加入LCS，先选择当前局部最优解，即选择前面的较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }



}
