class EventManager {
    static class Pair
    {
        int e,p;
        Pair(int e,int p)
        {
            this.e=e;
            this.p=p;
        }
    }
    PriorityQueue<Pair> pq;
    HashMap<Integer,Integer> hm;
    public EventManager(int[][] events) {
        pq=new PriorityQueue<>((a,b) -> {
            if(a.p==b.p)
            return a.e-b.e;
            return b.p-a.p;
        });
        hm=new HashMap<>();
        for(int i=0;i<events.length;i++){
        pq.add(new Pair(events[i][0],events[i][1]));
        hm.put(events[i][0],events[i][1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        if(hm.get(eventId)!=newPriority){
        hm.put(eventId,newPriority);
        pq.add(new Pair(eventId,newPriority));
        }
    }
    public int pollHighest() {
        while(!pq.isEmpty())
        {
            Pair t=pq.poll();
            if(hm.containsKey(t.e) && hm.get(t.e)==t.p)
            {
                hm.remove(t.e);
                return t.e;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */