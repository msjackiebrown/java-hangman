package com.msjackiebrown.hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Hangman extends Application {

	@Override
	public void start(Stage primaryStage) {
	try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Hangman.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setTitle("HangManFX");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		

	public static void main(String[] args) {
		launch(args);
	}
}
