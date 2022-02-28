class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = level(root, list);
            res.add(list);
        }
        return res;
    }

    public TreeNode level(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = level(root.left, list);
        root.right = level(root.right, list);
        return root;
    }
}
}
