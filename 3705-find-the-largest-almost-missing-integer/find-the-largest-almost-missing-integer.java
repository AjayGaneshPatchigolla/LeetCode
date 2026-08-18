class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int val=nums[i];
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        int fe=nums[0],le=nums[n-1];
        if(k==n)
        {
            Arrays.sort(nums);
            return nums[n-1];
        }
        else if(k==1)
        {
            Arrays.sort(nums);
            for(int i=n-1;i>=0;i--)
            {
                int val=nums[i];
                if(hm.get(val)==1)
                return val;
            }
            return -1;
        }
        else
        {
            int ma=Math.max(fe,le),me=Math.min(fe,le);
            // System.out.println(ma+" "+me);
            if(hm.get(ma)==1)
            return ma;
            if(hm.get(me)==1)
            return me;
            return -1;
        }
    }
}