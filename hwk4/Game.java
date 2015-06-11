//**************************
//Game.java
//by Sheryl Crespo
//szc2103
//**************************

import java.util.ArrayList; 
import java.util.Scanner;

public class Game 
{
	
	private Player p;
	private Deck cards;	
	private String result; 
	private int tokens;
	private Scanner input = new Scanner(System.in);  
	private int response; 

	public Game(String[] testHand)
	{	 	
	}
	
	//This is a constructor so that a player
	//can play a normal round of poker, starting
	//off with 50 tokens. 
	public Game()
	{
		System.out.println("Welcome to poker! You have 50 tokens to spend."); 
		tokens = 50;
	}
	
	//This method allows a player to continue playing
	//poker so long as they respond that they want to
	//and have enough tokens to do so. 
	public void play()
	{
		response =1; 
		while(response == 1 && tokens != 0) 
		{
			tokens --; 
			p = new Player(); 
			checkHand(p.accessHand()); 
			System.out.println("You got a " + checkHand(p.accessHand()) + ".");
			System.out.println("You now have " + tokens + " tokens.");
			System.out.print("Play again? 1 yes, 2 no.");
			response = input.nextInt();
		} 		  		
	}
	
	//This method returns a String telling players
	//what their hand is. It alters the number of tokens
	//according to the result of the hand. 
	public String checkHand(ArrayList<Card> hand)
	{	
		if(isStraight(hand))
		{	
			tokens += 4; 
			return "STRAIGHT"; 
		}
		else if(isFlush(hand))
		{
			tokens += 5; 
			return "FLUSH"; 
		}
		else if(isFourOfAKind(hand))
		{
			tokens += 25; 
			return "FOUR OF A KIND"; 
		}
		else if(isThreeOfAKind(hand))
		{	
			tokens += 3; 
			return "THREE OF A KIND"; 
		}
		else if(isFullHouse(hand))
		{
			tokens += 6;
			return "FULL HOUSE"; 
		}
		else if(isTwoPair(hand))
		{
			tokens += 2;
			return "TWO PAIRS"; 
		}
		else if(isPair(hand))
		{
			tokens += 1; 
			return "ONE PAIR"; 
		}
		else if(isStraightFlush(hand))
		{
			tokens += 50; 
			return "STRAIGHT FLUSH"; 
		}
		else if(isRoyalFlush(hand))
		{
			tokens += 250;
			return "ROYAL FLUSH"; 
		}
		else
		{
			return "NO PAIR"; 
		}		
	}
	
	//This method sorts a player's hand by the
	//cards' types of suits. 
	public void sortBySuit(ArrayList<Card> h)
	{
		int min = 0; 
		int i; 
		
		for(i=0; i<5; i++)
		{
			min = i; 
			for(int j=i+1; j<5; j++)
			{
				if(h.get(j).compareToSuit(h.get(min)) < 0)
				{
					min = j; 
				}
			}
		Card temp = h.get(i);
		h.set(i, h.get(min));
		h.set(min, temp);
		} 
	} 	

	//This method sorts the cards in a player's hand
	//based on the value of the player's cards. 
	public void sortByValue(ArrayList<Card> h)
	{
		int min = 0; 
		int i;
		
		for(i=0; i<5; i++)
		{
			min = i;
			for(int j=i+1; j<5; j++)
			{
				if(h.get(j).compareToValue(h.get(min)) <0)
				{
					min = j;
				}
			}
		Card temp = h.get(i);
		h.set(i, h.get(min));
		h.set(min, temp);
		}
	} 

	//This method tests to see if a player has a 
	//straight; five cards with consecutive 
	//values, not necessarily from the same suit. 
	public boolean isStraight(ArrayList<Card> h) 
	{
		int i; 
		int v; 
		
		sortByValue(h); 
		
		v = h.get(0).getValue() + 1; 
		for(i=1; i<5; i++) 
		{
			if(h.get(i).getValue() != v) 
			{
				return false; 
			}
			v++; 
		}
		
		return true; 
	}
	
