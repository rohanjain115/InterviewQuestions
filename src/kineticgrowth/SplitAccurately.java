package kineticgrowth; /**
 * Created by rohanrampuria on 3/20/17.
 *
 * This class contains splitAccurately method which runs on Dynamic Programming Approach.
 * input : array of integers
 * output: partitioned array
 */

import java.util.*;

public class SplitAccurately {


    /*
    subclass used for storing subsets with sum, index and buffer string of sum diff.
     */
    public static class CacheDataStruct {
        int sum;
        int indexOfArray;
        int bfrSumDiff;

        CacheDataStruct(int pSum, int pIndexOfArry, int pAfterSumDiff) {
            this.sum = pSum;
            this.indexOfArray = pIndexOfArry;
            this.bfrSumDiff = pAfterSumDiff;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof CacheDataStruct) {
                CacheDataStruct arg = (CacheDataStruct) o;
                this.sum = arg.sum;
                this.indexOfArray = arg.indexOfArray;
            }
            return false;
        }

        public String toString() {
            return "sum =" + this.sum + " :: index = " + (this.indexOfArray + 1)
                    + " :: bfrSumDiff= " + this.bfrSumDiff + "\t";
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,5,5,5,5};
        SplitAccurately j = new SplitAccurately();
        try {
            //j.splitAccurately(arr);
            j.minDiff();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int[][] splitAccurately(int[] arr) throws InvalidInputException {


        int size = arr.length;

        // validating the array if its suitable for partition by checking its size
        if(arr.length == 1 || arr.length == 0)
            throw new InvalidInputException();

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + arr[i];
        }

        //to maintain insertion order used LinkedHashMap
        Map<CacheDataStruct, Boolean> CachedData = new LinkedHashMap<CacheDataStruct, Boolean>();
        boolean result = split(arr, sum / 2, size - 1, CachedData);
        System.out.print("Original list is: ");
        print(arr);

        return solution(CachedData, arr);

    }

    //prints and returns the result array
    private static int[][] solution(Map<CacheDataStruct, Boolean> cachedData, int[] arr) {
        int[][] resultarray = new int[2][arr.length - 1];
        int m = 0, n = 0;
        int sum = 0;
        ArrayList<Integer> lst = new ArrayList<Integer>();
        boolean[] con = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            con[i] = false;
        }
        for (Map.Entry<CacheDataStruct, Boolean> cachedMap : cachedData.entrySet()) {
            if (sum == cachedMap.getKey().sum && cachedMap.getValue()) {
                if (sum + arr[cachedMap.getKey().indexOfArray] == cachedMap.getKey().bfrSumDiff) {
                    sum = sum + arr[cachedMap.getKey().indexOfArray];
                    lst.add(arr[cachedMap.getKey().indexOfArray]);
                    resultarray[0][m++] = arr[cachedMap.getKey().indexOfArray];
                }
            }
        }
        System.out.print("\nThe two partition list are:" + lst + " and ");
        for (int i = 0; i < arr.length; i++) {
            if (lst.contains(arr[i])) {
                con[i] = true;
                lst.remove(lst.indexOf(arr[i]));
            }
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {

            if (con[i] == false) {
                System.out.print(arr[i] + ", ");
                resultarray[1][n++] = arr[i];
            }
        }
        System.out.print("]");
        return resultarray;
    }

    //performs in-depth recursion to calculate subset sums
    private static boolean split(int[] arr, int sum, int size,
                                 Map<CacheDataStruct, Boolean> cachedData) {

        if (sum == 0)
            return true;

        if (size < 0 && sum != 0)
            return false;

        CacheDataStruct exData = new CacheDataStruct(sum, size, sum);
        CacheDataStruct inData = new CacheDataStruct(sum - arr[size], size, sum);
        if (cachedData.containsKey(exData))
            return cachedData.get(exData);
        if (cachedData.containsKey(inData))
            return cachedData.get(inData);
        boolean includeSolution = split(arr, sum - arr[size], size - 1, cachedData);
        boolean excludeSolution = includeSolution || split(arr, sum, size - 1, cachedData);
        cachedData.put(inData, includeSolution);

        if (!includeSolution)
            cachedData.put(exData, excludeSolution);
        return excludeSolution;
    }

    //prints the array
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }




    public void minDiff()
    {
        List<Integer> list1 = new ArrayList<Integer>();
        //1,5,5,6,7,10,20
        list1.add(20);
        list1.add(5);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(10);
        list1.add(1);


        ArrayList<Integer> list2 = new ArrayList<Integer>();
        Integer minDiff = 0;
        Integer currDiff = 0;

        for(int i=0;i < list1.size();i++)
        {
            minDiff += list1.get(i);
        }
        currDiff = minDiff;

        for(int j = list1.size()-1;j >= 0; j--)
        {
            currDiff = currDiff - (2*list1.get(j));
            if(Math.abs(currDiff) <= minDiff)
            {
                minDiff = Math.abs(currDiff);
                list2.add(list1.get(j));
                list1.remove(j);
            }
            else
            {
                break;
            }
        }




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


        System.out.println(list1.toString() + "," + list2.toString());


    }
    private static int getSumOfEntries(List<Integer> list){
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        return sum;
    }
}