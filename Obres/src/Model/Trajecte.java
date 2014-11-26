package Model;
/**
 * 
 * @author Xavi
 *
 */

public class Trajecte {
	private LlistaTrams llistaTrams;
	private String nomTrajecte;
	private String nomConductor;
	private String[] nom_vies;
	
	/** CONSTRUCTOR --> rebra per par�metre el nom del conductor, el nom del trajecte i els trams i els assignarem
	 * a les variables de la propia classe.
	
	**
	 * 
	 * @param nom_conductor, el nom del conductor del trajecte
	 * @param nomtrajecte, el nom del trajecte
	 * @param trams, els trams que componen el trajecte
	 * 
	 */
	
	public Trajecte(String nom_conductor, String nomtrajecte, String[] nom_vies, LlistaTrams llistatrams){
		this.nomConductor=nom_conductor;
		this.llistaTrams=llistatrams;
		this.nomTrajecte=nomtrajecte;
		this.nom_vies=nom_vies;
	}
	
	/** GETTERS i SETTERS
	 * 
	 * getTrams():
	 * 
	 * @return els trams que componen el trajectes.
	 */
	
	public Tram[] getTrams(){
		return llistaTrams.getLlistaTrams();
	}
	
	/**
	 * getNomTrajecte():
	 * 
	 * @return el nom del trajecte
	 */

	public String getNomTrajecte() {
		return nomTrajecte;
	}
	
	/**
	 * getNomConductor():
	 * 
	 * @return el nom del conductor del trajecte
	 */
	
	public String getNomConductor(){
		return nomConductor;
	}
	
	/**
	 * M�TODES
	 * 
	 * agregarTrajecte():
	 * 
	 */
	
	public void agregarTrajecte(Tram tram){
		llistaTrams.afegeixTram(tram);
	}
	
	 /** 
	  * toString():
	 * 
	 * @return la informacio del trajecte en un String. El nom del conductor, el nom del trajecte i els pobles (trams) 
	 * que composen el trajecte
	 */

	public String toString(){
		String trajectes="";
		int contTrams=0;
		int contPoblacio=0;
		int numTrams=llistaTrams.getNumTrams();			
		Tram[] trams = llistaTrams.getLlistaTrams();
		while(contTrams<numTrams){
			if(numTrams==1){
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
