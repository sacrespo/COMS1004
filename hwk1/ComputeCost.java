//********************************
//ComputeCost
//written by Sheryl Crespo
//Computes the total cost over $1000 of several items (based on cost/quantity).
//********************************

import java.util.Scanner;
public class ComputeCost
{
    public static void main(String[]args)
    {

        Scanner input = new Scanner(System.in);
        double cost = 0; 
        double price;
        int quantity;
        
        //Asks for user input of an item's price and quantity; adds this to total cost. 
	//Stops asking for input when the cost is greater than $1000. 
        while(cost<=1000)
	{
             System.out.println("Enter the price of the item: ");
             price = input.nextDouble();
             System.out.println("Enter the quantity of the item: ");
             quantity = input.nextInt();
             cost = cost + (price*quantity);
        }

	//Adds 6% tax to the total cost of all items. 
        cost = (cost*.06) + cost; 
        System.out.println("Total cost is: " + cost); 
    }
}
