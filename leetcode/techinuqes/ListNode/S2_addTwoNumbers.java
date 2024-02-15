package leetcode.techinuqes.ListNode;

import leetcode.ListNode;

import java.util.List;

public class S2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode cur = new ListNode(-1);
        ListNode pre = cur;


        while (l1 !=null || l2!=null){
            int sum = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val )+
                    carry;

            carry = sum /10;

            sum = sum % 10;

            cur.next = new ListNode(sum);

            cur = cur.next;

            if(l1 != null)
                l1=l1.next;
            if(l2 != null)
                l2=l2.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
