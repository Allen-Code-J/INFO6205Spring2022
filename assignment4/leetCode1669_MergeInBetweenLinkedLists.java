/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        int count = b - a + 2;
        // 找到list1中第a个节点的前一个节点
        while ((a - 1) > 0) {
            a--;
            cur = cur.next;
        }
        ListNode left = cur;
        // 找到list1中第b个节点的后一个节点
        while (count > 0) {
            cur = cur.next;
            count--;
        }
        ListNode right = cur;
        // 将list1中第a个节点的前一个节点指向list2的头节点
        left.next = list2;
        // 找到list2的尾节点
        while(list2.next != null) {
            list2 = list2.next;
        }
        // 将list2的尾节点指向list1中第b个节点的后一个节点
        list2.next = right;
        return list1;
    }
}

