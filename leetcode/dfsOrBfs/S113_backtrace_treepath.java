package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class S113_backtrace_treepath {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;

        dfs(root,targetSum);

        return res;
    }
    public void dfs(TreeNode root, int targetSum){
    if(root == null)
        return;
    sum += root.val;
    ans.add(root.val);
    if(root.left==null && root.right==null && sum == targetSum)
        res.add(new ArrayList<>(ans));
    dfs(root.left,targetSum);
    dfs(root.right,targetSum);
    sum -= root.val;
    ans.removeLast();
    }




}
