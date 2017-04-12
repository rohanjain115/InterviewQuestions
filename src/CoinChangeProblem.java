import java.util.HashMap;

/**
 * Created by rohanrampuria on 4/10/17.
 *
 * Number of ways to get change
 */
public class CoinChangeProblem {


    public static void main(String [] args){
        int [] coins ={25,10,5,1};
        int money = 100;
        System.out.print(makeChange(money,coins));
    }

    public static long makeChange(int money, int [] coins){
       return makeChange(money,coins,0, new HashMap<String,Long>());
    }

    public static long makeChange(int money, int [] coins, int index, HashMap<String, Long>memo){
        if(money == 0){
            return 1;
        }
        if(index >= coins.length){
            return 0;
        }

        String key = money + "-" + index;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int amountWithCoins =0;
        long ways =0;
        while (amountWithCoins <= money){
            int remaining = money -amountWithCoins;
            ways+= makeChange(remaining,coins, index+1, memo);
            amountWithCoins+= coins[index];
        }
        memo.put(key,ways);
        return ways;

    }
}