	//This tests a player's hand for a flush;
	//five cards, not necessarily in order, of
	//the same suit. 
	public boolean isFlush(ArrayList<Card> h)
	{
		for(int i=0; i<5; i++)
		{	
			for(int j=i+1; j<5; j++) 
			{		
				if(h.get(i).compareToSuit(h.get(j))!=0) 
				{
					return false; 
				}
			}
		}
		return true;
	}

	//This tests a player's hand for a pair; 
	//two cards of the same value. 
	public boolean isPair(ArrayList<Card> h)
	{
		int sameValue = 0; 
		for(int i=0; i<5; i++)
		{
			for(int j=i+1; j<5; j++)
			{
				if(h.get(i).compareToValue(h.get(j)) == 0)
				{
					return true;
				}
			}	
		}
		return false; 
	}
	
	//This tests a player's hand for four
	//cards of the same value. 
	public boolean isFourOfAKind(ArrayList<Card> h)
	{
		int sameValue = 0;
		for(int i=0; i<5; i++)
		{
			for(int j=i+1; j<5; j++)
			{
				
				if(h.get(i).compareToValue(h.get(j)) == 0)
				{
					sameValue++;
				}
				if(sameValue == 4) 
				{
					return true; 
				}
			}
		} 
		return false;
	} 
	
	//This tests a player's hand for three
	//cards of the same value. 
	public boolean isThreeOfAKind(ArrayList<Card> h)
	{
		int sameValue = 0; 
		for(int i=0; i<5; i++)
		{
			for(int j=i+1; j<5; j++)
			{	
				if(h.get(i).compareToValue(h.get(j)) == 0)
				{
					sameValue++;
				}
				if(sameValue == 3) 
				{
					return true;
				}
			} 
		} 
		return false;
	}
	
	//This tests a player's hand for a full house; 
	//three of a kind plus a pair. 
	public boolean isFullHouse(ArrayList<Card> h)
	{
		boolean check1, check2; 
		
		sortByValue(h); 
		check1 = ((h.get(0).compareToValue(h.get(1))== 0) && (h.get(1).compareToValue(h.get(2))== 0) && (h.get(3).compareToValue(h.get(4))== 0));
		check2 = ((h.get(0).compareToValue(h.get(1))== 0) && (h.get(2).compareToValue(h.get(3))== 0) && (h.get(3).compareToValue(h.get(4))== 0));   
		
		return (check1 || check2); 
	}
			
	//This tests a player's hand for two pairs.  
	public boolean isTwoPair(ArrayList<Card> h)
	{
		boolean check1, check2, check3; 
		
		if(isFourOfAKind(h) || isFullHouse(h) || isThreeOfAKind(h))
		{
			return false;
		}
		
		sortByValue(h);
		check1 = ((h.get(0).compareToValue(h.get(1))== 0) && (h.get(2).compareToValue(h.get(3))== 0));
		check2 = ((h.get(0).compareToValue(h.get(1))== 0) && (h.get(3).compareToValue(h.get(4))== 0)); 
		check3 = ((h.get(1).compareToValue(h.get(2))== 0) && (h.get(3).compareToValue(h.get(4))== 0)); 
 
		return (check1 || check2 || check3);		
	}		
	
	//This tests a player's hand for a straight flush;
	//five cards with consecutive values of the 
	//same suit. 
	public boolean isStraightFlush(ArrayList<Card> h) 
	{
		return (isStraight(h) && isFlush(h));
	}
	
	//This tests a player's hand for a royal flush;
	//the best possible hand in poker made of a 
	//10, jack, queen, king, and ace of the same suit. 
	public boolean isRoyalFlush(ArrayList<Card> h) 
	{
		boolean ten = false;
		boolean jack = false; 
		boolean queen = false; 
		boolean king = false;
		boolean ace = false; 
		
		if(isFlush(h))
		{
			for(int i=0; i<5; i++) 
			{
				if(h.get(i).getValue() == 10)
				{
					ten = true;
				}
				if(h.get(i).getValue() == 11) 
				{
					jack = true; 
				}
				if(h.get(i).getValue() == 12) 
				{
					queen = true;
				}
				if(h.get(i).getValue() == 13) 
				{
					king = true; 
				}
				if(h.get(i).getValue() == 1) 
				{
					ace = true; 
				}
			}	
		}
		return (ten && jack && queen &&king && ace); 
	}	
}	
