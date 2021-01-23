import java.util.*;

class Solution {
    public int solve(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<ops.length; i++){
            String cur = ops[i];

            if(isNumeric(cur)){
                int num = Integer.parseInt(cur);
                if(num<0)
                    return -1;
                else
                    stack.push(num);
            }
            else if(cur.equals("POP") && !stack.isEmpty()){
                stack.pop();
            }
            else if(cur.equals("DUP") && !stack.isEmpty()){
                int num = stack.pop();

                stack.push(num);
                stack.push(num);
            }
            else if(cur.equals("+") && stack.size()>1){
                stack.push(stack.pop() + stack.pop());
            }
            else if(cur.equals("-") && stack.size()>1){
                stack.push(stack.pop() - stack.pop());
            }
            else return -1;
        }

        if(stack.size()>0)
            return stack.pop();
        else
            return -1;
    }


    public static boolean isNumeric(String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);

    }
}