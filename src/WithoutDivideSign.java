/**
 * Created by rohanrampuria on 1/11/17.
 */
public class WithoutDivideSign {


    public static void main(String [] args){
        System.out.print(divide(4,2));

    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException(
                    "Division by 0 is undefined: " + a + "/" + b);
        }
        int sign = 1;
        if (a < 0) {
            a = -a;
            sign = -sign;
        }
        if (b < 0) {
            b = -b;
            sign = -sign;
        }
        double result = 0;
        while (a >= 0) {
            a -= b;
            result++;
        }
        return (result - 1) * sign;
    }
}
