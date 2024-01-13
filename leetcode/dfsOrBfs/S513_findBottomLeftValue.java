package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S513_findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int target = 0;
        while (!queue.isEmpty()){
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> values = new LinkedList<>();

            for(TreeNode currentLevelNode:queue){
                if(!(currentLevelNode.left == null))
                    next.offer(currentLevelNode.left);
                if(!(currentLevelNode.right == null))
                    next.offer(currentLevelNode.right);
            }
            target = queue.peek().val;
            queue = next;
        }
        return target;
    }



}
