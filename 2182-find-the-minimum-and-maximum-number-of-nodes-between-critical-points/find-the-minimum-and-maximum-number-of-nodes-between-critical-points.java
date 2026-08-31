/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        ListNode prev=head,curr=head.next;
        int fcp=-1,pcp=-1,pos=1,min=Integer.MAX_VALUE;
        while(curr.next!=null)
        {
            if((curr.val>prev.val && curr.val>curr.next.val) || ((curr.val<prev.val && curr.val<curr.next.val)))
            {
                // System.out.println(fcp+" "+pcp+" "+pos+" "+min);
                if(pcp==-1)
                {
                    fcp=pos;
                    pcp=pos;
                }
                else
                {
                    min=Math.min(min,pos-pcp);
                    pcp=pos;
                }
            }
            pos+=1;
            prev=prev.next;
            curr=curr.next;
        }
        if(min==Integer.MAX_VALUE)
        return ans;
        ans[0]=min;
        ans[1]=pcp-fcp;
        return ans;
    }
}