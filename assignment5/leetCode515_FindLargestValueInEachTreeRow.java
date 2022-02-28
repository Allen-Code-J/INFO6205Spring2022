/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){

                TreeNode tmp = que.poll();
                if(tmp.val > max) max = tmp.val;
                if(tmp.left != null) que.add(tmp.left);
                if(tmp.right != null) que.add(tmp.right);
            }
            result.add(max);
        }
        return result;

    }
}