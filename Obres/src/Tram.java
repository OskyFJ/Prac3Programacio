/**
 * 
 * @author Oriol
 *
 */
public class Tram {
	//private Via via; //atribut extra perque cada via ja coneix els seus trams NO TOCAR ATRIBS EXTRA DE MOMENT
	private int nTram;
	private String poble1;
	private String poble2;
	//private LlistaTrajectes llistaTrajectes; //atribut extra perque cada trajecte ja coneix els seus trams
	//private Incidencia incidencia; //atribut extra perque cada incidencia ja coneix el seu tram
	
	public Tram (int nTram, String poble1, String poble2){
		this.nTram=nTram;
		this.poble1=poble1;
		this.poble2=poble2;		
	}

	public int getnTram() {
		return nTram;
	}
	
	public String getPoblacions() {
		return ("Aquest tram uneix les poblacions "+poble1+" i "+poble2);
	}
	
	public boolean correlative(Tram t2){
		boolean areCorrelative=false;
		if(poble1.equals(t2.poble1))
			areCorrelative=true;
		if(poble1.equals(t2.poble2))
			areCorrelative=true;
		if(poble2.equals(t2.poble1))
			areCorrelative=true;
		if(poble2.equals(t2.poble2))
			areCorrelative=true;
		return areCorrelative;	
	}
	
	public String toString() {
		return "Tram [nTram=" + nTram + ", poble1=" + poble1 + ", poble2="
				+ poble2 + "]";
	}
   
	
}
