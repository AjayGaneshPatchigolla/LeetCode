class Solution {
    public boolean canAliceWin(int n) {
        char c='A';
        for(int i=10;i>=1;i--)
        {
            if(n<i)
            break;
            n-=i;
            if(c=='A')
            c='c';
            else 
            c='A';
        }
        return c=='c';
    }
}