package stackBasedQuestions;

/**
 * Created by rohanrampuria on 3/27/17.
 */


class Element{
    public int val;
    public int min;
    public Element next;

    public Element(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
public class MinStack<Integer> {
    private Element top;


    public MinStack(){

    }
    public void push(int x){
        if(top == null){
            top = new Element(x,x);
        }
        else{
            Element e = new Element(x,Math.min(x, top.min));
            e.next = top;
            top = e;
        }
    }

    public int pop(){
        if(top == null){
            System.out.print("Stack is empty.");
        }
        Element temp = top.next;
        int value = top.val;
        top.next =null;
        top = temp;
        return value;
    }

    public int top(){
        if(top == null){
            System.out.print("Stack is empty.");
        }
        return top.val;
    }

    public int min(){
        if(top == null){
            System.out.print("Stack is empty.");
        }
        return top.min;

    }


    public static void main(String args []){
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());

    }




}
