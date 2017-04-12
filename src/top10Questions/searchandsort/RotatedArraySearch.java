package top10Questions.searchandsort;

/**
 * Created by rohanrampuria on 4/6/17.
 *
 * Using Binary Search
 */
public class RotatedArraySearch {



    public static void main(String [] args){
        RotatedArraySearch r = new RotatedArraySearch();
        int [] nums = {4,5, 1, 2, 3};
        System.out.print(r.search(nums,3));

    }

    public int search (int [] nums, int target){

        return binarySearch(nums, 0 ,nums.length-1,target);
    }

    private int binarySearch(int[] nums, int low, int high, int target) {

        //base case
        if(low>high){
            return -1;
        }

        int mid = low + (high-low)/2;

        if(target == nums[mid]){
            return mid;
        }

        if(nums[low] <= nums[mid]){
            if(nums[low] <= target && nums[mid]>target){
                return binarySearch(nums,low,mid-1,target);
            }
            else{
                return binarySearch(nums,mid+1,high,target);
            }
        }
        else{
            if(nums[mid]<target && nums[high]>=target){
                return binarySearch(nums,mid+1,high,target);
            }
            else{
                return binarySearch(nums,low, mid-1,target);
            }
        }
    }
}
