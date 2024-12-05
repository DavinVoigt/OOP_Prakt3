package business;

public class Fahrrad {
	
	private String name;
	  
	  private int rahmennummer;
	  
	  private String typ;
	  
	  private String art;
	  
	  private String[] groessen;
	  
	  public Fahrrad(String name, int rahmennummer, String typ, String art, String[] groessen) {
	    this.name = name;
	    this.rahmennummer = rahmennummer;
	    this.typ = typ;
	    this.art = art;
	    this.groessen = groessen;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	  
	  public void setName(String name) {
	    this.name = name;
	  }
	  
	  public int getRahmennummer() {
	    return this.rahmennummer;
	  }
	  
	  public void setRahmennummer(int rahmennummer) {
	    this.rahmennummer = rahmennummer;
	  }
	  
	  public String getTyp() {
	    return this.typ;
	  }
	  
	  public void setTyp(String typ) {
	    this.typ = typ;
	  }
	  
	  public String getArt() {
	    return this.art;
	  }
	  
	  public void setArt(String art) {
	    this.art = art;
	  }
	  
	  public String[] getGroessen() {
	    return this.groessen;
	  }
	  
	  public void setGroessen(String[] groessen) {
	    this.groessen = groessen;
	  }
	  
	  public String getGroessenAlsString(char trenner) {
	    String ergebnis = "";
	    int i = 0;
	    for (i = 0; i < (getGroessen()).length - 1; i++)
	      ergebnis = String.valueOf(ergebnis) + getGroessen()[i] + trenner; 
	    return String.valueOf(ergebnis) + getGroessen()[i];
	  }
	  
	  public String gibFahrradZurueck(char trenner) {
	    return String.valueOf(this.getName()) + trenner + 
	      this.getArt() + trenner + 
	      this.getRahmennummer() + trenner + 
	      this.getTyp() + trenner + "\n" + 
	      this.getGroessenAlsString(';') + trenner + "\n";
	  }
	  


}
