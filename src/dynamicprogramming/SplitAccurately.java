package dynamicprogramming;

/**
 * Created by rohanrampuria on 3/19/17.
 */

        import java.util.LinkedHashMap;
        import java.util.*;
public class SplitAccurately {
    public static class CachedDataAttr {
        int sum;
        int indexOfArray;
        int bfrSumDiff;
        CachedDataAttr(int pSum, int pIndexOfArry, int pAfterSumDiff) {
            this.sum = pSum;
            this.indexOfArray = pIndexOfArry;
            this.bfrSumDiff = pAfterSumDiff;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof CachedDataAttr) {
                CachedDataAttr arg = (CachedDataAttr) o;
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
        int arr[] = {5,5,6,7,10,20};
        SplitAccurately j =new SplitAccurately();
        try {
            j.splitAccurately(arr);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }



    public int[][] splitAccurately(int[] arr) throws InvalidInputException {


        int size = arr.length;
        int sum = 0;

        for (int i = 0; i < size; i++){
            sum = sum + arr[i];
        }

        Map<SplitAccurately.CachedDataAttr, Boolean> CachedData = new LinkedHashMap<SplitAccurately.CachedDataAttr, Boolean>();
        boolean result = split(arr, sum / 2, size - 1, CachedData);
        System.out.print("Original list is: ");
        print(arr);

        return print(CachedData, arr);

    }
    private static int [][] print(Map<CachedDataAttr, Boolean> cachedData, int[] arr) {
        int [][] resultarray = new int[2][arr.length-1];
        int m=0,n=0;
        int sum = 0;
        ArrayList<Integer> lst=new ArrayList<Integer>();
        boolean[] con=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            con[i]=false;
        }
        for (Map.Entry<CachedDataAttr, Boolean> cachedMap : cachedData.entrySet()) {
            if (sum == cachedMap.getKey().sum && cachedMap.getValue()) {
                if (sum + arr[cachedMap.getKey().indexOfArray] == cachedMap.getKey().bfrSumDiff) {
                    sum = sum + arr[cachedMap.getKey().indexOfArray];
                    //System.out.println(arr[cachedMap.getKey().indexOfArray]);
                    lst.add(arr[cachedMap.getKey().indexOfArray]);
                    resultarray[0][m++] = arr[cachedMap.getKey().indexOfArray];
                }
            }
        }
        System.out.print("\nThe two partition list are:"+lst+" and ");
        for(int i=0;i<arr.length;i++){
            if(lst.contains(arr[i])){
                con[i]=true;
                lst.remove(lst.indexOf(arr[i]));
            }
        }
        System.out.print("[");
        for(int i=0;i<arr.length;i++){

            if(con[i]==false){
                System.out.print(arr[i]+", ");
                resultarray[1][n++]=arr[i];
            }
        }
        System.out.print("]");
        return resultarray;
    }

    private static boolean split(int[] arr, int sum, int size,
                                 Map<CachedDataAttr, Boolean> cachedData) {

        if (sum == 0)
            return true;

        if (size < 0 && sum != 0)
            return false;

        SplitAccurately.CachedDataAttr exData = new SplitAccurately.CachedDataAttr(sum, size, sum);
        SplitAccurately.CachedDataAttr inData = new SplitAccurately.CachedDataAttr(sum - arr[size], size, sum);
        if (cachedData.containsKey(exData))
            return cachedData.get(exData);
        if (cachedData.containsKey(inData))
            return cachedData.get(inData);
        boolean includeSolution = split(arr, sum - arr[size], size - 1,cachedData);
        boolean excludeSolution = includeSolution|| split(arr, sum, size - 1, cachedData);
        cachedData.put(inData, includeSolution);

        if (!includeSolution)
            cachedData.put(exData, excludeSolution);
        return excludeSolution;
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}