class Solution {
    List<List<int[]>> adj;
    boolean[] flag;
    int[] values;
    int res=0;
    int maxTime;
    int n;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values=values;
        this.maxTime=maxTime;
        adj=new LinkedList();
        n=values.length;
        flag=new boolean[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList());
        for(int[] e:edges)
        {
            int a=e[0];
            int b=e[1];
            int c=e[2];
            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }
        flag[0]=true;
        dfs(0,values[0],0);
        return res;
    }
    public void dfs(int node,int curr,int time)
    {
        if(time>maxTime)
            return;
        if(node==0&&time<=maxTime)
            res=Math.max(res,curr);
        for(int[] tmp:adj.get(node))
        {
            if(flag[tmp[0]]){
                dfs(tmp[0],curr,time+tmp[1]);
            }
            else
            {
                flag[tmp[0]]=true;
                dfs(tmp[0],curr+values[tmp[0]],time+tmp[1]);
                flag[tmp[0]]=false;
            }

        }
    }
}
