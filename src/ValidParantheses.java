

import java.util.Stack;

/**
 * Created by rohanrampuria on 3/27/17.
 */
public class ValidParantheses {

    public static void main(String [] args){


        ValidParantheses v = new ValidParantheses();
        boolean val = false;

            val = v.isValid("");

        System.out.print(val);
    }



    public boolean isValid(String input) {
        if(input.length() == 0 || input== null){

        }

        Stack<Character> inputStack = new Stack<>();
        int pushCount =0;
        int popCount =0;
        char [] charArray = input.toCharArray();
        for(Character c : charArray) {
            if (c.equals('(')) {
                inputStack.push(c);
                pushCount++;
            } else if (c.equals(')')) {
                if (inputStack.isEmpty()) {
                    return false;
                } else if (inputStack.peek().equals('(')) {
                    inputStack.pop();
                    popCount++;
                } else {
                    return false;
                }
            }
        }
        if(inputStack.isEmpty() && popCount == pushCount){
            return true;
        }
        return  false;

    }

}
