package leetcode.dfsOrBfs;

import leetcode.ListNode;

import java.util.List;

public class S147_insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        return dfs(head);
    }

    public ListNode dfs(ListNode head){

        if(head==null || head.next == null)
            return head;

        ListNode next = dfs(head.next);


        // 要插入的情况
        // 要把cur放在现在的head后面
        ListNode cur = head;
        // 找到插入的点
        while (head.next!=null && head.val > head.next.val){
            head=head.next;
            cur.next = head.next;
            head.next = cur;
        }
        // 不需要插入的情况
        if(head.next!=null  && head.val <= head.next.val){
            next = head;
        }
        return next;
    }



}
