class Solution {
    static class Pair
    {
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int closedIsland(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int vis[][]=new int[r][c];
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        int dx[]={0,-1,0,1};
        int dy[]={1,0,-1,0};
        for(int i=1;i<r-1;i++)
        {
            for(int j=1;j<c-1;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==0)
                {
                    q.add(new Pair(i,j));
                    boolean flag=true;
                    while(!q.isEmpty())
                    {
                        Pair tmp=q.poll();
                        if(tmp.x==0 || tmp.x==(r-1) || tmp.y==0 || tmp.y==(c-1))
                        flag=false;
                        for(int k=0;k<4;k++)
                        {
                            int nx=tmp.x+dx[k];
                            int ny=tmp.y+dy[k];
                            if(nx>=0 && nx<r && ny>=0 && ny<c && vis[nx][ny]==0 && grid[nx][ny]==0){
                                vis[nx][ny]=1;
                            q.add(new Pair(nx,ny));
                            }
                        }
                    }
                    if(flag)
                        ans+=1;
                }
            }
        }
        return ans;
    }
}