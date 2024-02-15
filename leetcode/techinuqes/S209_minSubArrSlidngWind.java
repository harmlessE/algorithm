package leetcode.techinuqes;

public class S209_minSubArrSlidngWind {
//    给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//    找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
//    示例 1：
//
//    输入：target = 7, nums = [2,3,1,2,4,3]
//    输出：2
//    解释：子数组 [4,3] 是该条件下的长度最小的子数组。

//    int left = 0, right = 0;
//
//            while(right < s.size()){
//        window.add(s[right]);
//
//        while(window needs shrink){
//            window.remove(s[left]);
//            left++;
//        }
//    }
    // 滑动窗口
public int minSubArrayLen(int s, int[] nums) {
    int left = 0;

    int res = Integer.MAX_VALUE;

    int sum = 0;
    for (int right = 0; right < nums.length; right++) {
        sum+=nums[right];
        while ( sum >= s){
            res = Math.min(res,right-left+1);
            sum-=nums[left];
            left++;
        }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
}




}
