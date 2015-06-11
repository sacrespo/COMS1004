//*******************************
//WordLists.java
//by Sheryl Crespo
//szc2103
//********************************

//********************************
//This class generates word lists
//based on certain specifications 
//from the dictionary.txt file. 
//********************************

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.Scanner;

public class WordLists 
{
	private Scanner scan;  
	private ArrayList<String> dictionaryList; 
	private File dictionaryFile;
 
	//This constructor takes in the name of a file
	//and converts the contents of that file
	//into an ArrayList of Strings. 
	public WordLists(String fileName) 
	{
		dictionaryFile = new File(fileName);
		
		try
		{
			scan = new Scanner(dictionaryFile); 
			dictionaryList = new ArrayList<String>(); 

			while(scan.hasNextLine()) 
			{
				dictionaryList.add(scan.nextLine()); 
			}  
		}
		
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File Not Found Exception"); 
		}
	} 
	
	//This method takes in an integer n
	//that denotes that out of the dictionary
	//the array of Strings returend should 
	//contain words of length n. 
	public String[] lengthN(int n) 
	{
		ArrayList<String> words = new ArrayList<String>();
		
		for(int i=0; i<dictionaryList.size(); i++)
		{
			if(dictionaryList.get(i).length() == n)
			{	
				words.add(dictionaryList.get(i)); 	 	
			}	
		}	
			
		String[] wordList = words.toArray(new String[0]); 
		
		return wordList; 
	}
	
	//This method takes in an integer n
	//for the length of the words and a char
	//firstLetter for the first letter of the
	//words to be returned in the array of 
	//Strings. 
	public String[] startsWith(int n, char firstLetter)
	{
		ArrayList<String> words = new ArrayList<String>(); 
		String[] temp = lengthN(n); 
		for(int i=0; i<temp.length; i++) 
		{
			if(temp[i].charAt(0) == firstLetter)
			{
				words.add(temp[i]); 
			}	
		}
		 
		String[] wordsList = words.toArray(new String[0]);
		
		return wordsList; 
	}
	
	//This method takes in an integer n
	//and a char included for the letter
	//that must be contained in the words
	//of length n to be included in the array
	//of Strings returned. 	
	public String[] containsLetter(int n, char included)
	{
		ArrayList<String> words = new ArrayList<String>(); 
		String[] temp = lengthN(n);
		for(int i=0; i<temp.length; i++)
		{
			if(temp[i].indexOf(included) != -1) 
			{
				words.add(temp[i]);
			}
		}
			
		String[] wordsList = words.toArray(new String[0]);
	
		return wordsList; 
	}
	
	//This method takes in two integers, 
	//returning an array of Strings of length
	//n containing at least m vowels. 
	public String[] vowelHeavy(int n, int m)
	{
		int count = 0; 
		ArrayList<String> words = new ArrayList<String>(); 
		String[] temp = lengthN(n); 
		for(int i=0; i<temp.length; i++)
		{
			for(int j=0; j<temp[i].length(); j++)
			{
			    if((temp[i].charAt(j)=='a')||(temp[i].charAt(j)=='e')||(temp[i].charAt(j)=='i')||(temp[i].charAt(j)=='o')||(temp[i].charAt(j)=='u'))
				{
					count++; 
				}
			}

			if(count >= m)
			{
				words.add(temp[i]);
			}

			count = 0;
		}
		
		String[] wordsList = words.toArray(new String[0]); 
		return wordsList;	
	}
	
	//This method takes in an integer m
	//and a char, included, returning an 
	//array of Strings with at least m 
	//occurrences of the char included. 
	public String[] multiLetter(int m, char included)
	{
		int count = 0;
		ArrayList<String> words = new ArrayList<String>(); 
		for(int i=0; i<dictionaryList.size(); i++)
		{
			for(int j=0; j<dictionaryList.get(i).length(); j++)
			{
				if(dictionaryList.get(i).charAt(j) == included)
				{
					count++; 
				}
			}
	
			if(count>=m) 
			{
				words.add(dictionaryList.get(i)); 
			}
	
			count = 0; 
		}
		String[] wordsList = words.toArray(new String[0]); 
		return wordsList; 
	}
}
