//*******************************
//WordListsTester.java
//by Sheryl Crespo
//szc2103
//*******************************

//*******************************
//This class is a tester for 
//WordLists.java. It allows users
//to choose what parameters they
//want in order to create txt 
//files of words from the 
//Scrabble dictionary. 
//*******************************

import java.io.File; 
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException; 
import java.util.Scanner;

public class WordListsTester
{

	public static void main(String args[]) 
	{
		Scanner input = new Scanner(System.in); 
		int response = 1; 
		
		while(response != 0) 
		{
			System.out.println("==========SCRABBLE HELPER=========="); 
			System.out.println("Would you like to find: "); 
			System.out.println("Words of a certain length? Press 1"); 
			System.out.println("Words of a certain length starting with a letter? Press 2"); 
			System.out.println("Words of a certain length containing a letter? Press 3"); 
			System.out.println("Words of a certain length with several vowels? Press 4"); 
			System.out.println("Words with a certain number of a letter? Press 5"); 
			System.out.println("QUIT: Press 0"); 
			response = input.nextInt(); 
			
			if(response == 1)
			{
				try
				{
					WordLists w = new WordLists("dictionary.txt"); 
					System.out.print("How long of a word do you want?"); 
					int length = input.nextInt(); 
					String[] list = w.lengthN(length);  
					PrintWriter printWriter = new PrintWriter(new File("lengthList.txt"));
					
					for(int i=0; i<list.length; i++)
					{
						printWriter.println(list[i]); 
					}
					printWriter.close(); 
					System.out.println("The file lengthList.txt has been written."); 
					System.out.println("The file is located at " + System.getProperty("user dir")); 
				}
				catch(IOException ioe)
				{
					System.out.println("IOException"); 
				} 
				
				System.out.println("Run again? Yes, press 1. No, press 0.");
				response = input.nextInt(); 
			}

			if(response == 2) 
			{
				try
				{
					WordLists w = new WordLists("dictionary.txt");
					System.out.print("How long of a word do you want?"); 
					int length = input.nextInt(); 
					System.out.print("What letter should the words start with?"); 
					char letter = input.next(".").charAt(0);
					String[] list = w.startsWith(length,letter); 
					PrintWriter printWriter = new PrintWriter(new File("startsList.txt")); 
			
					for(int i=0; i<list.length; i++)
					{	
						printWriter.println(list[i]);
					}
				
					printWriter.close(); 
					System.out.println("The file startsList.txt has been written."); 
 			                System.out.println("The file is located at " + System.getProperty("user dir"));
				}
				catch(IOException ioe)
				{
					System.out.println("IOException");
				} 
				System.out.println("Run again? Yes, press 1. No, press 0.");
       		                response = input.nextInt();
			}
	
			if(response == 3)
			{
				try
				{
       		         	        WordLists w = new WordLists("dictionary.txt");
					System.out.print("How long of a word do you want?");
                        	        int length = input.nextInt();
                        	        System.out.print("What letter should the words contain?");
					char letter = input.next(".").charAt(0);         
                 			String[] list = w.containsLetter(length,letter);
                       			PrintWriter printWriter = new PrintWriter(new File("containsList.txt"));

                        		for(int i=0; i<list.length; i++)
                        		{
                        	        	printWriter.println(list[i]);
                        		}

                        		printWriter.close();
                               	 	System.out.println("The file containsList.txt has been written.");
                		}	
                		catch(IOException ioe)
                		{
                        		System.out.println("IOException");
                		}
				System.out.println("Run again? Yes, press 1. No, press 0.");
                 		System.out.println("The file is located at " + System.getProperty("user dir"));
                        	response = input.nextInt();
			}

			if(response == 4)
                	{	
				try
                		{
                        		WordLists w = new WordLists("dictionary.txt");
                               		System.out.print("How long of a word do you want?");
                                	int length = input.nextInt();
                                	System.out.print("How many vowels do you want?");
                                	int vowels = input.nextInt(); 
                        		String[] list = w.vowelHeavy(length,vowels);
                        		PrintWriter printWriter = new PrintWriter(new File("vowelList.txt"));

                  			for(int i=0; i<list.length; i++)
                        		{
                                		printWriter.println(list[i]);
                       			}

                        		printWriter.close();
                                	System.out.println("The file is located at " + System.getProperty("user dir"));
   					System.out.println("The file vowelList.txt has been written.");
                		}
                		catch(IOException ioe)
                		{
                        		System.out.println("IOException");
                		}
      				System.out.println("Run again? Yes, press 1. No, press 0.");
                        	response = input.nextInt();
			}
		
			if(response == 5)
			{
        	        	try
        	        	{
      		                  	WordLists w = new WordLists("dictionary.txt");
       		                        System.out.print("What letter are you looking for?");
       	                  		char letter = input.next(".").charAt(0);
                                	System.out.print("How many of this letter do you want?");
                                	int num = input.nextInt();
					String[] list = w.multiLetter(num,letter);
                        		PrintWriter printWriter = new PrintWriter(new File("multiList.txt"));

                        		for(int i=0; i<list.length; i++)
                        		{
                                		printWriter.println(list[i]);
                        		}

                        		printWriter.close();
                        		System.out.println("The file multiList.txt has been written.");
		               		System.out.println("The file is located at " + System.getProperty("user dir"));
        	      		}
                		catch(IOException ioe)
                		{
                        		System.out.println("IOException");
                		}
      				System.out.println("Run again? Yes, press 1. No, press 0.");
                        	response = input.nextInt();
			}
		}
	}
} 
