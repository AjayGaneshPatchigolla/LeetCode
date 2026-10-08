class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int bf=0;
        boolean flag=false;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            bf+=1;
            else
            bf-=1;
            if(flag && bf!=0)
            sb.append(c);
            if(bf==1)
            flag=true;
            if(bf==0)
            flag=false;
        }
        return sb.toString();
    }
}