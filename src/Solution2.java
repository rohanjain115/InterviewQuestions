/**
 * Created by rohanrampuria on 2/9/17.
 */
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution2 {
    public static void main(String [] args){

        Solution2 s = new Solution2();
        System.out.print(s.solution(2134567,234));
    }
    public int solution(int a, int b) {
        if ((a < 0 || a > 100000000) || ((b < 0 || b > 100000000))) {
            return -1;
        }
        char[] arrayFirstNumber = String.valueOf(a).toCharArray();
        char[] arraySecondNumber = String.valueOf(b).toCharArray();
        String aux = "";
        for (int i = 0; i < arrayFirstNumber.length || i < arraySecondNumber.length; i++) {
            if (i < arrayFirstNumber.length) {
                aux += arrayFirstNumber[i];
            }
            if (i < arraySecondNumber.length) {
                aux += arraySecondNumber[i];
            }
        }
        Long result = Long.parseLong(aux);
        if (result > 100000000) {
            return -1;
        }
        return result.intValue();
    }
}