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
	
	public String toString(){
		String trajectes="";
		int contTrams=0;
		int contPoblacio=0;
		while(contTrams<trams.length){
			if(trams.length==1){
				while(contPoblacio<trams[contTrams].getpoblacio().length){
					if(contPoblacio==0){
						trajectes+=trams[contTrams].getpoblacio()[1];
					}
					else trajectes+=" - "+trams[contTrams].getpoblacio()[1];
					contPoblacio++;
				}
			}
			else{
				while(contPoblacio<trams[contTrams].getpoblacio().length){
					if(contPoblacio!=0) trajectes+=" - "+trams[contTrams].getpoblacio()[1];
					contPoblacio++;
				}
			}
				
		contPoblacio=0;;
		contTrams++;
		}
		
		return "Nom del conductor: "+nomConductor+"\n\t- Nom del trajecte: "+nomTrajecte+"\n\t- Trajecte: \n\t\t- "+trajectes;
	}
	
}
