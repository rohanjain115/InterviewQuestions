import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * Created by rohanrampuria on 1/11/17.
 */
public class QueueWithTwoStacks<Item> {
    private Stack<Item> stack1;
    private Stack<Item> stack2;
    public QueueWithTwoStacks(){
        stack1 = new Stack<Item>();
        stack2 = new Stack<Item>();
    }

    public void enqueue(Item i){
        stack1.push(i);
    }

    public void movefromstack1tostack2(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public Item dequeue(){
        if(stack2.isEmpty() && !stack1.isEmpty()){
          movefromstack1tostack2();
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    // return the item least recently added to the queue.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) movefromstack1tostack2();
        return stack2.peek();
    }




    public static void main(String [] args){
        QueueWithTwoStacks<String> q = new QueueWithTwoStacks<>();
        q.enqueue("a");
        q.enqueue("b");
        System.out.print(q.peek());
        q.enqueue("c");
        q.dequeue();
        System.out.print(q.size());
    }
}
