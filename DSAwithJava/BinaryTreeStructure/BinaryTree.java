package BinaryTreeStructure;

import LinkedQueue.LinkedList;
import LinkedQueue.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public static int binaryInsert(BinaryNode rootNode,BinaryNode node){
        if(rootNode==null){
            rootNode = node;
            return rootNode.value;
        }else if(rootNode.value>=node.value){
            return binaryInsert(rootNode.left,node);
        }else return binaryInsert(rootNode.right,node);
    }


    public static boolean search(int searchVal,BinaryNode rootNode){
        if(rootNode==null) return false;
        if(rootNode.value==searchVal) return true;
        if(rootNode.value>searchVal){
            return search(searchVal,rootNode.left);
        }else return search(searchVal,rootNode.right);
    }

    public static boolean search(BinaryNode searchVal,BinaryNode rootNode){
        if(rootNode==null) return false;
        if(rootNode.value==searchVal.value) return true;
        if(rootNode.value>searchVal.value){
            return search(searchVal,rootNode.left);
        }else return search(searchVal,rootNode.right);
    }

    public static void inorderDisplay(BinaryNode rootNode, List<Integer> nums){
        if(rootNode==null){
            return;
        }
        inorderDisplay(rootNode.left,nums);
        nums.add(rootNode.value);
        inorderDisplay(rootNode.right,nums);
    }

    public static void preorderDisplay(BinaryNode rootNode, List<Integer> nums){
        if(rootNode==null){
            return;
        }
        nums.add(rootNode.value);
        preorderDisplay(rootNode.left,nums);
        preorderDisplay(rootNode.right,nums);
    }

    public static void postorderDisplay(BinaryNode rootNode, List<Integer> nums){
        if(rootNode==null){
            return;
        }
        nums.add(rootNode.value);
        postorderDisplay(rootNode.left,nums);
        postorderDisplay(rootNode.right,nums);
    }

    public static List<Integer> breadthFirstSearch(BinaryNode rootNode){
        if(rootNode==null) return null;
        Queue<BinaryNode> queue = (Queue<BinaryNode>) new LinkedList<BinaryNode>();
        List<Integer> list = new ArrayList<>();
        list.add(rootNode.value);
        queue.add(rootNode);
        while (!queue.isEmpty()){
            BinaryNode current = queue.poll();
            list.add(current.value);
            if(current.left!=null){
                queue.add(current.left);
            }
            if (current.right!=null){
                queue.add(current.right);
            }
        }
        return list;
    }

    public BinaryNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){return null;}
        else {
            return binaryInsert(nums,0,nums.length-1);
        }
    }

    private BinaryNode binaryInsert(int[] nums,int start,int end ){
        if(start>end) return null;
        int mid = (start+end)/2;
        BinaryNode root = new BinaryNode(nums[mid]);
        root.right = binaryInsert(nums,mid+1,end);
        root.left = binaryInsert(nums,start,mid-1);
        return root;
    }

    public BinaryNode sortedListToBST(Node<Integer> head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    private BinaryNode buildBST(Node<Integer> head, Node<Integer>tail) {
        if (head == tail) return null;
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        BinaryNode root = new BinaryNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }

    public int maxDepth(BinaryNode root) {
        if(root == null) return 0;
        if(root.right == null && root.left== null) return 1;
        return 1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }

    public boolean isSymmetric(BinaryNode root) {
        if(root == null) return true;
        if(root.right == null && root.left==null) return true;
        return checkSymmetric(root.right,root.left);
    }

    private boolean checkSymmetric(BinaryNode leftNode, BinaryNode rightNode){
        if((leftNode ==null & rightNode !=null )||(rightNode==null &&leftNode!=null)){
            return false;
        }
        if(rightNode==null&&leftNode==null){
            return true;
        }
        if(rightNode.value == leftNode.value){
            return (checkSymmetric(leftNode.left,rightNode.right)&&checkSymmetric(leftNode.right,rightNode.left));
        }else return false;
    }
}

