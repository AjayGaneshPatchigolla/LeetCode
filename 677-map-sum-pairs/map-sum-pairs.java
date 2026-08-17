class MapSum {
    static class Node
    {
        Node child[];
        int s;
        boolean end;
        public Node()
        {
            child=new Node[26];
            s=0;
            end=false;
        }
    }
    private Node root;

    private int rec(Node root)
    {
        if(root==null)return 0;
        int ans=0;
        Node tmp=root;
        for(char c='a';c<='z';c++)
        {
            ans+=rec(tmp.child[c-'a']);
        }
        ans+=root.s;
        return ans;
    }

    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        Node tmp=root;
        for(int i=0;i<key.length();i++)
        {
            char c=key.charAt(i);
            System.out.println(c);
            if(tmp.child[c-'a']==null)
            tmp.child[c-'a']=new Node();
            tmp=tmp.child[c-'a'];
        }
        tmp.end=false;
        tmp.s=val;
    }
    
    public int sum(String prefix) {
        Node tmp=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            tmp=tmp.child[c-'a'];
            if(tmp==null)break;
        }
        return rec(tmp);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */