package stackBasedQuestions;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rohanrampuria on 3/27/17.
 */
public class StackUsingObject<E> {
    private int size = 0;
    private static int INITIAL_SIZE = 10;
    private Object[] stackObject;

    public StackUsingObject(){
        stackObject = new Object[INITIAL_SIZE];
    }

    public void push(E ele){
        if(size == stackObject.length){
            ensureCapacity();
        }
        stackObject[size++] = ele;
    }

    public  E pop(){
        E e = (E) stackObject[--size];
        stackObject[size] = null;
        return e;
    }

    private void ensureCapacity() {
        stackObject = Arrays.copyOf(stackObject, stackObject.length*2);
    }

    @Test
    public void TestCase(){
        StackUsingObject<Integer> stack = new StackUsingObject<>();
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(1);
        stack.push(9);

        assertTrue(9 == stack.pop());
        assertTrue(1 == stack.pop());
        assertTrue(4 == stack.pop());
        assertTrue(5 == stack.pop());
    }

}
