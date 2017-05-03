/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistproject;

import java.util.Iterator;

/**
 *
 * @author Rohan
 */
public class CircularDoublyLinkedList<Item> implements Iterable<Item>{

    // Code for a doubly-linked list
    private Node head;
    private Node last;
    private int size;

    private class Node {

        private Item item;
        private Node next;
        private Node prev;
    }

    public int size() {
        return size;
    }

    public Item get(int i) {
        if(i < 0){
            if(i < (-1*size)){
                throw new IndexOutOfBoundsException();
            }
            else{
                i = i + size;
            }
        }
        else{
            if(i >= size){
                throw new IndexOutOfBoundsException();
            }
        }
        Node ptr = head;
        for (int index = 0; index < i; index++) {  // place ptr at position i
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public boolean add(Item item) {
        Node ptr = new Node();
        ptr.item = item;
        if (head == null) //the list is empty
        {
            head = last = ptr; // head and last are the same Node
            head.prev = head;
            head.next = head;
            
        } else { // tmp is the last element
            last.next = ptr;
            ptr.prev = last;
            last = ptr;
            last.next = head;
            head.prev = last;
        } // end else
        size++; // increase the size
        return true;
    }
    
     public void add(int index, Item item) {
         
        if(index < 0){
            if(index < (-1*(size+1))){
                throw new IndexOutOfBoundsException();
            }
            else{
                index = index + size;
            }
        }
        else{
            if(index > size){
                throw new IndexOutOfBoundsException();
            }
        }
        Node ptr = new Node();
        ptr.item = item;
        if (index == 0) {// place the new Node at the head of the list
            if (size == 0) { // head = null
                head = last = ptr;
                head.prev = head;
                head.next = head;
            } else {
                head.prev = ptr;
                ptr.next = head;
                head = ptr;
                head.prev = last;
                last.next = head;
            }
        } else if (index == size) {
            last.next = ptr;
            ptr.prev = last;
            last = ptr;
            last.next = head;
        } else {
            Node tmp = head;

            for (int i = 0; i < index - 1; i++) {  // place ptr at position i- 1
                tmp = tmp.next;
            }
            // The next two statements inserts tmp between ptr and ptr.next
            Node x = tmp.next;
            x.prev = ptr;
            ptr.next = x;
            tmp.next = ptr;
            ptr.prev = tmp;
        }
        size++;
    }
     
     public boolean isEmpty(){
         return head == null;
     }
     
     public boolean contains(Item item){
         if(head == null){
             return false;
         }
         int count =0;
         Node current = head;
         while(count < size){
             if(current.item.equals(item)){
                 return true;
             }
             else{
                 current = current.next;
                 count++;
             }
         }
         return false;
     }
     
     
     public boolean remove(int index){
         if(index < 0){
            if(index < (-1*size)){
                throw new IndexOutOfBoundsException();
            }
            else{
                index = index + size;
            }
        }
        else{
            if(index >= size){
                throw new IndexOutOfBoundsException();
            }
        }
         
         
         
        if (index == 0) 
        {
            if (size == 1)
            {
                head = null;
                last = null;
                size = 0;
                return true; 
            }
            head = head.next;
            head.prev = last;
            last.next = head;
            size--; 
            return true;
        }
        if (index == size-1)
        {
            last = last.prev;
            last.next = head;
            head.prev = last;
            size-- ;
            return true;
        }
        Node ptr = head.next;
        for (int i = 1; i < size; i++)
        {
            if (i == index)
            {
                Node p = ptr.prev;
                Node n = ptr.next;

                p.next = n;
                n.prev = p;
                size-- ;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
     }
     
    public Iterator<Item> iterator() {

    return new Iterator<Item>() {

        private Node followingNode = head;
        private int count=0;

        @Override
        public boolean hasNext() {
            return count<size;
        }

        @Override
        public Item next() {
            Item toReturn = followingNode.item;
            followingNode = followingNode.next;
            count++;
            return toReturn;
        }
    };
}
     
    public void rotate(int numPositions){
        if(size == 0){
            throw new NullPointerException();
        }
        int count =0;
       if(numPositions > 0){
           while(count < (numPositions%size)){
            head = last;
            last = last.prev;
            count++;
        }
       }
       else if(numPositions == 0){
           return;
       }
       else{
           numPositions = Math.abs(numPositions);
             while(count < (numPositions%size)){              
                 last = head;
                 head = head.next;
                 
            count++;
        }
       }
        
    }
    
}