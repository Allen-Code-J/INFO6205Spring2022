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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode cur = head; int ans = 0;
        while(cur != null){
            if(set.contains(cur.val)){
                if(cur.next == null || !set.contains(cur.next.val)){
                    ans++;
                }
            }
            cur = cur.next;
        }
        return ans;
    }
}