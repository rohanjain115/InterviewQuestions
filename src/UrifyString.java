/**
 * Created by rohanrampuria on 1/13/17.
 */
public class UrifyString {



    public static void main(String [] args){

        String input = "Mr John Smith";

        String newString = input.replace(" ","%20");
        System.out.print(newString);

        String s  =  new String("apple");
        s.intern();
        System.out.print(s);
    }
}
