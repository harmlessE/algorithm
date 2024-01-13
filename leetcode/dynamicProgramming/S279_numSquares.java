package leetcode.dynamicProgramming;

public class S279_numSquares {

    public static void main(String[] args) {

        System.out.println(numSquares(1));
    }



    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        // 决策： 选平方数
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 0; j*j <= i; j++) {
                // dp[i-j*j]+ 1 可以化解掉一个完全平方数
                // 比如求解数字12的时候，j=2时，i-j*j =8，
                // 8就是已经求过结果的数字
                // j*j是完全平方数 结果一定是1
                dp[i] = Math.min(dp[i-j*j]+ 1 , dp[i]) ;
            }
        }
        return dp[n];
    }



    
}
