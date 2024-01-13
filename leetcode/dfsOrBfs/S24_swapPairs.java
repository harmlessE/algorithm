package leetcode.dfsOrBfs;

import leetcode.ListNode;

public class S24_swapPairs {

    int nodeCount = 0;
    public ListNode swapPairs(ListNode head) {
        return dfs(head);
    }

    public ListNode dfs(ListNode head){
        nodeCount += 1;
        if(head==null || head.next == null)
            return head;
        ListNode next = dfs(head.next);
        nodeCount -= 1;
        // count = 3
        if(nodeCount % 2 == 1){
            head.next = next.next;
            next.next = head;
            return next;
        }
        head.next = next;
        return head;
    }

}
