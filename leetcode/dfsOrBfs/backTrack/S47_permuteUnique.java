package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S47_permuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }
    void dfs(int[] nums){
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i])
                continue;
            // [1,1,2] 如果此元素和前一个元素一样，并且选了前一个元素，就跳过 此元素不选
            if(i > 0 && nums[i] == nums[i - 1] && visited[i-1])
                continue;
            visited[i] = true;
            ans.add(nums[i]);
            dfs(nums);
            ans.removeLast();
            visited[i] = false;
        }
    }

}
