import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by rohanrampuria on 1/23/17.
 * Amazon interview Question
 */
public class FirstNonRepeatChar {
    public static void main(String [] args){
        System.out.print(nonRepeatChar("Raabbcc"));

    }


    public static char nonRepeatChar(String s){
        LinkedHashMap<Character,Integer> mapp = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(mapp.containsKey(s.charAt(i))){
                mapp.put(s.charAt(i),mapp.get(s.charAt(i))+1);
            }
            else{
                mapp.put(s.charAt(i),1);
            }
        }
        Iterator<Character> itr = mapp.keySet().iterator();
        while(itr.hasNext()){
            Character key = itr.next();
            if(mapp.get(key) == 1){
                return key;
            }
        }
        throw new RuntimeException("No Duplicates found");

    }



}
