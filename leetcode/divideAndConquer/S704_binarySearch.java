package leetcode.divideAndConquer;

public class S704_binarySearch {

    public int search(int[] nums, int target) {


        int l = 0;
        int r = nums.length;
// 左闭右闭写法 [0,1,2,3]  length = 4 ; left = 0, right = 3,  inital mid = 1. 左闭右闭！
        while(l<r){
            int mid = (l+r) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(l>=nums.length)
            return -1;

        return nums[l] == target ? l : -1;

    }


}
