class Solution {
    public int maxSubarrayLength(int[] nums, int k) { 
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length,j=0,ans=0;
        for(int i=0;i<n;i++)
        {
            int val=nums[i];
            if(!hm.containsKey(val))
            {
                hm.put(val,1);
            }
            else
            {
                if(hm.get(val)<k)
                hm.put(val,hm.get(val)+1);
                else
                {
                    while(j<i && nums[j]!=val)
                    {
                        int tv=nums[j];
                        hm.put(tv,hm.get(tv)-1);
                        j+=1;
                    }
                    j+=1;
                }
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}