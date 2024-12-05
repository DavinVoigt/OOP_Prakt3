package guiFahrradGeschaeft;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import business.*;
import javafx.stage.Stage;
import observer.Observer;

public class FahrradGeschaeftControl implements Observer{

	private FahrradGeschaeftModel fahrradModel;
	private Fahrrad fahrrad;
	private FahrradGeschaeftView fahrradView;

	public FahrradGeschaeftControl(Stage primaryStage) {
		this.fahrradModel = FahrradGeschaeftModel.getInstance();
		this.fahrradView = new FahrradGeschaeftView(this, primaryStage, fahrradModel);
		this.fahrradModel.addObserver(this);
	}

	public void schreibeFahrradInCsvDatei() throws IOException {
		try {
			fahrradModel.schreibeFahrradInCsvDatei();
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void leseAusDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				fahrradView.zeigeInformationsfensterAn("Die Fahrräder wurden gelesen!");
				fahrradModel.leseFahrradAusDatei();
				this.fahrrad = fahrradModel.getFahrrad();
			} else {
				fahrradView.zeigeInformationsfensterAn("Die Fahrräder wurden gelesen!");
				fahrradModel.leseFahrradAusDateiTxt();
				this.fahrrad = fahrradModel.getFahrrad();
			}
		} catch (IOException exc) {
			fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
			exc.printStackTrace();
		}
	}

	@Override
	public void update() {
		fahrradView.zeigeFahrradAn();
		
	}

}
