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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
           
        Map<Integer,Integer> map = new LinkedHashMap<>();
        ListNode temp = head;

        while(temp != null){
            map.put(temp.val, map.getOrDefault(temp.val,0) + 1);
            temp = temp.next;
        }

        ListNode newHead = new ListNode(1);
        ListNode newTemp = newHead;

        while(head != null){
            if(map.get(head.val) == 1){
                newHead.next = new ListNode(head.val);
                newHead = newHead.next;
            }
            head = head.next;
        }




        return newTemp.next;      
    }
}