package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.*;

public class S508_findFrequentTreeSum_lastdfs {

    int sum = 0;
    HashMap<Integer,Integer> res = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfsGetSum(root);
        List<Integer> ret = new ArrayList<>();
        int maxTimes = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            maxTimes = Math.max(maxTimes,entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if(entry.getValue() == maxTimes)
                ret.add(entry.getKey());
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
    // 必须 后序
    public int dfsGetSum(TreeNode root){

        int sum = root.val + (root.left == null ? 0 : dfsGetSum(root.left)) +
                (root.right == null ? 0 : dfsGetSum(root.right));
        res.put(sum,res.getOrDefault(sum,1) + 1);

        return sum;
    }




}
