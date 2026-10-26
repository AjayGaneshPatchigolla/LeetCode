class Solution {
    public int dfs(int n,int vis[],ArrayList<ArrayList<Integer>> adj)
    {
        vis[n]=1;
        int ans=1;
        for(int i: adj.get(n))
        {
            if(vis[i]==0)
            ans+=dfs(i,vis,adj);
        }
        return ans;
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i[]: edges)
        {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        ArrayList<Integer> tmp=new ArrayList<>();
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            tmp.add(dfs(i,vis,adj));
        }
        Collections.sort(tmp);
        int len=tmp.size();
        long comp[]=new long[len];
        long ps=0;
        for(int i=0;i<len;i++)
        {
            ps+=tmp.get(i);
            comp[i]=ps;
        }
        long ans=0;
        for(int i=0;i<len-1;i++)
        {
            long cmp_len=(i==0)?comp[i]:(comp[i]-comp[i-1]);
            ans+=(cmp_len*(comp[len-1]-comp[i]));
        }
        return ans;
    }
}