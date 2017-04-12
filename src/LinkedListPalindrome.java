/**
 * Created by rohanrampuria on 1/11/17.
 */
public class LinkedListPalindrome {

    public static class ListNode{
        private int val;
        private ListNode next;

        ListNode(int val){
            this.val = val;
            this.next=null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        ListNode p = head;
        ListNode prev = new ListNode(head.val);

        while(p.next != null){
            ListNode temp = new ListNode(p.next.val);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while(p1!=null){
            if(p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }


    public static void main(String [] args){
        ListNode first = new ListNode(4);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(3);

        first.next=second;
        second.next=third;
        //third.next = first;  <--- This makes in circular linkedList

        LinkedListPalindrome p = new LinkedListPalindrome();
        boolean value = p.isPalindrome(first);
        System.out.print(value);


    }
}
