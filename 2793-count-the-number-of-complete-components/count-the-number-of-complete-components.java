class Solution {
    static ArrayList<Integer> a;
    static void dfs(int n,int v[],ArrayList<ArrayList<Integer>> adj)
    {
        v[n]=1;
        a.add(n);
        for(int i: adj.get(n))
        {
            if(v[i]==0)
            dfs(i,v,adj);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        a=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Integer>());
        for(int i[]: edges)
        {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int v[]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(v[i]==0)
            {
                dfs(i,v,adj);
                int c=0;
                int p=a.size();
                for(int j: a)
                {
                    c+=adj.get(j).size();
                }
                if(c/2==p*(p-1)/2)
                ans+=1;
                a=new ArrayList<>();
            }
        }
        return ans;
    }
}