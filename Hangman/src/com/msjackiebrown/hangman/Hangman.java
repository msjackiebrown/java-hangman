package com.msjackiebrown.hangman;
import java.util.Scanner;

public class Hangman {
	
	private static WordList wordlist = new WordList(null);
	
	private static String currentWord;
	
	private static char[] mask;
	
	private static Scanner input= new Scanner(System.in);

	private static String guess;

	private static int numberMisses;
	
	private static String answer; 
	
	public static void main(String[] args) {
		
		
		do{
				refresh();
				getWord();
				numberMisses=0;
				
			do{
				displayWord();
				guessLetter();
				checkAnswer();
			
		
				if (isWinner())
				{
			
					System.out.print("The word is " + currentWord + ".  You missed " + numberMisses + " time");
					if (numberMisses>1) { System.out.println("s. ");}
					else {System.out.println(". "); }
				}
		
			 }while (!isWinner());

		
		System.out.print("Do you want to play again (Y/N)?");
		answer= input.next();
		
		}while (answer.contains("Y") || answer.contains("y"));
		
		System.out.println("\n\nThank you for playing! Have a nice day!");
		
		System.exit(0);

		
	}
	
	

	
	public static void refresh()
	{
		for (int i=0; i<80; i++)
		{
			System.out.println();
		}
	}
	
	public static void getWord()
	{
		int index = (int) (Math.random() * wordlist.size());
		
		currentWord = wordlist.get(index);
		
		mask = new char[currentWord.length()];
		
		for (int count=0; count<mask.length; count++)
		{
			mask[count]='*';
		}
		
	}
	
	
	public static void displayWord()
	{
		
		System.out.print("(Guess) Enter a letter in word ");
		
		for (int index=0;  index<currentWord.length(); index++)
		{
			System.out.print(mask[index]);
			
		}
		
		
		System.out.println(" >");
	}
	
	public static void guessLetter()
	{
		 guess =  input.next();
		 
		 guess = guess.substring(0,1); // Only one char
		
	}
	
	public static void checkAnswer()
	{
		
			if (hasGuessed())
			{
				System.out.println("The letter " + guess + " is already in the word. Try again.\n");
				return;
			}
	
			if (currentWord.contains(guess))
			{ 

				//Uncover letters
				int index = currentWord.indexOf(guess); //Get first occurrence
				do
				{
					System.out.println(index);
					System.out.println(currentWord.lastIndexOf(guess));
					mask[index]=guess.charAt(0);
					index = currentWord.indexOf(guess, index+1); //Get next occurrence
					
				}while(index!=-1); 
			}
			else
			{
				numberMisses+=1;
			}
		}
		
	
	
	private static boolean hasGuessed() {
		// TODO Auto-generated method stub
		for (int index=0; index<mask.length; index++)
		{
			if (mask[index]==guess.charAt(0))
			{
				return true;
			}
		}
		return false;
	}


	public static boolean isWinner()
	{
		for (int index=0; index<mask.length; index++)
		{
			if (currentWord.charAt(index) != mask[index])
			{
				return false;
			}
		}
		return true;
	}
	

	
}