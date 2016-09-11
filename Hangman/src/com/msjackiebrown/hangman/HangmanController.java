package com.msjackiebrown.hangman;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class HangmanController implements Initializable {
	
	private static WordList wordlist = new WordList(null);
	
	@FXML
	Label messageBar;
	
	@FXML
	Label missedBar;
	
	@FXML
	Label maskedWord;
	
	@FXML
	GridPane buttonPane;
	
	@FXML 
	Circle head;
	
	@FXML
	Line arm1;
	
	@FXML 
	Line arm2;
	
	@FXML
	Line body;
	
	@FXML
	Line leg1;
	
	@FXML 
	Line leg2;
	

	private Button selected;
	
	private static String currentWord;
	
	private static char[] mask;
	
	private static String guess;

	private static int numberMisses;
	
	public void initModel()
	{
		numberMisses=0;
		currentWord = wordlist.getRandomWord();
		
		mask = new char[currentWord.length()];
		
		for (int count=0; count<mask.length; count++)
		{
			mask[count]='-';
		}
		
		
		
	}
	
	public void updateView()
	{
		missedBar.setText("Times Missed: " + numberMisses);
		maskedWord.setText(new String(mask));
		updateHangman();
	}
	
	private void initView()
	{
		//ClearHangman
		arm1.setVisible(false);
		head.setVisible(false);
		body.setVisible(false);
		arm2.setVisible(false);
		leg1.setVisible(false);
		leg2.setVisible(false);
		
		ObservableList<Node> buttons = buttonPane.getChildren();
		for (int i=0; i<buttons.size(); i++)
		{
			 Button temp = ((Button) buttons.get(i));
			 temp.setTextFill(Color.BLACK);
			 temp.setDisable(false);
		}
		messageBar.setTextFill(Color.BLACK);
		messageBar.setText("(Guess) Enter a letter in the word");
		maskedWord.setText(new String(mask));
	}
		
	public  void checkAnswer()
	{
		
			if (currentWord.contains(guess))
			{ 

				selected.setTextFill(Color.GREEN);
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
				selected.setTextFill(Color.RED);
				numberMisses+=1;
				updateHangman();
			}
		}
		
	private void updateHangman() {


		switch(numberMisses)
		{
		case 1:
			head.setVisible(true);
			break;
		case 2:
			body.setVisible(true);
			break;
		case 3:
			arm1.setVisible(true);
			break;
		case 4:
			arm2.setVisible(true);
			break;
		case 5:
			leg1.setVisible(true);
			break;
		case 6:
			leg2.setVisible(true);
			break;
		}
		
	}

	public boolean isWinner()
	{
		
		if( Arrays.equals(currentWord.toCharArray(), mask))
			{
			messageBar.setTextFill(Color.GREEN);
			messageBar.setText("YOU ARE SAVED!");
			return true;
			}
			
	   else
			{
				return false;
			}
		
	}

	public boolean isLoser()
	{
		if (numberMisses>6)
		{
			messageBar.setTextFill(Color.RED);
			messageBar.setText("YOU ARE HANGED! The word was " + currentWord);
	
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		startGame();	
	}
	

	public void showConfirmationDialog()
	{
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Do you want to play again?");

		ButtonType buttonTypeOne = new ButtonType("Yes");
		ButtonType buttonTypeTwo = new ButtonType("No");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		   startGame();
		} else {
			
			System.exit(0);
		}
		  
	}
	
	@FXML
	public void handleButton(ActionEvent e)
	{
		selected = (Button) e.getSource();
		guess = selected.getText().toLowerCase();
		selected.setDisable(true);
		checkAnswer();
		updateView();
		
		if(isWinner() || isLoser())
		{
			showConfirmationDialog();
		}

	}

	@FXML
	public void startGame()
	{
		
		initModel();
		initView();
	}
}