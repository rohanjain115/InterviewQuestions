package StringArrayExamples;

import java.util.HashSet;

/**
 * Created by rohanrampuria on 4/16/17.
 *
 * Longest Substring without repeating characters
 */
public class LongestSubString {


    public static int lengthOfLongestSubstring(String s) {

        int length =0;
        int start =0;
        HashSet<Character> charSet = new HashSet<>();
        char [] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++){
           if(!charSet.contains(charArray[i])){
               charSet.add(charArray[i]);
               length = Math.max(length,i-start+1);
           }
           else{
               for(int j=0; j<i; j++){
                   charSet.remove(charArray[j]);
                   if(charArray[j] == charArray[i]){
                       start = j+1;
                       break;
                   }
                   charSet.add(charArray[i]);
               }
           }


        }
        return length;
    }

    public static void main(String [] args){

        String s= "dvdf";
        System.out.print(lengthOfLongestSubstring(s));
    }

}
