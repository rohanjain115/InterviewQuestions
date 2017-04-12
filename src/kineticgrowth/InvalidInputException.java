package kineticgrowth;

/**
 * Created by rohanrampuria on 3/20/17.
 *
 * Exception class for invalid input.
 */

public class InvalidInputException extends Exception {
    public  InvalidInputException(){
        System.err.println("Invalid size, input array must be of size 2 or more");
    }
}
