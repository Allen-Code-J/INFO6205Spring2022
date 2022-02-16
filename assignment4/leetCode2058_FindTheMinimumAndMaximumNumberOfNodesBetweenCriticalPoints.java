class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> change = new ArrayList<>();
        while (head != null) {
            change.add(head.val);
            head = head.next;
        }
        List<Integer> m = new ArrayList<>();
        for (int i = 1; i < change.size() - 1; i++) {
            if (change.get(i - 1) > change.get(i) && change.get(i) < change.get(i + 1)) {
                m.add(i);
            } else if (change.get(i - 1) < change.get(i) && change.get(i) > change.get(i + 1)) {
                m.add(i);
            }
        }
        int m_size = m.size();
        if (m_size < 2) {
            return new int[]{-1, -1};
        }
        int max_size = m.get(m.size() - 1) - m.get(0);
        int min_size = Integer.MAX_VALUE;
        for (int j = 1; j < m_size; j++) {
            min_size = Math.min(min_size, m.get(j) - m.get(j - 1));

        }
        return new int[]{min_size, max_size};
    }
}