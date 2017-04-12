/**
 * Created by rohanrampuria on 4/10/17.
 *
 * same letter, same counts, different orders
 */
public class MakeTwoStringAnagrams {


    private static final int NUMBER_LETTERS = 26 ;

    public static int numbersNeeded(String first, String second){
        int [] charCount1 = getCharCount(first);
        int [] charCount2 = getCharCount(second);
        return getDelta(charCount1,charCount2);
    }

    private static int getDelta(int[] charCount1, int[] charCount2) {
        if(charCount1.length != charCount2.length){
            return -1;
        }
        int delta =0;
        for(int i=0; i<charCount1.length; i++){
            int difference = Math.abs(charCount1[i] - charCount2[i]);
            delta+=difference;
        }
        return delta;
    }

    private static int[] getCharCount(String s) {
        int [] charCounts = new int[NUMBER_LETTERS];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;

    }

    public static void main(String [] args){
        String s1 = "happy";
        String s2 = "ha";
        System.out.print(numbersNeeded(s1,s2));
    }


}
