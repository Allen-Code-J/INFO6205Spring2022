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
    public int pairSum(ListNode head) {
        List<Integer> change= new ArrayList<>();
        while(head != null){
            change.add(head.val);
            head=head.next;
        }
        int left = 0;
        int right = change.size() - 1;
        int sum = 0; int maxSum = Integer.MIN_VALUE;
        while(left < right){
            sum = change.get(left) + change.get(right);
            if(sum > maxSum){
                maxSum  = sum;
            }
            left++; right--;
        }
        return maxSum;
    }
}