class Solution {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root , root.val);
        return ans;
    }

    public int dfs(TreeNode root , int pre){
        if(root == null) return 0;
        int sum = 0;
        //计算左右孩子最长路径
        int L = dfs(root.left , root.val);
        int R = dfs(root.right , root.val);
        sum = L+R;
        //当前节点最长路径更新ans
        ans = Math.max(sum , ans);
        if(root.val == pre){
            //等于父亲节点值时，返回max（左最长路径 ， 右最长路径）+ 1
            return Math.max(L,R)+1;
        }
        //不等于父亲节点时，返回0
        return 0;
    }
}

