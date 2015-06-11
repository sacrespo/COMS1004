//**************************
//Deck.java
//by Sheryl Crespo
//szc2103
//**************************

import java.util.Random; 

public class Deck {
	
	private Card[] theDeck = new Card[52];
	private int top = 52; // the index of the top of the deck
	
	//This constructor creates a deck of cards
	//by filling the array of cards, theDeck, 
	//then shuffling the cards. 
	public Deck()
	{	
		int index = 0;
			for(int i = 1; i<=4; i++)
			{
				for(int j = 1; j <=13; j++) 
				{
					theDeck[index] = new Card(i,j);
					index ++;
				}
			}
		shuffle();
	}
	
	//This method shuffles the deck of cards
	//by reordering them randomly. 
	public void shuffle()
	{
		int index; 
		Card temp; 
		Random random = new Random(); 
		
		for(int i = 0; i < 52; i++) 
		{
			index = random.nextInt(52);
			temp = theDeck[i]; 
			theDeck[i] = theDeck[index];
			theDeck[index] = temp; 
		}
	}
	
	//This method returns the card at
	//the top of the deck. 
	public Card deal()
	{
		top --;
		return theDeck[top]; 
	}
}
