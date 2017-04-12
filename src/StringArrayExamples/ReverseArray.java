package StringArrayExamples;

/**
 * Created by rohanrampuria on 1/27/17.
 *
 *
 * Question : Reverse an array without affecting special characters
 *
 * Eg: Input:   str = "a,b$c"
     Output:  str = "c,b$a"
     Note that $ and , are not moved anywhere.
     Only subsequence "abc" is reversed
     Input:   str = "Ab,c,de!$"
     Output:  str = "ed,c,bA!$"
 */

import java.util.*;
public class ReverseArray {


    public static void main(String [] args){
        String input = "a!!!b.c.d,e'f,ghi";
        String output = optimizedReverse(input);

        System.out.println("Old String:"+input);
        System.out.println("New String:"+output);
    }

    private static boolean isAlphabet(char ch){
       return Character.isLetter(ch);
    }

    private static String reverse(String input) {

        List<Character> temp = new ArrayList<>();
        temp.size();
        StringBuffer sb = new StringBuffer();
        int j=0;
        for(int i=0;i<input.length();i++){

            if(isAlphabet(input.charAt(i))){
                temp.add(input.charAt(i));
                j++;
            }
        }
        j=temp.size()-1;
        for(int i=0;i<input.length();i++){


            if(isAlphabet(input.charAt(i))){
                sb.append(temp.get(j));
                j--;
            }
            else{
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }



    private static String optimizedReverse(String input){
        char [] arr = input.toCharArray();
        int start =0;
        int end = arr.length-1;

        while(start<end){
            if(!Character.isLetter(arr[start])){
                start++;
            }
            else if(!Character.isLetter(arr[end])){
                end--;
            }
            else{
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return String.valueOf(arr);


    }
}
