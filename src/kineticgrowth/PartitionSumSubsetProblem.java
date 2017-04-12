package kineticgrowth;

/**
 * Created by rohanrampuria on 3/31/17.
 */
import java.util.LinkedHashMap;
import java.util.Map;
public class PartitionSumSubsetProblem {
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
    /**
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {5,5,5,5,5};//{ 5,5,4,3,3};//{ 11, 1, 5, 11, 5, -11, 0, 2 }
        System.out
                .println(sumOfSubsetIsPossible(arr) ? "Solution is possible" : "No subset exists");
    }
    private static boolean sumOfSubsetIsPossible(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;

        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum = sum + arr[i];

       // if (sum % 2 == 1)
           // return false;
        Map<PartitionSumSubsetProblem.CachedDataAttr, Boolean> CachedData = new LinkedHashMap<PartitionSumSubsetProblem.CachedDataAttr, Boolean>();
        boolean result = mainLogisOfSumOfSubsetIsPossible(arr, sum / 2, size - 1, CachedData);
        //System.out.println(CachedData);
        printSolution(CachedData, arr);
        return result;
    }
    private static void printSolution(Map<CachedDataAttr, Boolean> cachedData, int[] arr) {
        int sum = 0;
        for (Map.Entry<CachedDataAttr, Boolean> cachedMap : cachedData.entrySet()) {
            if (sum == cachedMap.getKey().sum && cachedMap.getValue()) {
                // find the next sum value
                if (sum + arr[cachedMap.getKey().indexOfArray] == cachedMap.getKey().bfrSumDiff) {
                    sum = sum + arr[cachedMap.getKey().indexOfArray];
                    System.out.print(arr[cachedMap.getKey().indexOfArray] + ",");
                }
            }
        }
        System.out.println("\b");
    }
    /**
     * This methods contain the main logic for the problem
     * @param arr
     * @param sum
     * @param size
     * @param cachedData
     * @return
     */
    private static boolean mainLogisOfSumOfSubsetIsPossible(int[] arr, int sum, int size,
                                                            Map<CachedDataAttr, Boolean> cachedData) {
        // base cases , when sum==0, we found the solution
        if (sum == 0)
            return true;
        // base case if size <0 && sum!=0, we have not include few elements that
        if (size < 0 && sum != 0)
            return false;
        // base case, if the solution is already computed, return the solution
        PartitionSumSubsetProblem.CachedDataAttr exData = new PartitionSumSubsetProblem.CachedDataAttr(
                sum, size, sum);// excluded
        PartitionSumSubsetProblem.CachedDataAttr inData = new PartitionSumSubsetProblem.CachedDataAttr(
                sum - arr[size], size, sum);// include
        if (cachedData.containsKey(exData))
            return cachedData.get(exData);
        if (cachedData.containsKey(inData))
            return cachedData.get(inData);
        boolean includeSolution = mainLogisOfSumOfSubsetIsPossible(arr, sum - arr[size], size - 1,
                cachedData);
        boolean excludeSolution = includeSolution
                || mainLogisOfSumOfSubsetIsPossible(arr, sum, size - 1, cachedData);
        cachedData.put(inData, includeSolution);

        if (!includeSolution)
            cachedData.put(exData, excludeSolution);
        return excludeSolution;
    }
}