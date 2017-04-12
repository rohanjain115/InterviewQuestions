package dynamicprogramming;

/**
 * Created by rohanrampuria on 3/17/17.
 */
public class InvalidInputException extends Exception {
    public  InvalidInputException(){
        System.err.println("Invalid size, input array must be of size 2 or more");
    }
}
