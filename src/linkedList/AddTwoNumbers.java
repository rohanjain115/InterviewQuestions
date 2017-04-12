package linkedList;

/**
 * Created by rohanrampuria on 4/12/17.
 */
public class AddTwoNumbers {
    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node addTwoList(Node first, Node second){
        Node res = null;
        Node temp = null;
        Node prev = null;
        int carry = 0;
        int sum =0;

        while(first != null || second != null){
                sum = carry + (first != null ?first.data:0 )+
                        (second != null?second.data:0);
                carry = (sum>=10)?1:0;
                sum = sum%10;

                temp = new Node(sum);

                if(res == null){
                    res = temp;

                }else{
                    prev.next = temp;
                }
                prev = temp;

                if(first !=null){
                    first = first.next;
                }
                if(second != null){
                    second = second.next;
                }
        }
        if(carry >0){
            temp.next = new Node(carry);
        }

        return res;
    }

    public static void main(String[] args) {
        AddTwoNumbers list = new AddTwoNumbers();

        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = list.addTwoList(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

}
