package leetcode.techinuqes.ListNode;

import leetcode.ListNode;

import java.util.List;

public class S86_partition {



    ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode head1 = dummy1;
        ListNode head2 = dummy2;

        ListNode cur = head;


        while (cur!=null){
            ListNode next = cur.next;
            if(cur.val < x){
                head2.next = cur;
                head2 = head2.next;
            }else {
                head1.next = cur;
                head1 = head1.next;
            }
            cur.next = null;
            cur = next;
        }

        head2 = dummy2.next;

        while (head2!=null && head2.next!=null){
            head2 = head2.next;
        }

        assert head2 != null;
        head2.next = dummy1.next;

        return dummy2.next;


    }







    // 不能用下面的这个方法！！！ 因为要保证两个分区的相对顺序，只能通过遍历重建两条链表的方式
    public ListNode partition2(ListNode head, int x) {

        ListNode cur,next;

        cur = head;
        while (cur!=null && cur.val!=x){
            cur = cur.next;
        }
        ListNode pre = cur;
        while (cur!=null){
            // delete the node smaller than target value
            if(cur.val < x){
                head = addIntoList(head,cur.val);
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
                // add the value to the previous 只能用头插法 比第一个元素小 就插在第一个元素的前面，反之再往后找
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode addIntoList(ListNode head,int value){
        ListNode pre,cur,dummy;
        dummy = new ListNode(-1);
        dummy.next = head;
        pre = dummy;
        cur = head;
        while (cur.val < value){
            pre = cur;
            cur = cur.next;
        }
        pre.next = new ListNode(value);
        pre.next.next=cur;
        return dummy.next;
    }




}
