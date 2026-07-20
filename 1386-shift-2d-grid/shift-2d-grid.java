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
    Pair getPos(int val,int y)
    {
        int r=-1,c=-1;
        if(val%y==0)
        r=val/y-1;
        else
        r=val/y;
        c=(val-1)%y;
        return new Pair(r,c);
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r=grid.length,c=grid[0].length;
        List<List<Integer>> ans=new ArrayList<>();
        k%=(r*c);
        List<Integer> tmp=new ArrayList<>();
        int cnt=0;
        for(int i=r*c-k+1;i<=r*c;i++)
        {
            Pair p=getPos(i,c);
            tmp.add(grid[p.x][p.y]);
            cnt+=1;
            if(cnt==c)
            {
                cnt=0;
                ans.add(tmp);
                tmp=new ArrayList<>();
            }
        }
        for(int i=1;i<=r*c-k;i++)
        {
            Pair p=getPos(i,c);
            tmp.add(grid[p.x][p.y]);
            cnt+=1;
            if(cnt==c)
            {
                cnt=0;
                ans.add(tmp);
                tmp=new ArrayList<>();
            }
        }
        // ans.add(tmp);
        return ans;
    }
}