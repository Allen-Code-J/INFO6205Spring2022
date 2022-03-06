class Solution {
    List<List<Integer>> res;
    HashMap<TreeNode, Integer> map;
    int min=0, max=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        res = new ArrayList();
        if(root == null) return res;
        map = new HashMap();
        dfs(root, 0);
        //初始化所有列
        for(int i=0; i<(max-min+1); i++){
            res.add(new ArrayList());
        }
        Queue<TreeNode> queue = new LinkedList();
        PriorityQueue<TreeNode> queue1 = new PriorityQueue<>((a, b)->a.val-b.val);

        queue.offer(root);
        while(!queue.isEmpty()){
            queue1.addAll(queue);
            queue.clear();
            while(queue1.size() > 0){
                TreeNode node = queue1.poll();
                List<Integer> list = res.get(map.get(node)-min);
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
    private void dfs(TreeNode root, int index){
        if(root == null) return;
        map.put(root, index);
        min = Math.min(index, min);
        max = Math.max(index, max);
        dfs(root.left, index-1);
        dfs(root.right, index+1);
    }
}

