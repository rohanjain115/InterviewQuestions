/**
 * Created by rohanrampuria on 3/21/17.
 */
import java.util.*;

public class AnagramString{

    public static void main(String []args){
        String[] arr= {"car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching"};
        friendlyWords(arr);
    }

    public static String[] friendlyWords(String[] input) {

        TreeMap<String,ArrayList> map=new TreeMap<>();

        for(int i=0;i<input.length;i++){
            String word=input[i];
            char[] arr=word.toCharArray();
            Arrays.sort(arr);
            String b = new String(arr);
            if(map.containsKey(b)){
                ArrayList lst1= map.get(b);
                lst1.add(word);
                map.put(b,lst1);
            }else{
                ArrayList<String> lst=new ArrayList<>();
                lst.add(word);
                map.put(b,lst);
            }
        }





        ArrayList<String> temp=new ArrayList<>();
        int j=0;
        StringBuilder sb=null;
        for(String key:map.keySet()){
            ArrayList<String>lst=map.get(key);

            if(lst.size()>1){
                sb=new StringBuilder();
                Collections.sort(lst);
                for(int i=0;i<lst.size();i++){
                    sb.append(lst.get(i)+" ");
                }
                temp.add(sb.toString());

            }


        }
        String[] result=new String[temp.size()];
        result= temp.toArray(result);

        return result;
    }
}