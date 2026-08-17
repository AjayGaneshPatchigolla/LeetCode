class MyLinkedList {
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    private Node head,tail;
    private int size;
    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }
    
    public int get(int index) {
        if(index>=size)
        return -1;
        if(index==0)
        return head.data;
        if(index==(size-1))
        return tail.data;
        Node tmp=head;
        while(index>0)
        {
            tmp=tmp.next;
            index-=1;
        }
        return tmp.data;
    }
    
    public void addAtHead(int val) {
        Node nn=new Node(val);
        size+=1;
        if(head==null)
        {
            head=nn;
            tail=nn;
        }
        else
        {
            nn.next=head;
            head=nn;
        }
    }
    
    public void addAtTail(int val) {
        Node nn=new Node(val);
        size+=1;
        if(head==null)
        {
            head=nn;
            tail=nn;
        }
        else
        {
            tail.next=nn;
            tail=nn;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size || index<0)
        return;
        else if(index==0)
        addAtHead(val);
        else if(index==size)
        addAtTail(val);
        else
        {
            Node tmp=head;
            while(index>1)
            {
                tmp=tmp.next;
                index-=1;
            }
            Node nn=new Node(val);
            Node next=tmp.next;
            tmp.next=nn;
            nn.next=next;
            size+=1;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size)
        return;
        if(size==1)
        {
            head=tail=null;
            size=0;
            return;
        }
        else if(index==0)
        {
            head=head.next;
            size-=1;
            return;
        }
        else
        {
            Node tmp=head;
            while(index>1)
            {
                tmp=tmp.next;
                index-=1;
            }
            if (tmp.next == tail) 
            {
                tail = tmp;
                tmp.next = null;
            }
            else 
            {
                tmp.next = tmp.next.next;
            }
            size-=1;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */