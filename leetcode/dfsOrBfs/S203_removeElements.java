package leetcode.dfsOrBfs;

import leetcode.ListNode;

public class S203_removeElements {

    public ListNode removeElements(ListNode head, int val) {
        return dfs(head,val);

    }
    public ListNode dfs(ListNode node, int val){
        if(node == null)
            return null;
        node.next = dfs(node.next,val);
        if(node.val == val){
            return node.next;
        }
        return node;
    }


}
