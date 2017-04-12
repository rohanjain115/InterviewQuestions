package StringArrayExamples;

import java.util.Arrays;

/**
 * Created by rohanrampuria on 1/31/17.
 */
public class ImplementArrayList<E> {


    private Object [] myList;
    private int actSize =0;
    private final int INT_CAPACITY = 10;



    public ImplementArrayList(){
        myList = new Object[INT_CAPACITY];
    }

    // add


    public void add(E e){
        if(actSize == myList.length){
            ensureCapacity();
        }
        myList[actSize++] = e;
    }

    // capacity check
    private void ensureCapacity() {
        int increaseCapacity = myList.length * 2;
        Arrays.copyOf(myList,increaseCapacity);
    }

    // get the size

    public int size(){
        return actSize;
    }


    // remove

    public Object remove(int index){

       // out of bound exception
        if (index < 0 || index >= actSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        Object removeObject = myList[index];

        for(int i = index; i<actSize-1; i++){
            myList[i] = myList[i+1];
        }

        return removeObject;


    }

    // get

    public E get(int index){
        // out of bound exception
        if (index < 0 || index >= actSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        return (E) myList[index];
    }


    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < actSize; i++) {
            System.out.print(myList[i] + " ");
        }
    }


    public static void main(String [] args){
        ImplementArrayList<String> myList = new ImplementArrayList<>();
        myList.add("apple");
        System.out.print(myList.size());
        myList.remove(1);

    }


}
