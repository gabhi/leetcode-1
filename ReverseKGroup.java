public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head, next = head.next;
        
        int len = 0;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
       
        while(len >= k) {
            curr = prev.next;
            next = curr.next;
            for(int i = 0; i < k - 1; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            len -= k;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {}
}