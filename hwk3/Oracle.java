//***************************************
// Oracle.java
// Written by Sheryl Crespo
// szc2103
//***************************************

//***************************************
//This class stores the computer's choice
//as a String and determines how many 
//bulls and cows any given guess would
//generate.
//***************************************

import java.util.Random;

public class Oracle
{
    
    private int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};    	
    private String solution;
    private int cows; 
    private int bulls; 
    private boolean duplicate;

    //This constructor calls generateSolution()
    //to create the computer's number.
    public Oracle()
    {
        generateSolution();
    }
    
    //Turns the strings into character arrays
    //and changes the values of certain chars
    //so as to keep track of what matches 
    //were previously already bulls. 
    //Returns the int of number of bulls.
    public int getBulls(String guess)
    {
	bulls = 0; 
	char[] sChar = solution.toCharArray();
	char[] gChar = guess.toCharArray();
	for(int i =0; i<4; i++)
	{
	    if(solution.charAt(i) == guess.charAt(i))
	    {
		sChar[i] = '!';
		gChar[i] = '#'; 
		bulls ++;
	    }
	}
	for(int i=0; i<4; i++)
	{
	    for(int j=0; j<4; j++)
	    {
		if(sChar[i] == gChar[j])
		{
		    sChar[i] = '!';
		    gChar[j] = '#';
		    cows ++;
		}
	    }
	}  
	return bulls;
    }

    //This public method obtains the number 
    //of cows while considering which 
    //matches are already bulls. 
    //Returns int number of cows. 
    public int getCows(String guess)
    {
	bulls = 0; 
	cows = 0; 
	char[] sChar = solution.toCharArray(); 
	char[] gChar = guess.toCharArray();
	
	for(int i=0; i<4; i++)
	{
	    if(solution.charAt(i) == guess.charAt(i))
	    {
		sChar[i] = '!';
		gChar[i] = '#';
		bulls++;
	    }
	}
	for(int i=0; i<4; i++)
	{
	    for(int j=0; j<4; j++)
	    {
		if(sChar[i] == gChar[j])
		{
		    sChar[i] = '!';
		    gChar[j] = '#';
		    cows ++;
		}
	    }
	}
	return cows;
    }

    //This private method generates a
    //four digit random number for the
    //computer by shuffling the array of
    //available digits in the array digits
    //and taking the first four of those 
    //digits and concantenating them. 
    private void generateSolution() 
    {
	int index, temp;
	Random random = new Random();		

	for(int i = digits.length -1; i>0; i--)
	{
	    index = random.nextInt(i+1);
	    temp = digits[index];
	    digits[index] = digits[i]; 
	    digits[i] = temp;
	}

	solution = ""; 
	for(int j = 0; j<4; j++)
	{
	    solution += Integer.toString(digits[j]); 
	}
    }
}
