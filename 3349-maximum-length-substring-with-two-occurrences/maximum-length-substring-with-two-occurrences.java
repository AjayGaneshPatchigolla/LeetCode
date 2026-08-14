class Solution {
    public int maximumLengthSubstring(String s) {
        int f[]=new int[26];
        int n=s.length(),j=0,ans=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            f[c-'a']+=1;
            if(f[c-'a']>2)
            {
                while(j<i && s.charAt(j)!=c){
                    f[s.charAt(j)-'a']-=1;
                    j+=1;
                }
                f[s.charAt(j)-'a']-=1;
                j+=1;
            }
            ans=Math.max(ans,i-j+1);           
        }
        return ans;
    }
}