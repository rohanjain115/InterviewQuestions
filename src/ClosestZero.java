import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rohanrampuria on 3/28/17.
 */
public class ClosestZero {



    public static void main(String [] args){

        ClosestZero cal = new ClosestZero();
        String result = cal.nearestZero("10110111101");


    }

    public String nearestZero(String s) {

        List<Integer> indexList = new ArrayList<>();

        char [] inputArr = s.toCharArray();
        for(int i=0; i<inputArr.length; i++){
            if(inputArr[i] == '0'){
                indexList.add(i);
            }
        }

        int [] result = new int[inputArr.length] ;
        int count =0;
        for(int i=0; i<inputArr.length; i++){
            if(inputArr[i] == '0'){
                result[count++] = 0;
            }
            else{
                int closest = search(indexList,i);


                result[count++] = Math.abs(i-indexList.get(closest));
            }
        }
        return result.toString();
    }


    private int search(List<Integer> indexList, int x){
        int minIndex  = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<indexList.size(); i++){
            int diff = Math.abs(indexList.get(i)-x);
            if(min > diff){
                min = diff;
                minIndex =i;
            }
        }

        return minIndex;
    }
}
