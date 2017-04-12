/**
 * Created by rohanrampuria on 3/27/17.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchIndex {


    public int findIndex(List<Integer> inputList, int elementToSearch){

        HashMap<Integer,Integer> intMap = new HashMap<>();

        for(int i=0; i<inputList.size(); i++){

            intMap.put(inputList.get(i), i);
        }

        int result = intMap.get(elementToSearch);
        return result;

    }

    public static void main(String [] args){

        List<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(10);
        input.add(10);
        input.add(10);
        input.add(20);
        input.add(20);
        input.add(30);
        input.add(30);
        input.add(30);

        SearchIndex s = new SearchIndex();
        s.findIndex(input,10);


    }


}
