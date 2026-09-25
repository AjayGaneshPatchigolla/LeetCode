class UndergroundSystem {
    static class Pair
    {
        int time;
        String station;
        Pair(int time,String station)
        {
            this.time=time;
            this.station=station;
        }
    }
    HashMap<Integer,Pair> inOutTracker;
    HashMap<String,ArrayList<Integer>> AtTracker;
    public UndergroundSystem() {
        inOutTracker=new HashMap<>();
        AtTracker=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        inOutTracker.put(id,new Pair(t,stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair tmp=inOutTracker.get(id);
        String key=tmp.station+"-"+stationName;
        if(!AtTracker.containsKey(key))
        AtTracker.put(key,new ArrayList<>());
        AtTracker.get(key).add(t-tmp.time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double val=0;
        int cnt=0;
        String key=startStation+"-"+endStation;
        for(int i: AtTracker.get(key))
        {
            val+=i;
            cnt+=1;
        }
        return val/(cnt*1.0);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */