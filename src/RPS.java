import java.util.Random;
import java.util.Scanner;

// global result
enum RESULT{ WIN,LOOSE,TIE}


public class RPS
{
    // scanner for user input
    public static Scanner sc=new Scanner(System.in);

    // static final for rock, paper and scissors and result
    public static final int ROCK=1;
    public static final int PAPER=2;
    public static final int SCISSORS=3;
    public static RESULT result;

    public static void main(String[] args)
    {
        // user input to play game
        String answer="N";
        System.out.println("Do you want to play ROCK PAPER SCISSORSs game? Y/N");
        answer=sc.next();
        if(answer.equals("Y")){
            play();
        }else{
            System.exit(0);
        }
    }

    // method to play the game
    public static void play()
    {
        int userWin=0; // user win count
        int computerWin=0; // computer win count
        Random rnd = new Random(); // random class to generate random number

        do{
            int input;
            System.out.println("Pick 1,2, or 3 for : \n ROCK (1), PAPER(2), or SCISSORS (3)");
            input=sc.nextInt();

            //generating the random number between 1-3
            int randomNumber = rnd.nextInt(3 - 1 + 1) + 1;

            if (randomNumber == ROCK) {
                if (input == ROCK) {
                    System.out.println("ROCK beats ROCK");
                    result=RESULT.TIE;
                } else if (input == PAPER) {
                    System.out.println("PAPER beats ROCK");
                    result=RESULT.WIN;
                    userWin++;
                } else if (input == SCISSORS) {
                    System.out.println("ROCK beats SCISSORS");
                    computerWin++;
                    result=RESULT.LOOSE;
                }
            } else if (randomNumber == PAPER) {
                if (input == ROCK) {
                    System.out.println("PAPER beats ROCK");
                    result=RESULT.LOOSE;
                    computerWin++;
                } else if (input == PAPER) {
                    System.out.println("PAPER beats PAPER");
                    result=RESULT.TIE;
                } else if (input == SCISSORS) {
                    System.out.println("SCISSORS beats PAPER");
                    result=RESULT.WIN;
                    userWin++;
                }

            } else if (randomNumber == SCISSORS) {
                if (input == ROCK) {
                    System.out.println("ROCK beats SCISSORS");
                    result=RESULT.WIN;
                    userWin++;
                } else if (input == PAPER) {
                    System.out.println("SCISSORS beats PAPER");
                    result=RESULT.LOOSE;
                    computerWin++;
                } else if (input == SCISSORS) {
                    System.out.println("SCISSORS beats SCISSORS");
                    result=RESULT.TIE;
                }
            }
            System.out.println("You "+result+" this round");

            // this loop will exit when user or computer win the game atleast 2 times
        }while(userWin<2 && computerWin<2);

        // once the user wins 2 games, result will display
        if(userWin==2)
        {
            System.out.println("You win the game");
        }else{
            System.out.println("Computer wins the game");
        }
    }

}
