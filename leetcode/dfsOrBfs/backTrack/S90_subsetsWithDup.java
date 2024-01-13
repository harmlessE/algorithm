package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S90_subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }
    void dfs(int[] nums, int start){
        // i starts from start index 所以我们不能再往前选 每次每个数字只能用一次 选择了2 就不能再用1 2
        // 排列是不能重复选 组合是不能选之前的数字
        // 排列通过visited数组的更新动态实现 防止111的出现 组合通过每次start index + 1 来限制必须往后选 用过的就不再用
        // 就能保证每次产生的结果都是一个新的组合
        // [1,2,2]
        // 对于可能包含重复元素的集合的子集 我们要判断 选择前者还是后者
        for (int i = start; i < nums.length; i++) {
            // 本轮可以选择的数字 start...n 选到当前i时判断下 i如果和i-1相同， 如果i-1还能选 就跳过i 这样只保留选择前一个的情况
            if( i >= 1 && nums[i] == nums[i-1] && i-1 >= start)
                continue;
            ans.add(nums[i]);
            dfs(nums,i+1);
            ans.removeLast();
        }
        res.add(new ArrayList<>(ans));

    }

}
