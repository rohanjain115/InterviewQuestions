import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohanrampuria on 1/11/17.
 */
public class Permutation {

    public static void main(String [] args){
        String input = "abc!";
        List<String> ls = permutation(input);
        System.out.print("");
    }

    public static List<String> permutation(String text){
        List<String> results = new ArrayList<>();

        if(text.length() == 1){
            results.add(text);
            return results;
        }
        for(int i=0;i<text.length();i++){
            char first = text.charAt(i);
            String remains= text.substring(0,i) + text.substring(i+1);
            List<String> innerpermute = permutation(remains);
            for(String s:innerpermute){
                results.add(first + s);
            }
        }
        return results;

    }



/*
    public static List<String> permutation(String text){

        List<String> results = new ArrayList<>();
        // the base case
        if (text.length() == 1) {
            results.add(text);
            return results;
        }
        for(int i =0;i<text.length();i++){
            char first = text.charAt(i);
            String remains = text.substring(0, i) + text.substring(i + 1);
            List<String> innerPermutations = permutation(remains);
            for (int j = 0; j < innerPermutations.size(); j++)
                results.add(first + innerPermutations.get(j));
        }

        return results;
    }
*/
}
