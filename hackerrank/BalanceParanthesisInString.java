import java.util.Stack;
import Pair;

public class BalanceParanthesisInString {
    private static String getBalancedParanthesisString(String input){
        StringBuilder sb = new StringBuilder();

        for(char ch : input.toCharArray()){
            sb.append(ch);
        }

        Stack<Pair> stack = new Stack<>();
        
        for(int i=0; i<sb.length(); i++){
            char ch = input.charAt(i);

            if(ch=='(' || ch==')'){
                if(!stack.isEmpty() && stack.peek().getKey()=='(' && ch==')'){
                    stack.pop();
                }
                else{
                    stack.push(new Pair(ch, i));
                }
            }
        }

        while(!stack.isEmpty()){
            int i = stack.pop().getValue();
            sb.setCharAt(i, ' ');
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String test1 = "()";
        String test2 = "b(a)r)";
        String test3 = ")(";
        String test4 = "(((((";
        String test5 = ")(())(";

        System.out.println("Result for "+ test1 +" -> "+ getBalancedParanthesisString(test1));
        System.out.println("Result for "+ test2 +" -> "+ getBalancedParanthesisString(test2));
        System.out.println("Result for "+ test3 +" -> "+ getBalancedParanthesisString(test3));
        System.out.println("Result for "+ test4 +" -> "+ getBalancedParanthesisString(test4));
        System.out.println("Result for "+ test5 +" -> "+ getBalancedParanthesisString(test5));
    }
}
