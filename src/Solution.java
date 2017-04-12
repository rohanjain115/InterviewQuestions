import java.util.Stack;

/**
 * Created by rohanrampuria on 2/8/17.
 */

import org.junit.Assert;
import org.junit.Test;
public class Solution {


    public static void main(String [] args){

        Solution s = new Solution();

        String input = "5 6 + -";
        System.out.print(s.solution(input));


    }
    @Test
    public void allScenarios(){

        Solution s = new Solution();
       // Assert.assertEquals(s.solution("13 DUP 4 POP 5 DUP + DUP + -"), 7);
       // Assert.assertEquals(s.solution("5 6 + -"), -1);
       // Assert.assertEquals(s.solution("3 DUP 5 - -"), -1);
        Assert.assertEquals(s.solution("5 6 + DUP DUP -"), 5);

        Long a = new Long(10);
        a.intValue();


    }




    public int solution(String s){
        if(s.length() > 2000){
            return -1;
        }
        String [] splitarr = s.split(" ");
        Stack<Integer> stackObj = new Stack<>();

        for(int i =0;i<splitarr.length;i++){
            //push into the stack
            if(splitarr[i].matches("-?\\d+")){

                if(checkRange(Integer.parseInt(splitarr[i]))){
                    stackObj.push(Integer.parseInt(splitarr[i]));
                }
                else{
                    return -1;
                }

            }

            else if(splitarr[i].equals("DUP")){
                if(stackObj.isEmpty()){
                    return -1;
                }
                else{
                    int duplicate = stackObj.peek();
                    stackObj.push(duplicate);
                }

            }
            else if(splitarr[i].equals("+")){
                if(stackObj.size() < 2){
                    return -1;
                }
                else{
                    int num1 = stackObj.pop();
                    int num2 = stackObj.pop();
                    int sum = num1+num2;
                    if(checkRange(sum)){
                        stackObj.push(sum);
                    }
                    else{
                        return -1;
                    }

                }
            }
            else if(splitarr[i].equals("-")){
                if(stackObj.size() < 2){
                    return -1;
                }
                else{
                    int num1 = stackObj.pop();
                    int num2 = stackObj.pop();
                    int diff = num1-num2;
                    if(checkRange(diff)){
                        stackObj.push(diff);
                    }
                    else{
                        return -1;
                    }

                }
            }
            else if(splitarr[i].equals("POP")){

                if(stackObj.isEmpty()){
                    return -1;
                }
                else{
                    stackObj.pop();
                }
            }


        }
        if(stackObj.isEmpty()){
            return -1;
        }
        else{
            return stackObj.peek();
        }
    }

    public boolean checkRange(int num){
        if(num > 0 && num < (Math.pow(2,20)-1)){
            return true;
        }
        else{
            return false;
        }
    }

}
