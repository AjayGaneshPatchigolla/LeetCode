// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    int tmp=-1;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it=iterator;
        if(it.hasNext())
        {
            tmp=it.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return tmp;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int pv=tmp;
        if(it.hasNext())
        tmp=it.next();
        else
        tmp=-1;
        return pv;
	}
	
	@Override
	public boolean hasNext() {
	    return tmp!=-1;
	}
}