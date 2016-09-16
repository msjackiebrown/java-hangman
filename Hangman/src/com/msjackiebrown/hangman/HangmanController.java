package com.msjackiebrown.hangman;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msjackiebrown.hangman.model.Game;
import com.msjackiebrown.hangman.model.WordList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class HangmanController implements Initializable {
	
	
	private Logger logger = LogManager.getLogger(HangmanController.class);
	
	private Game game;
	
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

	private WordList wordList = new WordList("wordlist.txt");
	
	public void updateView()
	{
		missedBar.setText("Times Missed: " + game.getNumberMisses());
		maskedWord.setText(game.getMask());
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
		maskedWord.setText(game.getMask());
		missedBar.setText("Times Missed: " +  game.getNumberMisses());
	}
		
	
	public void checkAnswer()
	{
		
			if (game.checkGuess(selected.getText()))
			{ 

				selected.setTextFill(Color.GREEN);
				
			}
			else
			{
				selected.setTextFill(Color.RED);
				game.updateMisses();
				updateHangman();
			}
		}
		
	private void updateHangman() {


		switch(game.getNumberMisses())
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

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startGame();	
	}
	

	public void showCloseConfirmationDialog()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Are you sure you want to quit? You will lose any unsaved progress.");

		ButtonType buttonTypeOne = new ButtonType("Yes");
		ButtonType buttonTypeTwo = new ButtonType("No");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		   System.exit(0);
		} else {
			
			alert.close();
			return;
		}
	}
	
	public void showAboutDialog()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("FEATURE NOT YET IMPLEMENTED");
		alert.setContentText("This feature has not yet beem implemented into the program. Sorry for the inconvience.");

		alert.showAndWait();
	}
	
	public void showNewGameDialog()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Are you sure you wish to start a new game?  You will lose any unsaved progress");

		ButtonType buttonTypeOne = new ButtonType("Yes");
		ButtonType buttonTypeTwo = new ButtonType("No");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		   startGame();
		} else {
			
			alert.close();
			return;
		}
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
	public void showWordListDialog() throws IOException
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("FEATURE NOT YET IMPLEMENTED");
		alert.setContentText("This feature has not yet beem implemented into the program. Sorry for the inconvience.");

		alert.showAndWait();
		
//		BorderPane wordListDialog = (BorderPane)FXMLLoader.load(getClass().getResource("WordList.fxml"));
//		
//		Stage stage = new Stage();
//		Scene scene = new Scene(wordListDialog);
//		
//		stage.setScene(scene);
//		stage.setTitle("WordList Manager");
//		stage.sizeToScene();	
//		stage.showAndWait();
		
	}
	
	@FXML
	public void handleButton(ActionEvent e)
	{
		selected = (Button) e.getSource();	
		String guess = selected.getText().toLowerCase();
		logger.debug("Guessed Letter: " + guess);
		selected.setDisable(true);
		
		if (game.checkGuess(guess))
			{
				selected.setTextFill(Color.DARKGREEN);
			}
		else
		{
			selected.setTextFill(Color.DARKRED);
		}
		updateView();
		checkForWinLose();

	}

	private void checkForWinLose()
	{
	
		if(game.isWinner()) 
		{
			messageBar.setTextFill(Color.GREEN);
			messageBar.setText("YOU ARE SAVED!");
			
			showConfirmationDialog();
		}
		
		if (game.isLoser())
		{
			messageBar.setTextFill(Color.RED);
			messageBar.setText("YOU ARE HANGED!\nTHE WORD WAS " + game.getCurrentWord());
			
			showConfirmationDialog();
		}
	}
	
	@FXML
	public void startGame()
	{
		
		logger.debug("Initializing game....");
		game = new Game(wordList.getWords());
		initView();
		logger.debug("Game initialized.");
		logger.debug("Current word: " + game.getCurrentWord());
	}

}