package com.msjackiebrown.hangman.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordList{
	
	private Logger logger = LogManager.getLogger(WordList.class);
	private ArrayList<String> words = new ArrayList<String>();
	private String fileLocation;

	public WordList(String fileLocation) 
	{
		
		this.fileLocation = fileLocation;
	}	
		
	public ArrayList<String> getWords()
	{    //Get wordlist fom file
		
		Scanner input = null;
		try {
			input = new Scanner(new File("wordLists/"+fileLocation));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while( input.hasNextLine())
			{
					
				String word =input.nextLine();
				logger.error("Adding word " + word);
				words.add(word); 
				
			}
		
		input.close();
	
		return words;
	}

	public String  getName()
	{
		return fileLocation;
	}

	
}
