class Solution {
    static class Pair
    {
        int u,v,d;
        Pair(int u,int v,int d)
        {
            this.u=u;
            this.v=v;
            this.d=d;
        }
    }
    private int distance(int x1,int y1,int x2,int y2)
    {
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    private class DisjointSet
    {
        int size[];
        int parent[];
        public DisjointSet(int n)
        {
            size=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++)
            {
                size[i]=1;
                parent[i]=i;
            }
        }

        int findParent(int n)
        {
            if(n==parent[n])
            return n;
            return parent[n]=findParent(parent[n]);
        }

        boolean union(int u,int v)
        {
            int upu=findParent(u);
            int upv=findParent(v);
            if(upu==upv)
            return false;
            if(size[upu]>=size[upv])
            {
                size[upu]+=size[upv];
                parent[upv]=upu;
            }
            else
            {
                size[upv]+=size[upu];
                parent[upu]=upv;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int res=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.d-b.d);
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(i!=j)
                {
                    int x1=points[i][0],y1=points[i][1],x2=points[j][0],y2=points[j][1];
                    int distanceBetweenPoints=distance(x1,y1,x2,y2);
                    pq.add(new Pair(i,j,distanceBetweenPoints));
                }
            }
        }

        DisjointSet ds=new DisjointSet(n);
        while(!pq.isEmpty())
        {
            Pair tmp=pq.poll();
            if(ds.union(tmp.u,tmp.v))
            {
                res+=tmp.d;
            }
        }
        return res;
    }
}