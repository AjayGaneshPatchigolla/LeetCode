class Solution {
    public String[] createGrid(int m, int n) {
        String ans[]=new String[m];
        StringBuilder tmp=new StringBuilder();
        for(int i=0;i<n;i++)
        tmp.append(".");
        ans[0]=tmp.toString();
        tmp=new StringBuilder();
        for(int i=0;i<n-1;i++)
        tmp.append("#");
        tmp.append(".");
        for(int i=1;i<m;i++)
        ans[i]=tmp.toString();
        return ans;
    }
}