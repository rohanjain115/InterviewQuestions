import java.util.InputMismatchException;

/**
 * Created by rohanrampuria on 3/27/17.
 */
public class ReverseInteger {


    public static void main(String [] args){

        ReverseInteger ri = new ReverseInteger();
        ri.reverse(555557777);

    }


    public int reverse(int input){
        // flag marks whether integer is negative or positive

        boolean flag = false;
        if(input < 0){
            flag = true;
            input = 0 - input;
        }

        int result = 0;
        int temp = input;

        while(temp > 0){
            int mod = temp % 10;
            temp = temp/10;

            try{
                result = result*10 + mod;
            }catch(InputMismatchException exception){
                System.out.println("This is not an integer");
            }
        }

        if(flag){
            try{
                result = 0 - result;
            }catch(InputMismatchException exception){
                System.out.println("This is not an integer");
            }
        }

        return result;


    }
}
