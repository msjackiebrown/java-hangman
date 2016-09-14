package com.msjackiebrown.hangman;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;

public class WordListController implements Initializable {
	
	
	@FXML
	TableView<String> wordLists;
	
	@FXML
	ListView words;

	private WordListManager wordListManager = new WordListManager();
	
	@FXML
	public void addButton()
	{
		
	}
	
	@FXML
	public void editButton()
	{
		
	}
	
	@FXML
	public void importButton()
	{
		
	}
	
	@FXML 
	public void exportButton()
	{
		
	}
	
	@FXML
	public void deleteButton()
	{
		
	}
	
	@FXML
	public void startGame()
	{
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		wordLists.setItems(FXCollections.observableArrayList(wordListManager.getWordLists()));
		words.setItems(FXCollections.observableArrayList(wordListManager.getWordLists()));
		
	}
	
	

	
}
