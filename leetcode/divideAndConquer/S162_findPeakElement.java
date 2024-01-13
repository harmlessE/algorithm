package leetcode.divideAndConquer;

public class S162_findPeakElement {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};

        System.out.println(findPeakElement(test));
    }

    public static int findPeakElement(int[] nums) {
        // 因为要比较 nums[mid+1] 所以这里不能到最后一个元素 如果最后一个元素比倒二大，那么就默认是peak
        int left = 0, right = nums.length - 1;
           // [0,1,2,3]  length = 4 ; left = 0, right = 3,  inital mid = 1
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 数组的左右两端都是-1 ， 只要往递增的方向去推 一定能找到peak
            // 当前数更大 往左边找
            if(nums[mid] > nums[mid+1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
