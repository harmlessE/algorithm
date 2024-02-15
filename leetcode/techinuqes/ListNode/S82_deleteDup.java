package leetcode.techinuqes.ListNode;

import leetcode.ListNode;

public class S82_deleteDup {



    public ListNode deleteDuplicates(ListNode head) {

        ListNode pre=head, cur = head.next;

        while (cur !=null){
            if(pre.val==cur.val){
                while (cur !=null && cur.val==pre.val){
                    cur=cur.next;
                }
                pre.next=cur;
                pre = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

}
