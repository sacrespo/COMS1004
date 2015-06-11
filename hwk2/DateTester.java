//**********************************
//DateTester.java
//Written by Sheryl Crespo
//szc2103
//
//This program tests the Date class.
//**********************************

import java.util.Scanner;

public class DateTester 
{
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       
       //Asks users for integer input of a month.  
       System.out.println("Please enter a month: ");  
       int myMonth = input.nextInt(); 

       //Asks users for integer input of a day.
       System.out.println("Please enter a day: ");
       int myDay = input.nextInt(); 
       
       //Creates a new Date using the month and day. 
       //Prints what season the month/day are in. 
       Date myDate = new Date(myMonth, myDay);
       System.out.println(myMonth + "/" + myDay + " is in the " + myDate.getSeason()); 
    } 
}
