/**
 * Created by rohanrampuria on 2/7/17.
 */



public class ComparingNumbers {


    public static void main(String [] args){
        int i = 0;
        double a=0,b=0;
        try{
             a = Double.parseDouble(args[0]);
             b = Double.parseDouble(args[1]);
            i = compare(a,b);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }

        if(i == 1){
            System.out.print("First Number "+a+" is greater than Second number"+b);
        }
        else if(i == 0){
            System.out.print("First Number is equal to Second number" );
        }
        else{
            System.out.print("Second Number is greater than First number" );
        }
    }


    public static int compare(Number n1, Number n2) {
        long l1 = n1.longValue();
        long l2 = n2.longValue();
        if (l1 != l2)
            return (l1 < l2 ? -1 : 1);
        return Double.compare(n1.doubleValue(), n2.doubleValue());
    }
}

