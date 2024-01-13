package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null)
            return res;
        while (!queue.isEmpty()){
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> values = new LinkedList<>();

            for(TreeNode currentLevelNode:queue){
                values.add(currentLevelNode.val);
                if(!(currentLevelNode.left == null))
                    next.offer(currentLevelNode.left);
                if(!(currentLevelNode.right == null))
                    next.offer(currentLevelNode.right);
            }
            res.add(values);
            queue = next;
        }

        return res;
    }

}
