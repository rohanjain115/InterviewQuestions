package top10Questions.searchandsort;

/**
 * Created by rohanrampuria on 4/6/17.
 */
public class InsertionSort {

    public static void main(String [] args){
        InsertionSort obj = new InsertionSort();
        int [] arr = {1,5,4,3,7,2};
        obj.insertionSort(arr);
        obj.printArray(arr);
    }

    public void insertionSort(int[] arr){
        int size = arr.length;
        for(int i=1; i<size; i++){
            int key = arr[i];
            int j= i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1]= key;
        }
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
