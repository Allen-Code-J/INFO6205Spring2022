class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) return 0;
        que.offer(root);
        int max = Integer.MIN_VALUE;
        while (!que.isEmpty()) {
            int size = que.size();
            max = Math.max(max, que.getLast().val - que.getFirst().val + 1);
            for (int i = 0; i < size; i++) {
                TreeNode tmp = que.poll();
                if (tmp.left != null) {
                    tmp.left.val = tmp.val * 2 + 1;
                    que.offer(tmp.left);
                }
                if (tmp.right != null) {
                    tmp.right.val = tmp.val * 2 + 2;
                    que.offer(tmp.right);
                }
            }
        }
        return max;
    }
}