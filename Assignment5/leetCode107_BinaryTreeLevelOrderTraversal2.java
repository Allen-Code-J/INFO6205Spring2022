class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tmpResult = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return tmpResult;
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            int size = que.size();
            for(int i = 0; i < size; i++){

                TreeNode tmpNode = que.poll();
                levelResult.add(tmpNode.val);
                if(tmpNode.left != null) que.offer(tmpNode.left);
                if(tmpNode.right != null) que.offer(tmpNode.right);
            }
            tmpResult.add(levelResult);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = tmpResult.size() - 1; i >= 0; i--){
            result.add(tmpResult.get(i));
        }
        return result;
    }
}