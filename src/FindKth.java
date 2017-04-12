import java.util.PriorityQueue;

/**
 * Created by rohanrampuria on 3/27/17.
 */
public class FindKth {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    public static void main(String [] args){
        FindKth k = new FindKth();
        int [] nums = {4,3,2,5,1,6};
        System.out.print(k.findKthLargest(nums, 2));
    }
}
