package com.msjackiebrown.hangman.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.msjackiebrown.hangman.model.WordList;

public class WordListManager {
	
	public List<String> getWordLists() {

		File wordListDirectory = new File("wordlists/");
		File[] wordListFiles = wordListDirectory.listFiles();
		
		List<String> wordListFileNames = new ArrayList<String>();
		for (File wordListFile: wordListFiles)
		{
			wordListFileNames.add(wordListFile.getName());
		}
		return wordListFileNames;
	}
	
	public void importWordList(WordList wordList, File location)
	{
		
	}
	
	public void exportWordList(WordList wordlist, File location)
	{
		
	}
	
	public boolean removeWordList(WordList wordList)
	{
		return false;
	}
	
	public void createWordList(WordList wordList)
	{
		
	}

}
