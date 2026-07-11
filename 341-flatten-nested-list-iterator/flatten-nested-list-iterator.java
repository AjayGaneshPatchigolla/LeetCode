/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    ArrayList<Integer> tmp;
    void rec(NestedInteger list)
    {
        // System.out.println(list);
        if(!list.isInteger())
        {
            for(NestedInteger i: list.getList())
            rec(i);
        }
        else
        tmp.add(list.getInteger());
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        tmp=new ArrayList<>();
        for(NestedInteger i: nestedList)
        {
            if(!i.isInteger())
            rec(i);
            else
            tmp.add(i.getInteger());
        }
        it=tmp.iterator();
    }

    @Override
    public Integer next() {
        if(it.hasNext())
        return it.next();
        return -1;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */