class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        //End condation
        if(root == null) return 0;
        //single layer logic
        int num = rootSum(root, targetSum);
        num = num + pathSum(root.left, targetSum);
        num = num + pathSum(root.right, targetSum);
        return num;
    }

    public int rootSum(TreeNode root, int targetSum){
        int rootPathNum = 0;
        //End condition
        if(root == null) return 0;
        //Single layer logic
        if(root.val == targetSum) rootPathNum++;
        //Recursion
        rootPathNum = rootSum(root.left, targetSum - root.val) + rootPathNum;
        rootPathNum = rootSum(root.right, targetSum - root.val) + rootPathNum;
        return rootPathNum;


    }
}