package leetcode.dynamicProgramming;

public class S1510 {


    public static void main(String[] args) {

        winnerSquareGame(4);
    }




    public static boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];

        dp[1] = true;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j] || j * j == i) {
                    dp[i] = true;
                    break;
                }else{
                    dp[i] = false;
                }
            }
        }

        return dp[n];
    }
}
