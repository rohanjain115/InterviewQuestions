package top10Questions.searchandsort;

/**
 * Created by rohanrampuria on 4/6/17.
 */
public class BubbleSort {

    public static void main(String [] args){
        BubbleSort b = new BubbleSort();
        int [] arr = {1,5,4,3,7,2};
        b.bubbleSort(arr);
        b.printArray(arr);
    }

    public void bubbleSort(int[] arr){
        int size = arr.length;
        boolean swapped;
        for(int i=0; i<size; i++){
            swapped = false;
            for(int j=0; j<size-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
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
