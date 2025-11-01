package LinkList;

/**
 * @author : Asnit Bakhati
 */
public class LeetCodeFunctions {


    /**
     * Problem name : Delete Nodes From Linked List Present in Array
     * @param nums is array of numbers that is to be deleted in the Linked List
     * @param head is the ListNode that is the head of the LinkedList
     * @return a ListNode head which points to a linked list that doesn't
     * contain any numbers from nums in the Linked List
     */

        public ListNode modifiedList(int[] nums, ListNode head) {

            if(head==null){
                return head;
            }

            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num);
            }
            while(head != null && set.contains(head.val)) {
                head = head.next;
            }
            if(head == null) return null;

            ListNode temp = head;
            ListNode next = temp.next;
            while(next!=null){
                if(set.contains(next.val)){
                    temp.next = next.next;
                }else{
                    temp = next;
                }
                next = next.next;
            }
            return head;
        }
}
