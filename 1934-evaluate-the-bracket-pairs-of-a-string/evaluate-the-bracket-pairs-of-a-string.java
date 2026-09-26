class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> knowledgeBase=new HashMap<>();
        int l=s.length();
        for(List<String> i: knowledge)
        {
            knowledgeBase.put(i.get(0),i.get(1));
        }
        StringBuilder res=new StringBuilder();
        String tmp="";
        int cnt=-1;
        for(int i=0;i<l;i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            {
                cnt=0;
            }
            else if(c==')')
            {
                res.append(knowledgeBase.getOrDefault(tmp,"?"));
                tmp="";
                cnt=-1;
            }
            else
            {
                if(cnt==-1)
                res.append(c);
                else
                tmp+=c;
            }
        }
        return res.toString();
    }
}