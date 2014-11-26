package Model;
/**
 * 
 * @author Juli�n
 *
 */
public class Conductor {
	
	/** Les variables de la classe conductor son: */
	/**el nom del conductor, numero de m�bil i el Codi. */
	/**A m�s necessitem la llista de trajectes per a afegir un nou trajecte*/
	
	private LlistaTrajectes[] llistaTrajectes;
	protected String nomConductor;
	protected int numeroMobil;
	protected String codiConductor;
	
	
	/**Constructor amb par�metres per a Conductor*/
	
	public Conductor(String codiConductor, String nomConductor, int numeroMobil){
		this.codiConductor=codiConductor;
		this.nomConductor=nomConductor;
		this.numeroMobil=numeroMobil;		
	}
	
	/**M�tode per a afegir un trajecte*/
	
	public void afegirTrajecte (Trajecte traj){
		llistaTrajectes.afegirTrajecte(traj);
	}
	
	/** Getter del n�mero de m�bil*/
	
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

	/** String de la classe conductor que retorna les dades del conductor: nom, DNI i tel�fon */
	
	public String toString(){
		return ("\nNom del conductor: "+nomConductor+"\n\t- DNI: "+codiConductor+"\n\t- Tel�fon: "+numeroMobil);
	}

}
