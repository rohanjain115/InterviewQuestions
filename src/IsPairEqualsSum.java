import java.util.HashSet;

/**
 * Created by rohanrampuria on 1/11/17.
 *
 * This question was asked in google interview (youtube: https://www.youtube.com/watch?v=XKu_SEDAykw)
 *
 */
public class IsPairEqualsSum {

    public static void main(String [] args){
        int [] value = {0,8};
        int sum = 8;
        boolean val = isPairEqualsSum(value,sum);
        System.out.println(val);
    }

    private static boolean isPairEqualsSum(int[] value, int sum) {

        HashSet<Integer> comp = new HashSet<>();
        for(int i=0;i<value.length;i++){

            if(comp.contains(value[i])){
                return true;
            }
            comp.add(sum-value[i]);

        }
        return false;
    }


}
