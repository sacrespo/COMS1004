//*********************************
//Card.java
//by Sheryl Crespo
//szc2103
//*********************************

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the value
	private String suitName;
	private String valueName;

	//Constructor takes in two parameters
	//as ints representing suit and value 
	//of a Card object. 
	public Card(int s, int v)
	{
		suit = s; 
		value = v; 	
	}
	
	//This method returns an int to 
	//compare cards so they may be easily
	//sorted. Considers suit.  
	public int compareTo(Card c)
	{
		if (this.value < c.value)
		{
			return -1; 
		}
		else if (this.value > c.value)	
		{
			return 1; 
		}
		else 
		{
			if (this.suit != c.suit)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}	  
	}
	
	//This method simply compares values of cards
	//without taking suit into account. 	
	public int compareToValue(Card c) 
	{
		if(this.value < c.value)
		{
			return -1; 
		}
		else if (this.value > c.value) 
		{
			return 1; 
		}
		else
		{
			return 0;
		}
	}

	//This method simply compares the values of cards
	//without taking value into account. 
	public int compareToSuit(Card c)
	{
		if(this.suit != c.suit)
		{
			return -1; 
		}
		else
		{
			return 0; 
 		}
	}

	//This method returns a String
	//so as to easily print a Card
	//object. 
	public String toString()
	{	
		if (value == 1)
		{
			valueName = "ACE"; 
		}
		else if (value == 11)
		{
			valueName = "JACK";
		}
		else if (value == 12)
		{
			valueName = "QUEEN";
		}
		else if (value == 13)
		{
			valueName = "KING"; 
		}

		if (suit == 1) 
		{
			suitName = "HEARTS";
		}
		else if (suit == 2)
		{
			suitName = "CLUBS";
		}
		else if (suit == 3)
		{
			suitName = "SPADES";
		}
		else if (suit == 4) 
		{
			suitName = "DIAMONDS";
		} 
		
		if(value == 1 || value == 11 || value == 12 || value == 13)
		{
			return valueName + " of " + suitName;
		}	
		else
		{
			return this.value + " of " + suitName; 
		} 
	}

	//This is an accessor method to access
	//the private int representing a card's
	//suit. 	
	public int getSuit()
	{
		return suit; 
	}
	
	//This is an accessor method to access
	//the private int representing a card's
	//value. 
	public int getValue()
	{
		return value;
	}
}
