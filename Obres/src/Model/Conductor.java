package Model;
/**
 * 
 * @author Julián
 *
 */
public class Conductor {
	
	/** Les variables de la classe conductor son: */
	/**el nom del conductor, numero de mòbil i el Codi. */
	/**A més necessitem la llista de trajectes per a afegir un nou trajecte*/
	
	private LlistaTrajectes[] llistaTrajectes;
	protected String nomConductor;
	protected int numeroMobil;
	protected String codiConductor;
	
	
	/**Constructor amb paràmetres per a Conductor*/
	
	public Conductor(String codiConductor, String nomConductor, int numeroMobil){
		this.codiConductor=codiConductor;
		this.nomConductor=nomConductor;
		this.numeroMobil=numeroMobil;		
	}
	
	/**Mètode per a afegir un trajecte*/
	
	public void afegirTrajecte (Trajecte traj){
		llistaTrajectes.afegirTrajecte(traj);
	}
	
	/** Getter del número de mòbil*/
	
	public int getNumeroMobil() {
		return numeroMobil;
	}
	
	/**Getter del nom del conductor*/
	
	public String getNomConductor() {
		return nomConductor;
	}

	/** Getter del Codi del conductor*/
	
	public String getCodiConductor() {
		return codiConductor;
	}

	/** String de la classe conductor que retorna les dades del conductor: nom, DNI i telèfon */
	
	public String toString(){
		return ("\nNom del conductor: "+nomConductor+"\n\t- DNI: "+codiConductor+"\n\t- Telèfon: "+numeroMobil);
	}

}
