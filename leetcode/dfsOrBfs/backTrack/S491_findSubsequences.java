package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class S491_findSubsequences {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums ) {
            dfs(nums,0);
            return res;
        }
        void dfs(int[] nums, int start){
            if(ans.size() >=2)
                res.add(new ArrayList<>(ans));
            HashSet<Integer> set = new HashSet();
            for (int i = start; i < nums.length; i++) {
                int before = ans.isEmpty() ? Integer.MIN_VALUE : ans.getLast();
                if( nums[i] >= before ){
                    if(set.contains(nums[i]))
                        continue;
                    set.add(nums[i]);
                    ans.add(nums[i]);
                    dfs(nums,i+1);
                    ans.removeLast();
                }else{
                    continue;
                }
            }
        }
    }
}
