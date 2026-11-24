class Solution {
    int gcd(int a,int b)
    {
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    int lcm(int a,int b)
    {
        for(int i=Math.max(a,b);i<=a*b;i++)
        {
            if(i%a==0 && i%b==0)
            return i;
        }
        return a*b;
    }
    public int maxLength(int[] nums) {
        int ans=0,n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            int lc=lcm(nums[i],nums[i+1]),gc=gcd(nums[i],nums[i+1]),prod=nums[i]*nums[i+1];
            if(lc*gc==prod)
            ans=Math.max(ans,2);
            for(int j=i+2;j<n;j++)
            {
                lc=lcm(lc,nums[j]);
                gc=gcd(gc,nums[j]);
                prod*=nums[j];
                if(lc*gc==prod)
                ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}