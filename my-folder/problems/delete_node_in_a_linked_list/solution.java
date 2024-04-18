/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        int nextNodeVal = node.next.val;

        node.val = nextNodeVal;

        node.next = node.next.next;




        
    }
}