package com.msjackiebrown.hangman.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msjackiebrown.hangman.model.WordList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class WordListController implements Initializable {
	
	
	private Logger logger = LogManager.getLogger(WordListController.class);
	
	
	@FXML
	ListView<String> wordLists;
	
	@FXML
	ListView<String> words;

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
		
		logger.error("Initializing wordList....");
		
		wordLists.setItems(FXCollections.observableArrayList(wordListManager.getWordLists()));
		//wordLists.getSelectionModel().select(controller.getWordList().getName());
		//words.setItems(FXCollections.observableArrayList(getWordList().getWords()));
		
	}
	

	
	public void addListener()
	{
		wordLists.getSelectionModel().selectedItemProperty().addListener(
	            new ChangeListener<String>() {
	                public void changed(ObservableValue<? extends String> ov, 
	                    String old_val, String new_val) {
	                	
	                		WordList wordList = new WordList(new_val);
	                		words.setItems(FXCollections.observableArrayList(wordList.getWords()));
	            }
	        });
	}

	
}
