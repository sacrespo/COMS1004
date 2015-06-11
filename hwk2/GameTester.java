//*************************************
//GameTester.java
//Written by Sheryl Crespo
//szc2103
//
//This program runs the Game class
//multiple times so as to find the
//probabilty of winning by switching
//versus winning by not switching. 
//*************************************

public class GameTester
{
    public static void main(String[] args) 
    {
       double probNoSwitch;   //The probability the player wins without switching.
       double probSwitch;     //The probability the player wins with switching.
 
       Game gameTest = new Game(); 

        int counter = 1; 
        
        //Plays the Monty game 1000 times. 
        while (counter <= 1000)
        {
            gameTest.playGame();
            counter ++; 
	}
        
        //Computes the probabilities of wining without
        //and with switching. 
	probNoSwitch = gameTest.getNoSwitch()/1000; 
        probSwitch = gameTest.getSwitch()/1000; 
        
        //Prints the results of the Monty game simulation. 
	System.out.println("The probability when not switching doors is: " + probNoSwitch);
        System.out.println("The probability when switching doors is: " + probSwitch);
    }
}     
