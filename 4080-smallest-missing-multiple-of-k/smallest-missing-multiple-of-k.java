class Solution {
    public int missingMultiple(int[] nums, int k) {
        int f[]=new int[101];
        for(int i: nums)
        f[i]=1;
        int tmp=k;
        while(tmp<101)
        {
            if(f[tmp]==0)
            return tmp;
            tmp+=k;
        }
        return tmp;
    }
}