package leetcode.dfsOrBfs;

import leetcode.ListNode;
import leetcode.Node;
import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M0403_listOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        if(tree == null)
            return new ListNode[]{};
        while (!queue.isEmpty()){
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;

            Queue<TreeNode> next = new LinkedList<>();

            for(TreeNode currentLevelNode:queue){
                head.next = new ListNode(currentLevelNode.val);
                head = head.next;
                if(!(currentLevelNode.left == null))
                    next.offer(currentLevelNode.left);
                if(!(currentLevelNode.right == null))
                    next.offer(currentLevelNode.right);
            }
            res.add(dummy.next);
            queue = next;
        }
        return res.toArray(new ListNode[]{});
    }


}
