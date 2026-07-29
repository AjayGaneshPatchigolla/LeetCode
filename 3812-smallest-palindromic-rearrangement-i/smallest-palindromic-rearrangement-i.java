class Solution {
    public String smallestPalindrome(String s) {
        int f[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            f[c-'a']+=1;
        }
        StringBuilder ans=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++)
        {
            if(f[i]>0)
            {
                char c=(char)(97+i);
                int cnt=f[i];
                ans.append((c+"").repeat(cnt/2));
                if(f[i]%2==1)
                {
                    sb.append(c);
                }
            }
        }
        StringBuilder bp=new StringBuilder(ans).reverse();
        ans.append(sb);
        ans.append(bp);
        return ans.toString();
    }
}