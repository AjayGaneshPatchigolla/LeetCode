class Solution {
    static List<String> res;
    private void rec(int ind,String tmp,int oc,int cc,int n)
    {
        if(ind>=2*n)
        {
            res.add(tmp);
            return;
        }
        if(oc<n)
        rec(ind+1,tmp+"(",oc+1,cc,n);
        if(cc<oc)
        rec(ind+1,tmp+")",oc,cc+1,n);
    }
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        rec(0,"",0,0,n);
        return res;
    }
}