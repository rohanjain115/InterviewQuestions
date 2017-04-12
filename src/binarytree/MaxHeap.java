package binarytree;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by rohanrampuria on 4/10/17.
 */
public class MaxHeap<T extends Comparable<T>> {

    private ArrayList<T> items;

    public MaxHeap(){
        items = new ArrayList<T>();
    }

    private void siftUp(){
        int k= items.size() -1;
        while(k>0){
            int p = (k-1)/2;
            T item = items.get(k);
            T parent = items.get(p);

            if(item.compareTo(parent) > 0){
                //swap

                items.set(p,item);
                items.set(k,parent);
                k =p;
            }
            else{
                break;
            }

        }
    }
    private void siftDown(){
        int k =0;
        int l = (2*k) + 1;
        while(l < items.size()){
            int max =l; int r = l+1;
            if(r < items.size()){ // there is a right child
                if(items.get(r).compareTo(items.get(l)) > 0){
                    max++;
                }
            }
            if(items.get(max).compareTo(items.get(k)) > 0){
                //switch
                T temp = items.get(k);
                items.set(k,items.get(max));
                items.set(max,temp);
                k = max;
                l = (2*k) + 1;
            }
            else {
                break;
            }

        }
    }


    public void insert(T item){
        items.add(item);
        siftUp();
    }
    public T delete(){
        if(items.size() == 0){
            throw  new NoSuchElementException();
        }
        if(items.size() == 1){
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0,items.remove(items.size()-1));
        siftDown();
        return hold;
    }
    public String toString(){
        return items.toString();
    }

}
