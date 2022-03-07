class Solution{
    /**
     * 1.确定递归的参数和返回值 参数就是root，返回值是节点个数，所以返回int
     * 2.确定终止条件         if(root == null) {return 0;}
     * 3.找到递归关系
     */
    public int countNodes(TreeNode root){
        if(root==null)return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int totalNum = leftNum+rightNum+1;
        return totalNum;
    }
}