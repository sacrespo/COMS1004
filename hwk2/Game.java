//*********************************************
//Game.java
//Written by Sheryl Crespo
//szc2103
//*********************************************

//=============================================
//Objects of this class simulate the game 
//in the Monty Hall problem, having a 
//player choose a door with a random goat
//or prize inside, then having a host pick
//from the remaining two, then determining 
//what it would take for a player to win the
//prize: switching, or staying with their door.
//==============================================

import java.util.Random;

public class Game
{
    private boolean door1, door2, door3, playerDoor;
   
    private double strategy1;    //Represents number of times player
                                 //does not switch and wins. 
    private double strategy2;    //Represents number of times player
                                 //switches to win.  

    //This constructor has no parameters: it
    //initializes the two strategy counters with 0. 
    public Game() 
    {
        strategy1 = 0; 
        strategy2 = 0; 
    }
    
    //This method randomizes the location of the car
    //behind one of the three doors. The true value
    //indicates the presence of a car. 
    private void shuffleDoors()
    {   
        int shuffle = (int)(Math.random()*3+1);
        if (shuffle == 1)
        {
            door1 = true; 
            door2 = false;
            door3 = false; 
        }
        else if (shuffle == 2)
        {
            door1 = false; 
            door2 = true; 
            door3 = false; 
        } 
        else if (shuffle == 3) 
        {
            door1 = false; 
            door2 = false; 
            door3 = true; 
        } 
     } 

     //This method is the method you call on your
     //Game object in order to shuffle the doors, 
     //then have the player randomly select a door. 
     //This method also tests to see if the player
     //can stay with their door and win, or if they
     //must switch to win.
     public void playGame() 
     {
         shuffleDoors();
 
         int playerChoice = (int)(Math.random()*3+1);
         
         if (playerChoice == 1)
         {
             playerDoor = door1;
             if (playerDoor == true)
             { 
                 strategy1 ++;       
             }
             else
             { 
                 strategy2 ++; 
             }            
         }
         else if (playerChoice == 2) 
         {
             playerDoor = door2; 
             if (playerDoor == true)
             {
                 strategy1 ++; 
             } 
             else
             {
                 strategy2 ++; 
             }
         } 
         else if (playerChoice == 3) 
         { 
             playerDoor = door3; 
             if(playerDoor == true) 
             {
                 strategy1 ++; 
             }
             else
             {
                 strategy2 ++; 
             }        
         }
     }     
     
     //This is an accessor method for the IV strategy1. 
     public double getNoSwitch()
     {
         return strategy1;  
     }
     
     //This is an accessor method for the IV strategy2. 
     public double getSwitch()
     {
         return strategy2;
     }
} 
         
         
     
    
