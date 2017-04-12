package binarytree;

/**
 * Created by rohanrampuria on 4/10/17.
 */
public class HeapApp {

    public static void main(String [] args){

        MaxHeap<Integer> hp = new MaxHeap<>();
        hp.insert(3);
        System.out.println(hp);
        hp.insert(4);
        System.out.println(hp.toString());
        hp.insert(5);
        System.out.println(hp.toString());
        hp.insert(2);
        System.out.println(hp.toString());
        hp.insert(7);
        System.out.println(hp.toString());
        hp.delete();
        System.out.println(hp.toString());
    }
}
