package ownUtil;

import javafx.scene.control.Alert;

public class MeldungsfensterAnzeiger {
	
	  private Alert.AlertType alertTyp;
	  
	  private String titel;
	  
	  private String meldung;
	  
	  public MeldungsfensterAnzeiger(Alert.AlertType alertTyp, String titel, String meldung) {
	    this.alertTyp = alertTyp;
	    this.titel = titel;
	    this.meldung = meldung;
	    if (meldung == null || "".equals(meldung))
	      this.meldung = "Die Meldung ist nicht vorhanden."; 
	  }
	  
	  public void zeigeMeldungsfensterAn() {
	    Alert alert = new Alert(this.alertTyp);
	    alert.setTitle(this.titel);
	    alert.setContentText(this.meldung);
	    alert.showAndWait();
	  }
	

}
