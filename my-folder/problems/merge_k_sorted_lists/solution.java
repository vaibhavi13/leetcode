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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0 || lists == null){
            return null;
        }

        // ListNode head = lists[0];

        // for(int i = 1 ; i < lists.length ; i++){
        //     head = merge(head, lists[i]);
        // }
        
        // return head;

        int start = 0 ;
        int end = lists.length - 1;

        return mergeHelper(lists, start, end);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if(start >= end){
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1 , end);

        return merge(left,right);
        
    }

    private ListNode merge(ListNode head, ListNode node){

        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;

        while(head != null && node != null){
            if(head.val < node.val){
                temp.next = head;
                head = head.next;
            }else{
                temp.next = node;
                node = node.next;
            }
            temp = temp.next;
        }

        temp.next = head != null ? head : node;

        return newHead.next;

    }
}