class Solution {
    int gcd(int a,int b)
    {
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int l=nums[0],h=nums[0],n=nums.length;
        for(int i=0;i<n;i++)
        {
            l=Math.min(l,nums[i]);
            h=Math.max(h,nums[i]);
        }
        return gcd(l,h);
    }
}