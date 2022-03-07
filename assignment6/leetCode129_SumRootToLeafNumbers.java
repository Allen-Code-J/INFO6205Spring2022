class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    //number是从根节点到当前节点路径表示的数
    public void dfs(TreeNode root, int number){
        if(root == null) return;
        number = number * 10 + root.val;
        //遍历叶子结点
        if(root.left == null && root.right == null) res = res + number;
        //递归左子树
        if(root.left != null) dfs(root.left, number);
        //递归右子树
        if(root.right != null) dfs(root.right, number);
    }
}