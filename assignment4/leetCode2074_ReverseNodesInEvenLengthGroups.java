class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            ++count;
            ListNode tryIt = cur;
            int length = 0;
            while (length < count && tryIt != null) {
                tryIt = tryIt.next;
                ++length;
            }
            if (length % 2 == 0) {
                for (int i = 0; i < length - 1; ++i) {
                    ListNode removed = cur.next;
                    cur.next = cur.next.next;
                    removed.next = pre.next;
                    pre.next = removed;
                }
                pre = cur;
                cur = cur.next;
            } else {
                for (int i = 0; i < length; ++i) {
                    cur = cur.next;
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }
}