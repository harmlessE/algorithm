package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S46_permutations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums);
        return res;
    }
    void dfs(int[] nums){
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                break;
            set.add(nums[i]);
            if(visited[i])
                continue;
            visited[i] = true;
            ans.add(nums[i]);
            dfs(nums);
            ans.removeLast();
            visited[i] = false;
        }
    }

}
