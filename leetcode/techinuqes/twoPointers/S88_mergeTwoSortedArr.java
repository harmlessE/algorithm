package leetcode.techinuqes.twoPointers;

public class S88_mergeTwoSortedArr {
     void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针，一个判断nums1的元素，另一个判断nums2的元素
        int i = m - 1, j = n - 1;
        // nums1放置元素的索引，从m+n-1倒着开始放，这样不会影响nums1前面部分的元素
        int index = m + n - 1;
        // 如果两个数组都没有被遍历完
        while(i >= 0 && j >= 0){
            if (nums1[i] <= nums2[j]){
                nums1[index--] = nums2[j--];

            }else{
                nums1[index--] = nums1[i--];
            }
        }
        // 如果是nums2更长的话，把没遍历到的元素拼到最前面(nums1更长的话不用管)
        if(j>=0){
            for(int k = 0; k <= j; k++){
                nums1[k] = nums2[k];
            }
        }
    }
}
