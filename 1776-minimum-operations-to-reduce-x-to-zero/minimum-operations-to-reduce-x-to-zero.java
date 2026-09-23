class Solution {
    public int minOperations(int[] nums, int x) {
        int s=0,ps=0,n=nums.length,ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i: nums)
        s+=i;
        for(int i=0;i<nums.length;i++)
        {
            ps+=nums[i];
            hm.put(ps,i);
            if(ps==(s-x))
            ans=Math.min(ans,n-i-1);
            if(hm.containsKey(ps-(s-x)))
            {
                int ind=hm.get(ps-(s-x));
                ans=Math.min(ans,ind+1+(n-1-i));
            }
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}