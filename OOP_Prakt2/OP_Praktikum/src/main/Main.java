package main;

import javafx.application.Application;

import guiFahrradEinrichtungen.FahrradUndZubehoerControl;
import guiFahrradGeschaeft.FahrradGeschaeftControl;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
	    launch(args);
	 }
	
	 public void start(Stage primaryStage) {
		 new FahrradGeschaeftControl(primaryStage);
		 //new FahrradUndZubehoerControl(primaryStage);
		 Stage fensterFahrradUndZubehoer = new Stage();
		 new FahrradUndZubehoerControl(fensterFahrradUndZubehoer);
	 }
	  
	 
}
