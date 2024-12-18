package guiFahrradGeschaeft;

import javafx.application.Application;
import javafx.*;
import business.FahrradGeschaeftModel;

import business.Fahrrad;
import ownUtil.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FahrradGeschaeftView {
	
	  private FahrradGeschaeftControl fahrradControl;
	  
	  private FahrradGeschaeftModel fahrradModel;
	  

	  
	    private Pane pane     					= new  Pane();
	    private Label lblEingabe    	 		= new Label("Eingabe");
	    private Label lblAnzeige   	 	    	= new Label("Anzeige");
	    private Label lblName 					= new Label("Name:");
	    private Label lblRahmennummer  		= new Label("Rahmennummer:");
	    private Label lblTyp 	 		= new Label("Typ:");
	    private Label lblArt   			= new Label("Art:");
	    private Label lblGroessen  		= new Label("Groessen:");
	    private TextField txtName 	 			= new TextField();
	    private TextField txtRahmennummer		= new TextField();
	    private TextField txtTyp		= new TextField();
	    private TextField txtArt			= new TextField();
	    private TextField txtGroessen	= new TextField();
	    private TextArea txtAnzeige  			= new TextArea();
	    private Button btnEingabe 		 		= new Button("Eingabe");
	    private Button btnAnzeige 		 		= new Button("Anzeige");
	    private MenuBar mnbrMenuLeiste  		= new MenuBar();
	    private Menu mnDatei             		= new Menu("Datei");
	    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export"); 
	  
	  public FahrradGeschaeftView(FahrradGeschaeftControl fahrradControl, Stage primaryStage, FahrradGeschaeftModel fahrradModel) {
	    this.fahrradControl = fahrradControl;
	    this.fahrradModel = fahrradModel;
	    Scene scene = new Scene(this.pane, 700.0, 340.0);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Verwaltung von Fahrradgeschaeften");
	    primaryStage.show();
	    this.initKomponenten();
	    this.initListener();
	  }
	  
	  private void initKomponenten() {
		  lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblRahmennummer.setLayoutX(20);
	    	lblRahmennummer.setLayoutY(130);
	    	lblTyp.setLayoutX(20);
	    	lblTyp.setLayoutY(170);
	    	lblArt.setLayoutX(20);
	    	lblArt.setLayoutY(210);
	    	lblGroessen .setLayoutX(20);
	    	lblGroessen .setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblRahmennummer, lblTyp,
	       		lblArt, lblGroessen);
	    
	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtRahmennummer.setLayoutX(170);
	    	txtRahmennummer.setLayoutY(130);
	    	txtRahmennummer.setPrefWidth(200);
	    	txtTyp.setLayoutX(170);
	    	txtTyp.setLayoutY(170);
	    	txtTyp.setPrefWidth(200);
	      	txtArt.setLayoutX(170);
	      	txtArt.setLayoutY(210);
	      	txtArt.setPrefWidth(200);
	    	txtGroessen.setLayoutX(170);
	    	txtGroessen.setLayoutY(250);
	    	txtGroessen.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtName, txtRahmennummer, txtTyp,
	     		txtArt, txtGroessen);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	  }
	  
	  private void initListener() {
	    this.btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent e) {
	            nehmeFahrradAuf();
	          }
	        });
	    this.btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent e) {
	            zeigeFahrradAn();
	          }
	        });
	    this.mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent e) {
	        	
	            fahrradControl.leseAusDatei("csv");
	          }
	        });
	    this.mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent e) {
	            fahrradControl.leseAusDatei("txt");
	          }
	        });
	    this.mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent e) {
	            try {
	            	fahrradControl.schreibeFahrradInCsvDatei();
	            } catch (Exception exception) {}
	          }
	        });
	  }
	  
	  private void nehmeFahrradAuf() {
	    try {
	      fahrradModel.setFahrrad(new Fahrrad(
	          this.txtName.getText(), 
	          Integer.parseInt(this.txtRahmennummer.getText()), 
	          this.txtTyp.getText(), 
	          this.txtArt.getText(), 
	          this.txtGroessen.getText().split(";")));
	      zeigeInformationsfensterAn("Das Fahrrad wurde aufgenommen!");
	    } catch (Exception exc) {
	      zeigeFehlermeldungsfensterAn(exc.getMessage());
	    } 
	  }
	  
	  public void zeigeFahrradAn() {
		Fahrrad fahrrad = fahrradModel.getFahrrad();
	    if (fahrrad != null) {
	      this.txtAnzeige.setText(
	          fahrrad.gibFahrradZurueck(' '));
	    } else {
	      zeigeInformationsfensterAn("Bisher wurde kein Fahrrad aufgenommen!");
	    } 
	  }
	  
	  public void zeigeInformationsfensterAn(String meldung) {
	    (new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION, 
	        "Information", meldung)).zeigeMeldungsfensterAn();
	  }
	  
	  public void zeigeFehlermeldungsfensterAn(String meldung) {
	    (new MeldungsfensterAnzeiger(Alert.AlertType.ERROR, 
	        "Fehler", meldung)).zeigeMeldungsfensterAn();
	  }

}













































/*
 * for(Artikel art : artikel) {
 *  art.getBlaBlaBla
 * }
 * 
 * String[] zeile = null;
 * String zeileStr = ein.readLine();
		while(zeileStr != null) {
			zeile = zeileStr.split(";");
			artikel.add(new Artikel(
				Integer.parseInt(zeile[0]), zeile[1],
				Double.parseDouble(zeile[2])));
			zeileStr = ein.readLine();
	}
 * Throwable exc = assertThrows(IllegalArgumentException.class, () -> {new Trikot(-1, 39, 49.99, 20022004);});
 *		 assertEquals(exc.getMessage(), "Die Trikotnummer darf nicht 0 oder kleiner sein");
 * 
 */

