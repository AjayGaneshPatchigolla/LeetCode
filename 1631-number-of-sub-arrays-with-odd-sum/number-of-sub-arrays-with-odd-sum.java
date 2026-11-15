class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=(int)Math.pow(10,9)+7;
        int f[]=new int[2];
        int ps=0,ans=0;
        // int fg=1;
        for(int i: arr)
        {
            ps+=i;
            if(ps%2==1)ans+=1;
            if(ps%2==0)
            {
                ans=(ans%mod+f[1]%mod)%mod;
            }
            else
            ans=(ans%mod+f[0]%mod)%mod;
            f[ps%2]+=1;
        }
        return ans;
    }
}