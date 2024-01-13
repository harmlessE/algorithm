package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S78_subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    boolean[] visited;

    public List<List<Integer>> subsets(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums,0);
        return res;
    }

    void dfs(int[] nums, int start){
        // i starts from start index 所以我们不能再往前选 每次每个数字只能用一次 选择了2 就不能再用1 2
        // 排列是不能重复选 组合是不能选之前的数字
        // 排列通过visited数组的更新动态实现 防止111的出现 组合通过每次start index + 1 来限制必须往后选 用过的就不再用
        // 就能保证每次产生的结果都是一个新的组合
        for (int i = start; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums,i+1);
            ans.removeLast();
        }
        res.add(new ArrayList<>(ans));

    }

}
