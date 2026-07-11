class AllOne {
    static class Pair
    {
        String k;
        int v;
        Pair(String k,int v)
        {
            this.k=k;
            this.v=v;
        }
    }
    HashMap<String,Pair> hm;
    PriorityQueue<Pair> mah;
    PriorityQueue<Pair> mih;
    public AllOne() {
        hm=new HashMap<>();
        mah=new PriorityQueue<>((a,b) -> b.v-a.v);
        mih=new PriorityQueue<>((a,b) -> a.v-b.v);
    }
    
    public void inc(String key) {
        if(!hm.containsKey(key))
        {
            Pair np=new Pair(key,1);
            hm.put(key,np);
            mah.add(np);
            mih.add(np);
        }
        else
        {
            Pair tp=hm.get(key);
            mah.remove(tp);
            mih.remove(tp);
            tp.v+=1;
            mah.add(tp);
            mih.add(tp);
        }
    }
    
    public void dec(String key) {
        Pair tp=hm.get(key);
        mah.remove(tp);
        mih.remove(tp);
        tp.v-=1;
        if(tp.v==0)
        {
            hm.remove(key);
        }
        else{
        mah.add(tp);
        mih.add(tp);
        }
    }
    
    public String getMaxKey() {
        if(mah.size()==0)
        return "";
        return mah.peek().k;
    }
    
    public String getMinKey() {
        if(mih.size()==0)
        return "";
        return mih.peek().k;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */