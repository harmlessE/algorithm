package leetcode.dfsOrBfs;

import leetcode.Node;
import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S429_nLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null)
            return res;
        while (!queue.isEmpty()){
            Queue<Node> next = new LinkedList<>();
            List<Integer> values = new LinkedList<>();

            for(Node currentLevelNode:queue){
                values.add(currentLevelNode.val);
                currentLevelNode.children.forEach( element -> {
                    if(element!=null)
                        next.add(element);
                });

            }
            res.add(values);
            queue = next;
        }

        return res;
    }
}
