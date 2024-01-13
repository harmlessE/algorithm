package leetcode.dfsOrBfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S1376_numOfMinutes {
    int[] informTime;
    HashMap<Integer,List<Integer>> map;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        this.informTime = informTime;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(manager[i] >= 0){
                map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }
        }
        return dfs(headID);
    }
    public int dfs(int root){


        int inforTime = 0;


        List<Integer> employees = map.get(root);
        if(employees == null)
            employees=new ArrayList<>();

        for(int employee :  employees){
            inforTime = Math.max(dfs(employee),inforTime);
        }
        //子树中通知下属的最大时间  + 我通知我的子树的时间
        return inforTime + informTime[root];
    }



}
