/**
 * Created by rohanrampuria on 4/10/17.
 *
 * Check whether linkedlist has cycles or not
 */
class NodeL{
    int data;
    NodeL next;
    public NodeL(int data){
        this.data = data;
        this.next = null;
    }
}
public class CircularLinkedList{

    public static void main(String [] args){
        NodeL node = new NodeL(5);
        node.next = new NodeL(6);
        node.next.next = new NodeL(7);
        node.next.next.next = new NodeL(4);
        node.next.next.next.next = new NodeL(2);
        System.out.print(hasCycle(node));
    }


    public static boolean hasCycle(NodeL head){
        if(head == null){
            return false;
        }
        NodeL fast = head.next;
        NodeL slow = head;

        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
