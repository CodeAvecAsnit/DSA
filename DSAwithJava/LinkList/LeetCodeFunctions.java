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


    /**
     * Problem Name : Reveres Linked List II
     * @param head is the head of the linked list
     * @param left is the left part that is supposed to be in the right
     * @param right is the right part that is supposed to be in the left
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right==left) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        ListNode prev = dummy;
        for(int i = 1 ;i<left;++i){
            prev = prev.next;
        }
        prev.next = reverseNode(left,right,prev.next);
        return dummy.next;
    }

    private ListNode reverseNode(int left, int right,ListNode head){
        ListNode currentNode = head;
        ListNode prev = null;
        for(int i = 0 ; i <(right-left+1);++i){
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }
        head.next = currentNode;
        return prev;
    }

    /**
     * This problem is related with both tree and linked list
     * @param head is the first node of the linked list inside binary tree
     * @param root is the first node of the tree
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        return check(root,head)|| isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    boolean check(TreeNode root, ListNode head){
        if(head==null) return true;
        if(root==null) return false;
        if(root.val!=head.val) return false;
        return check(root.left,head.next)||check(root.right,head.next);
    }

}
