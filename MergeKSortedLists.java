import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for(ListNode node : lists) {
            if(node != null) q.add(node);
        }

        while(!q.isEmpty()) {
            ListNode poll = q.poll();
            p.next = new ListNode(poll.val);
            if(poll.next != null) {
                q.add(poll.next);
            }
            p = p.next;
        }

        return dummy.next;
        
    }

    public static void main(String[] args) {
        System.out.println("[info] ");
    }
}

