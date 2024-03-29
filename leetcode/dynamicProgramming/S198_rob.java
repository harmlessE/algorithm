package leetcode.dynamicProgramming;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2：
//
//
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
//
// Related Topics 数组 动态规划 👍 2888 👎 0

// [12,1,1,9,1,1]

class S198_rob {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        // dp[i] 代表选择i号房间 偷盗n天能偷盗到的最大金额
        // 都是正数又要最大化 所以要么选0 要么选1 起始条件确定
        dp[0] = nums[0];
        // 第二家可能不偷 如果不偷 则是0 所以不能直接赋值偷第二家
        // 而是需要比较 如果偷第一家更赚 则赋值为第一家
        // 如果
//        dp[i] = Math.max(nums[1i],dp[i-1]);
        for (int i = 1; i < nums.length; i++) {
            // 偷上上个+偷这个  和  偷上一个不偷这个作比较
            dp[i] = Math.max((i>=2 ? dp[i-2] : 0 )+ nums[i] , dp[i-1] );

        }
        return dp[nums.length-1];
    }












}
