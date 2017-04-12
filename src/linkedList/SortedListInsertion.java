package linkedList;

/**
 * Created by rohanrampuria on 4/11/17.
 */
public class SortedListInsertion {

    Node head;

     static class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
            next = null;
        }
    }

    public void insert(Node node){
         Node current;
         if(head == null || head.data >= node.data){
             node.next = head;
             head = node;
         }
         else{
             current = head;
             while (current.next != null && current.next.data < node.data){
                    current = current.next;
             }
             node.next = current.next;
             current.next = node;
         }
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }


    public static void main(String [] args){
        SortedListInsertion s = new SortedListInsertion();
        s.head = new Node(4);
        s.insert(new Node(10));
        s.insert(new Node(2));
        s.insert(new Node(1));
        s.insert(new Node(9));
        s.printList();
    }


}
