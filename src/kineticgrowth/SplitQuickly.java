package kineticgrowth; /**
 * Created by rohanrampuria on 3/20/17.
 *
 *This class contains splitQuickly method which runs on Greedy Approach.
 * input : array of integers
 * output: partitioned array
 */
import java.util.*;

public class SplitQuickly {

    private static List<Integer> list1= new ArrayList<>();
    private static List<Integer> list2= new ArrayList<>();

    public static void main(String[] args) {
        int[] arr= new int[]{5,5,5,1};//new int[]{1,5,5,6,7,10,20};
        SplitQuickly f = new SplitQuickly();

        try{
            int [][]result = f.splitQuickly(arr);
        }catch (InvalidInputException e){
            e.printStackTrace();
        }


    }

    public int[][] splitQuickly(int[] array) throws InvalidInputException{

        // validating the array if its suitable for partition by checking its size
        if(array.length == 1 || array.length == 0)
            throw new InvalidInputException();

        int diff=-1;

        //Converting array to list
        List<Integer> rawList = new ArrayList<>();
        for(int num: array)
            rawList.add(num);

        //Sorting the array in descending order
        Collections.sort(rawList);
        Collections.reverse(rawList);

        // partitioning the list based on values and subList sums
        for(int a:rawList){
            int sumOfList1=0;
            int sumOfList2=0;

            for(Integer i:list1){
                sumOfList1+=i;
            }
            for(Integer i:list2){
                sumOfList2+=i;
            }
            if(sumOfList1<=sumOfList2){
                list1.add(a);
            }else{
                list2.add(a);
            }
        }


        /*
        Un-comment this for further optimization
         */


        List<Integer> list3=new ArrayList<>(list1);
        List<Integer> list4= new ArrayList<>(list2);
        if(list3.size()!=list4.size()){     // both list should contain equal no. of entries.
            //If not, add 0 to the list having lesser no. of entries
            if(list3.size()<list4.size()){
                list3.add(0);
            }else{
                list4.add(0);
            }
        }
        Map<Integer, List<Integer>> mapOfProbables= new HashMap<Integer, List<Integer>>();
        int probableValueCount=0;
        for(int i=0; i<list3.size();i++){
            for(int j=0; j<list4.size();j++){
                if(Math.abs(list3.get(i)-list4.get(j))
                        <Math.abs(getSumOfEntries(list3)-getSumOfEntries(list4))){
                    List<Integer> list= new ArrayList<>();
                    list.add(list3.get(i));
                    list.add(list4.get(j));
                    mapOfProbables.put(probableValueCount++, list);
                }
            }
        }
        int minimumDiff=Math.abs(getSumOfEntries(list1)-getSumOfEntries(list2));
        List resultList= new ArrayList<>();
        for(List probableList:mapOfProbables.values()){
            list3=new ArrayList<>(list1);
            list4= new ArrayList<>(list2);
            list3.remove(probableList.get(0));
            list4.remove(probableList.get(1));
            list3.add((Integer)probableList.get(1));
            list4.add((Integer)probableList.get(0));
            if(minimumDiff>Math.abs(getSumOfEntries(list3)-getSumOfEntries(list4))){ // valid exchange
                minimumDiff=Math.abs(getSumOfEntries(list3)-getSumOfEntries(list4));
                resultList=probableList;
            }

        }

        if(resultList.size()>0){   // forming the two set of nos. whose difference of sum comes out to be minimum
            list1.remove(resultList.get(0));
            list2.remove(resultList.get(1));
            if(!resultList.get(1).equals(0) ) {   // (resultList.get(1).equals(0) && !list1.contains(0))
                list1.add((Integer) resultList.get(1));
            }
            if(!resultList.get(0).equals(0) || (resultList.get(0).equals(0) && list2.contains(0))) {
                list2.add((Integer) resultList.get(0));
            }
        }




        //putting partitions into result array
        int i=0,j=0;
        int [][] result = new int[2][array.length-1];
        for(int num:list1){
            result[0][i++] = num;
        }
        for(int num:list2){
            result[1][j++] = num;
        }

        //printing output
        System.out.print("Original list is: ");
        print(array);
        System.out.println("\nThe two partition list are: "+list1+" and "+list2);


        return result;
    }


    //prints the array value
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

    //calculates the sum of list
    private static int getSumOfEntries(List<Integer> list){
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        return sum;
    }
}