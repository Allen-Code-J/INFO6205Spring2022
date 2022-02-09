class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nums.add(cur.val);
            cur = cur.next;
        }
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            if (!nums.get(l).equals(nums.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}