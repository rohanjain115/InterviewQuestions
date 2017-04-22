package interestingProblems;

/**
 * Created by rohanrampuria on 4/21/17.
 */
import java.util.Random;
import java.util.Scanner;


public class CowsAndBulls {
    private int SizeOfWord = 4;


    public void displayRules(){
        System.out.println("I am thinking of a 4 letter word. Try to guess it.\n" +
                "I will give you clues for each guess you make:\n" +
                "Cows: You have guessed the correct letter, but not in the correct location in the word.\n" +
                "Bulls: You have guessed the correct letter and it's the correct location in the word.\n" +
                "You will win by guessing all 4 letters in the correct locations.");
    }

    public void initialize(String [] stringArray){
        stringArray[0]= "MANY";
        stringArray[1]= "ARMY";
        stringArray[2]= "ARMS";
        stringArray[3]= "TILL";
        stringArray[4]= "TASK";
        stringArray[5]= "SHOP";
        stringArray[6]= "ROPE";
        stringArray[7]= "PORE";
        stringArray[8]= "NOPE";
        stringArray[9]= "KITE";
        stringArray[10]= "FLAG";
        stringArray[11]= "GOAT";
        stringArray[12]= "EAST";
        stringArray[13]= "WEST";
        stringArray[14]= "YOLK";
    }

    public int countBulls(char [] hostArray, char [] wordArray){
        int bulls =0;

        for(int i=0; i< SizeOfWord; i++){
            if(hostArray[i] == wordArray[i]){
                hostArray[i] = 'x';
                wordArray[i] = 'o';
                bulls++;
            }
        }
        return bulls;
    }

    public int countCows(char [] hostArray, char [] wordArray){
        int cows=0;
        for(int i=0; i<hostArray.length; i++){
            if(hostArray[i] == 'x'){
                continue;
            }
            for(int j=0; j<wordArray.length; j++){
                if(wordArray[j] == 'o'){
                    continue;
                }
                if(hostArray[i] == wordArray[j]){
                    hostArray[i] = 'x';
                    wordArray[j] = 'o';
                    cows++;
                }
            }
        }
        return cows;
    }


    public static void main(String [] args){
        CowsAndBulls cb = new CowsAndBulls();
        String [] stringArray = new String[15];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int cows =0;
        int bulls =0;


        int  n = rand.nextInt(14) + 0;
        // initialize string array with words
        cb.initialize(stringArray);

        // Rules
        cb.displayRules();
        String hostWord = stringArray[n];

        while(true){

            System.out.print("Enter a word: ");
            String word = sc.nextLine().toUpperCase();

            char [] hostWordArray = hostWord.toCharArray();
            char [] wordArray = word.toCharArray();
            bulls = cb.countBulls(hostWordArray,wordArray);
            cows = cb.countCows(hostWordArray,wordArray);

            if(bulls == 4){
                System.out.println("4 bulls! The word was "+hostWord);
                break;
            }
            else{
                System.out.println("cows: "+cows+" bulls: "+bulls+". Try Again");
            }
        }

    }
}
