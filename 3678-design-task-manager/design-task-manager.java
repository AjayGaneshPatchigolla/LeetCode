class TaskManager {
    static class Task
    {
        int userId,taskId,priority;
        Task(int userId,int taskId,int priority)
        {
            this.userId=userId;
            this.taskId=taskId;
            this.priority=priority;
        }
    } 
    HashMap<Integer,Task> ttt;
    HashSet<Integer> rmt;
    PriorityQueue<Task> pq;
    public TaskManager(List<List<Integer>> tasks) {
        ttt=new HashMap<>();
        rmt=new HashSet<>();
        pq=new PriorityQueue<>((a,b) -> {
            if(a.priority==b.priority)
            return b.taskId-a.taskId;
            return b.priority-a.priority;
        });
        for(List<Integer> i: tasks)
        {
            Task nt=new Task(i.get(0),i.get(1),i.get(2));
            pq.add(nt);
            ttt.put(i.get(1),nt);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task nt=new Task(userId,taskId,priority); 
        pq.add(nt);
        ttt.put(taskId,nt);
        rmt.remove(taskId);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task=ttt.get(taskId);
        Task nt=new Task(task.userId,taskId,newPriority);
        ttt.put(taskId,nt);
        pq.add(nt);
    }
    
    public void rmv(int taskId) {
        rmt.add(taskId);
    }
    
    public int execTop() {
        // return -1;
        while(!pq.isEmpty())
        {
            Task tmp=pq.peek();
            int ts=tmp.taskId;
            if(rmt.contains(ts))
            {
                pq.poll();
                continue;
            }
            if(ttt.get(tmp.taskId)==tmp)
            {
                return pq.poll().userId;
            }
            else
            pq.poll();
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */