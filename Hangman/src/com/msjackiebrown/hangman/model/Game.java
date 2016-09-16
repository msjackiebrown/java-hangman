package com.msjackiebrown.hangman.model;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
	
	private List<String> wordList;
	private String currentWord;
	private char[] mask;
	private String guess;
	private int numberMisses;
	private Logger logger = LogManager.getLogger(Game.class);
	
	public Game(List<String> wordList)
	{
		logger.debug("Initializing game....");
		this.wordList = wordList;
		numberMisses=0;
		currentWord = getRandomWord();
		mask = new char[currentWord.length()];
		
		for (int count=0; count<mask.length; count++)
		{
			mask[count]='-';
		}
		

	}
	

	public String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}


	public String  getMask() {
		return new String(mask);
	}

	public void setMask(char[] mask) {
		this.mask = mask;
	}






	public String getGuess() {
		return guess;
	}






	public void setGuess(String guess) {
		this.guess = guess;
	}






	public int getNumberMisses() {
		return numberMisses;
	}






	public void setNumberMisses(int numberMisses) {
		this.numberMisses = numberMisses;
	}

	public String getRandomWord() {
		
		int index = (int) (Math.random() * wordList.size());
		
		return wordList.get(index);
		
	}
	
	public boolean checkGuess(String guessedLetter)
	{
		if (currentWord.contains(guessedLetter))
		{
			//Uncover letters
			int index = currentWord.indexOf(guessedLetter); //Get first occurrence
			do
			{
			logger.debug(index);
			logger.debug(currentWord.lastIndexOf(guessedLetter));
			mask[index]=guessedLetter.charAt(0);
			index = currentWord.indexOf(guessedLetter, index+1); //Get next occurrence
			
			}while(index!=-1); 
			
			return true;
		}
		else
		{
			numberMisses++;
			return false;
		}
		
	}

	public void updateMisses() {
		
		numberMisses++;
		
	}
	
	public boolean isWinner()
	{
		
		return Arrays.equals(currentWord.toCharArray(), mask);
		
	}
	
	public boolean isLoser()
	{
		return numberMisses>5;
	}
		
	
	
	
	

	

}
