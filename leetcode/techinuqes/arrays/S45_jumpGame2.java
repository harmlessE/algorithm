package leetcode.techinuqes.arrays;



//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
//每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//0 <= j <= nums[i]
//i + j < n
//返回到达 nums[n - 1] 的最小跳跃次数
public class S45_jumpGame2 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        // assume that dp[i] store the minimal jump times of i
        dp[0] = 0;
        int reach = 0;
        int jump =0;
        for (int i = 1; i < nums.length; i++) {
            if(i + nums[i] > reach){
                jump+=1;
                reach = i + nums[i];
            }
        }
        return jump;
    }

}
