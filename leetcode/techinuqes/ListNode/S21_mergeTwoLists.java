package leetcode.techinuqes.ListNode;

import leetcode.ListNode;

public class S21_mergeTwoLists {




    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode cur = new ListNode(-1);
        ListNode pre = cur;

        while (list1 !=null || list2 != null){
            if(list1 == null){
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            else if(list2 == null){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                if(list1.val > list2.val){
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                }else {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
            }
            cur = cur.next;
        }
        return pre.next;
    }




}
