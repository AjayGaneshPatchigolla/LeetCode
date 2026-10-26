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
    public int findMaxFish(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int vis[][]=new int[r][c];
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        int dx[]={0,-1,0,1};
        int dy[]={1,0,-1,0};
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(vis[i][j]==0 && grid[i][j]>0)
                {
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                    int sum=0;
                    while(!q.isEmpty())
                    {
                        Pair tmp=q.poll();
                        sum+=grid[tmp.x][tmp.y];
                        for(int p=0;p<4;p++)
                        {
                            int nx=tmp.x+dx[p];
                            int ny=tmp.y+dy[p];
                            if(nx>=0 && nx<r && ny>=0 && ny<c && vis[nx][ny]==0 && grid[nx][ny]>0){
                                vis[nx][ny]=1;
                            q.add(new Pair(nx,ny));
                            }
                        }
                    }
                    ans=Math.max(ans,sum);
                }
            }
        }
        return ans;
    }
}