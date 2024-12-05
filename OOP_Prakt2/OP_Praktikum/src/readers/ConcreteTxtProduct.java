package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcreteTxtProduct extends Product{
	
	private BufferedReader br;
	
	public ConcreteTxtProduct() throws FileNotFoundException {
		this.br = new BufferedReader(new FileReader("OP_Praktikum\\Fahrrad.txt"));
	}
	

	@Override
	public String[] leseAusDatei() throws IOException {
		List<String> ergebnisZeile = new ArrayList<>();
		String zeile;
		while((zeile = br.readLine()) != null) {
			ergebnisZeile.add(zeile);
		}
		return ergebnisZeile.toArray(new String [0]);
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
