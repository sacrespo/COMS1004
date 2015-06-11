//**********************************************
// Game.java
// Written by Sheryl Crespo
// szc2103
//**********************************************

//**********************************************
//This class asks the player for their
//guess and tells the player how many
//bulls and cows they got.
//**********************************************
 
import java.util.Scanner;

public class Game{

    private int turns;
    private Oracle computer;
    private Scanner input;
    private String guess;
    private int again;
    private int best; 
    private int worst; 
    private double average; 
    private int gamesPlayed = 1;
    private int[] gameResults;

    //This constructor creates an int array
    //using the number of gamesPlayed. It 
    //creates a new Scanner and new Oracle. 
    public Game()
    {
	gameResults = new int[gamesPlayed];
	input = new Scanner(System.in);
	computer = new Oracle();
    }


    //This public method determines when the  
    //player has won the game, if the player
    //wants to play the game again, and 
    //keeps track of player stats.  
    public void play()
    {
	turns = 1;

	System.out.println("Welcome to Bulls and Cows!"); 
	System.out.print("Please try to guess the computer's four-digit number: "); 
	guess = input.nextLine(); 

	while(computer.getBulls(guess) != 4) 
	{
	    System.out.println("Bulls: " + computer.getBulls(guess)); 
	    System.out.println("Cows: " + computer.getCows(guess)); 
	    System.out.print("Please guess again: ");
	    guess = input.nextLine();
	    turns ++;  
	}
	
	System.out.println("****YOU WON!****");

	for(int i=gamesPlayed-1; i<gamesPlayed; i++)
	{
	    gameResults[i] = turns;
	}
	
	System.out.print("Play again? 1 for yes, 2 for no: ");
	again = input.nextInt(); 
	
	if(again == 1) 
	{
	    gamesPlayed ++; 
	    play(); 
	}
	else 
	{
	    System.out.println("Thank you for playing!"); 
	    System.out.println("Best Round: " + findBest()); 
	    System.out.println("Worst Round: " + findWorst());
	    System.out.println("Average: " + findAverage());    
	}
    }

    //This private method returns the best 
    //round the player played by finding the
    //lowest number of turns in the array of
    //gameResults.
    private int findBest() 
    {
        best = gameResults[0];
	for(int i=0; i<gameResults.length; i++)
	{
	    if(gameResults[i]<best)
	    {
	        best = gameResults[i];
	    }
	}
	
	return best;	
    }

    //This private method returns an int
    //of the highest number of turns from 
    //the array of gameResults. 
    private int findWorst()
    {
	worst = gameResults[0];
	for(int i=0; i<gameResults.length; i++)
	{
	    if(gameResults[i]>worst)
	    {
		worst = gameResults[i];
	    }
	}
	
	return worst;
    }
 
    //This method finds the average of the
    //values in gameResults and tells the 
    //player what their average number of 
    //turns was over the number of rounds 
    //they chose to play. 
    private double findAverage()
    {
	int sum = 0;
	for(int i=0; i<gameResults.length; i++)
	{
	    sum += gameResults[i];
	}
	
	average = sum/(gameResults.length); 
	return average; 
    }  
}
