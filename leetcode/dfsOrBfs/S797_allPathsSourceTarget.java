package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S797_allPathsSourceTarget {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> ans = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0,graph);
        return res;
    }
    public void dfs (int i,int[][] graph){
        ans.add(i);
        for(int j:graph[i]){
            dfs(j,graph);
        }
        if(i == graph.length-1)
            res.add(new ArrayList<>(ans));
        ans.removeLast();
    }




}
