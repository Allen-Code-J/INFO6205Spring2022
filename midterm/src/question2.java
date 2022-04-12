package midterm.src;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order,
 * and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 */
public class question2 {
    public static void main(String[] args) {

    }
}
//Question2

class Solution2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0; int newVal = 0;
        while(p1 != null || p2 != null || carry > 0){
            newVal = ((p1 == null)?0:p1.val) + ((p2 == null)?0:p2.val) + carry;
            carry = newVal / 10;
            newVal = newVal % 10;
            p.next = new ListNode(newVal);
            p1 = (p1 == null)?null:p1.next;
            p2 = (p2 == null)?null:p2.next;
            p = p.next;
        }
        return dummy.next;
    }
}
