class Solution {
    public int smallestIndex(int[] nums) {
        int ind=0;
        for(int i: nums)
        {
            int cnt=0,tmp=i;
            while(tmp>0)
            {
                cnt+=(tmp%10);
                tmp/=10;
            }
            // System.out.println
            if(cnt==ind)
            return ind;
            ind+=1;
        }
        return -1;
    }
}