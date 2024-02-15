package leetcode.techinuqes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15_threeSum {


    // 三数之和的重点是 排序+双指针  返回结果集的数据， 一定要记得去重！


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//排序，nums变成递增数组
        List<List<Integer>> res = new ArrayList<>();
        //k < nums.length - 2是为了保证后面还能存在两个数字
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;//若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if(k > 0 && nums[k] == nums[k - 1]) continue;//nums[k]值重复了，去重
            int i = k + 1, j = nums.length - 1;//定义左右指针
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);//左指针前进并去重
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);//右指针后退并去重
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);//左指针前进并去重
                    while(i < j && nums[j] == nums[--j]);//右指针后退并去重
                }
            }
        }
        return res;
    }
}
