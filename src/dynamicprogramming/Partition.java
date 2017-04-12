package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rohanrampuria on 3/17/17.
 */
public class Partition {


    private int maxValue = 0;
    private int minValue = 0;
    private int[] boolUsed = null;
    
    public static void main(String [] args){
        Partition p = new Partition();
        int [] integerList = {1,1,1,1,3,1};
        try {
            int[][] ints = p.splitAccurately(integerList);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

    }



    public int[][] splitAccurately(int[] integerList) throws InvalidInputException {
        // Java method body
        int size = integerList.length;
        initializeBool(size);
        Arrays.sort(integerList);
        minValue = integerList[0];
        maxValue = integerList[size-1];
        int idx = -1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        for(int i=0; i<size; i++){
            if(boolUsed[i] == 1)
                continue;
            int minIndex = findNearest(integerList,i,size);
            boolUsed[minIndex] = 1;
            boolUsed[i] = 1;

            if(findSum(left) <= findSum(right)){
                left.add(Math.max(integerList[minIndex],integerList[i]));
                right.add(Math.min(integerList[minIndex],integerList[i]));
            }
            else{
                left.add(Math.min(integerList[minIndex],integerList[i]));
                right.add(Math.max(integerList[minIndex],integerList[i]));
            }
        }


        return null;
    }

    private int findNearest(int[] inputList, int idx, int size ){
        int minIndex = -1;
        int minDiff = maxValue - minValue;
        for(int i=0; i<size; i++){
            if(i == idx)
                continue;
            if(boolUsed[i] == 1)
                continue;
            int diff = Math.abs(inputList[idx] - inputList[i]);
            if(diff <= minDiff){
                minDiff = diff;
                minIndex = i;
            }
        }
        if(minIndex != -1)
            boolUsed[minIndex] = 1;
        return minIndex;
    }

    private int[] initializeBool(int size){
        boolUsed = new int[size];
        for(int i =0; i<size;i++){
            boolUsed[i]=0;
        }
        return boolUsed;
    }
    private int findSum(List<Integer> list){
        int sum=0;
        for(int i: list){
            sum+= i;
        }
        return sum;
    }
}

