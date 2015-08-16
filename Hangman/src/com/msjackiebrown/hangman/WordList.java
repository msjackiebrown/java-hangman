package com.msjackiebrown.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordList extends ArrayList<String> {
	
	public WordList(File filelocation) 
	{
		
		//Get wordlist fom file
		
		Scanner input = null;
		try {
			input = new Scanner(new File("wordlist.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while( input.hasNextLine())
			{
					
				String word =input.nextLine();
				
				System.out.println("Adding " + word);
				
				add(word);
				
			}
		
		input.close();
	
		
	}

	
}
