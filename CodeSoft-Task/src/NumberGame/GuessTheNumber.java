package NumberGame;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static int guessNumber() {
		
		Random random=new Random();
		Scanner s=new Scanner(System.in);
		
		int randomNum=random.nextInt(100)+1;
		
		int Chance=0;
		int totChances=10;
		
		while(Chance<totChances){
			Chance++;
			System.out.println("Chance ::"+Chance+"/"+totChances+"\nGuess Number Between 1 and 100 :: ");
			int guess=s.nextInt();
			if(guess==randomNum) {
				System.out.println("Correct Guess..! "+Chance+"/"+totChances+" In Chances");
				return Chance;
			}else if(guess<randomNum){
				System.out.println("Too Low !..Try Again...");
			}else {
				System.out.println("Too High !..Try Again...");
			}
		}
		System.out.println("Sorry you used all you "+totChances+" Chances The Correct Answer Was :: "+randomNum);
		return -1;
	}
	public static void playGame() {
		
		int totalScore=0;
		int totalrounds=0;
		Scanner s=new Scanner(System.in);
		
		while(true) {
			System.out.println("\n===New Round=== ");
			int totalChancesTankan=guessNumber();
			
			if(totalChancesTankan !=-1) {
				totalrounds++;
				
				totalScore +=Math.max(1,11-totalChancesTankan);
			}
			System.out.println("Do you want to play again(yes/no).");
			String newgame=s.next();
			
			if(!newgame.equalsIgnoreCase("yes")) {
				break;
			}
		}
		System.out.println("Game over..! you have played "+totalrounds+" rounds and ur's score is ::"+totalScore);
	}
	public static void main(String[] args) {
		playGame();
	}
}
