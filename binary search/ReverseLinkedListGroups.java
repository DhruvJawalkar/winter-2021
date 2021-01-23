import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int k) {
        if(node==null)
            return node;

        LLNode head = node;
        LLNode ptr = head;  
        Stack<Integer> stack = new Stack<>();  

        while(ptr!=null){
            int counter = k;
            LLNode start = ptr;

            while(counter>0 && ptr!=null){
                stack.push(ptr.val);
                ptr = ptr.next;
                counter--;
            }

            while(!stack.isEmpty()){
                start.val = stack.pop();
                start = start.next;
            }
        }

        return head;    
    }


}