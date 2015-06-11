//*******************************
//Player.java
//by Sheryl Crespo
//szc2103
//*******************************


import java.util.Scanner; 
import java.util.ArrayList;
 
public class Player {
	
	private Scanner input = new Scanner(System.in); 	
	private Deck cardDeck = new Deck();		
	private ArrayList<Card> hand; // the player's cards 
	private int response;
	
	//This constructor creates a new Player
	//by filling a Player's hand with 5 cards
	//then allowing the Player to switch cards. 
	public Player()
	{		
		hand = new ArrayList<Card>();
		for(int i = 0; i<5; i++)
		{
			addCard(cardDeck.deal());
				
		}	
		displayHand(); 	
		changeHand(); 
	}

	//This method adds the card c to 
	//the player's hand. 
	public void addCard(Card c)
	{
		hand.add(c);
	}

	//This method removes the card c from
	//the player's hand. 
	public void removeCard(Card c)
	{
		hand.remove(c); 
	}
		
	//This method allows players to replace 
	//one, none, or all of their cards. 
	private void changeHand()
	{
		for(int i = 0; i<5; i++) 
		{
			System.out.print("Do you wish to replace " + hand.get(i) + "? 1(yes), 2(no) ");
			response = input.nextInt(); 
			if(response == 1)
			{ 
				hand.set(i,cardDeck.deal());
			} 
			displayHand(); 
		}				 
	}
	
	//This method prints a player's hand
	//so that a player may see what cards
	//he has.  
	public void displayHand()
	{
		for(int x=0; x<5; x++) 
		{
			System.out.println(hand.get(x));
		}
	}

	//This method allows access to the 
	//private ArrayList of cards a player has. 
	public ArrayList<Card> accessHand()
	{
		return hand; 
	}
}


