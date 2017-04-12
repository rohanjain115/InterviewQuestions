package dynamicprogramming;

/**
 * Created by rohanrampuria on 3/19/17.
 */
import java.util.*;

public class SplitArray{

    public static void main(String []args){
        int arr[] = {1,5,5,6,7,10,20};
        System.out.print("Original array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        SplitArray s = new SplitArray();
        try{
            int [][] result = s.splitAccurately (arr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public int[][] splitAccurately(int[] arr) throws InvalidInputException {
        ArrayList<Integer> arr1=new ArrayList<Integer>();
        ArrayList<Integer> arr2=new ArrayList<Integer>();

        if(arr.length == 1)
            throw new InvalidInputException();

        int [][] resultArray = new int[2][arr.length-1];
        Arrays.sort(arr);
        int index=arr.length-1;

        int sum1=0;
        int sum2=0;
        int i=-1 ,j=-1;
        while(index!=-1) {
            if (sum1 < sum2) {
                i++;
                resultArray[0][i] = arr[index];
                arr1.add(arr[index]);
                sum1 += arr[index];
            } else {
                j++;
                resultArray[1][j] = arr[index];
                arr2.add(arr[index]);
                sum2 += arr[index];
            }
            index--;
        }

        //printing the partitioned array
        System.out.print("\nPartition 1:");
        print(arr1);
        System.out.print("\nPartition 2:");
        print(arr2);

        return resultArray;
    }

    public static void print(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+"\t");
        }
    }

}