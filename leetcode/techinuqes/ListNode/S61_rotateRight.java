package leetcode.techinuqes.ListNode;

import leetcode.ListNode;

import java.util.List;

public class S61_rotateRight {

    int count=0;
    ListNode newHead;
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null)
            return null;



        ListNode cur = head;
        int len = 0;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        if(k%len==0||len==k)
            return head;
        dfs(head,k%len);
        cur = newHead;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
    private ListNode dfs(ListNode head, int n) {
        if(head == null){
            return null;
        }
        head.next = dfs(head.next,n);
        count++;
        if(count == n){
            newHead = head;
            return null;
        }
        return head;
    }


}
