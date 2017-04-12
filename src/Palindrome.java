/**
 * Created by rohanrampuria on 1/10/17.
 */
public class Palindrome {


    public static void main(String [] args){

        String input = "Stressed desserts";
        boolean value= isphrasepalindrome(input);
        System.out.print(value);
    }

    public static boolean ispalindrome(String s){
        int start =0;
        int end = s.length()-1;

        if (s.equals(null)){
            return false;
        }
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static boolean isphrasepalindrome(String s){
        String text = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return ispalindrome(text);

    }

}
