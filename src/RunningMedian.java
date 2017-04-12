import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rohanrampuria on 4/10/17.
 */
public class RunningMedian {


    public static void addNumber(int number, PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        if(lowers.isEmpty() || number < lowers.peek()){
            lowers.add(number);
        }
        else{
            highers.add(number);
        }
    }
    public static void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }
    public static double getMedian(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() == smallerHeap.size()){
            return (double)(biggerHeap.peek() + smallerHeap.peek())/2;
        }else{
            return biggerHeap.peek();
        }
    }

    public static double [] getMedians(int [] array){
        //Max Heap use Comparator change the comparison and put max element on top
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*o1.compareTo(o2);
            }
        });

        //min heap is simple priority Queue
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double [] medians = new double[array.length];
        for(int i =0; i<array.length; i++){
            int number = array[i];
            addNumber(number,lowers,highers);
            rebalance(lowers,highers);
            medians[i] = getMedian(lowers,highers);
        }
        return medians;
    }
}
