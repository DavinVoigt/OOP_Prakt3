package guiFahrradEinrichtungen;

import business.FahrradGeschaeftModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class FahrradUndZubehoerView {
	
private FahrradUndZubehoerControl fahrraederUndZubehoerControl;
private FahrradGeschaeftModel fahrraederModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeFahrraeder     
 		= new Label("Anzeige Fahrräder");
    	private TextArea txtAnzeigeFahrraeder  = new TextArea();
    	private Button btnAnzeigeFahrraeder = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public FahrradUndZubehoerView(
 		FahrradUndZubehoerControl 
 		fahrraederUndZubehoerControl, 
   	 	Stage primaryStage, 
 		FahrradGeschaeftModel fahrraederModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Fahrräder und Zubehör " 
 			+ "Einrichtungen");
    		primaryStage.show();
    		this.fahrraederUndZubehoerControl 
 			= fahrraederUndZubehoerControl;
 		this.fahrraederModel = fahrraederModel;
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten(){
 	// Label
 	 		Font font = new Font("Arial", 20);
 	       	lblAnzeigeFahrraeder.setLayoutX(310);
 	    		lblAnzeigeFahrraeder.setLayoutY(40);
 	    		lblAnzeigeFahrraeder.setFont(font);
 	    		lblAnzeigeFahrraeder.setStyle("-fx-font-weight: bold;"); 
 	       	pane.getChildren().add(lblAnzeigeFahrraeder);  
 	    // Textbereich	
        	txtAnzeigeFahrraeder.setEditable(false);
     		txtAnzeigeFahrraeder.setLayoutX(310);
    		txtAnzeigeFahrraeder.setLayoutY(90);
     		txtAnzeigeFahrraeder.setPrefWidth(220);
    		txtAnzeigeFahrraeder.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeFahrraeder);        	
        	// Button
          	btnAnzeigeFahrraeder.setLayoutX(310);
        	btnAnzeigeFahrraeder.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeFahrraeder); 


 	}
 	private void initListener() {
	    btnAnzeigeFahrraeder.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeFahrraederAn();
	        	} 
   	    });
    }
   
    public void zeigeFahrraederAn(){
    		if(fahrraederModel.getFahrrad() != null){
    			txtAnzeigeFahrraeder.setText(
    				fahrraederModel.getFahrrad()
 				.gibFahrradZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Fahrrad aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}


	




