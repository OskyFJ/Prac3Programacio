/**
 * 
 * @author Xavi
 *
 */

public class Trajecte {
	private LlistaTrams llistaTrams;
	private String nomTrajecte;
	//private Conductor conductor; //atribut extra cada conductor ja coneix els seus trajectes no tocar de moment
	private Tram[] trams;
	private String nomConductor;
	
	public Trajecte(String nom_conductor, String nomtrajecte,Tram[] trams){
		this.nomConductor=nom_conductor;
		this.trams=trams;
		this.nomTrajecte=nomtrajecte;
	}
	
	public Tram[] getTrams(){
		return trams;
	}
	
	public LlistaTrams getLlistaTrams() {
		return llistaTrams;
	}

	public void setLlistaTrams(LlistaTrams llistaTrams) {
		this.llistaTrams = llistaTrams;
	}

	public String getNomTrajecte() {
		return nomTrajecte;
	}

	public void setNomTrajecte(String nomTrajecte) {
		this.nomTrajecte = nomTrajecte;
	}

	public void setTrams(Tram[] trams) {
		this.trams = trams;
	}

	public String toString(){
		String trajectes="";
		int contTrams=0;
		int contPoblacio=0;
		while(contTrams<trams.length){
			if(trams.length==1){
				while(contPoblacio<trams[contTrams].getPoblacio().length){
					if(contPoblacio==0){
						trajectes+=trams[contTrams].getPoblacio()[1];
					}
					else trajectes+=" - "+trams[contTrams].getPoblacio()[1];
					contPoblacio++;
				}
			}
			else{
				while(contPoblacio<trams[contTrams].getPoblacio().length){
					if(contPoblacio!=0) trajectes+=" - "+trams[contTrams].getPoblacio()[1];
					contPoblacio++;
				}
			}
				
		contPoblacio=0;;
		contTrams++;
		}
		
		return "Nom del conductor: "+nomConductor+"\n\t- Nom del trajecte: "+nomTrajecte+"\n\t- Trajecte: \n\t\t- "+trajectes;
	}
	
}
