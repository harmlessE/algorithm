package leetcode.techinuqes.ListNode;
import leetcode.ListNode;

public class S92_reverseListNodeTwo {

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
    // 头插法！！！！

    // 此题有两个办法，一个是 掐头去尾 保留上下文 再使用S206的尾插法

    // 第二个办法是 使用头插法，如下，定义 pre,cur,next
    // next = cur.next;
    // cur.next = next.next;
    // next.next = pre.next;
    // pre.next = next;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }



}
