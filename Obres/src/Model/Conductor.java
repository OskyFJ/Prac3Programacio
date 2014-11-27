package Model;
/**
 * 
 * @author Julián
 *
 */
public class Conductor {	
	private LlistaTrajectes trajecte;
	protected String nomConductor;
	protected int numeroMobil;
	protected String codiConductor;
	
	
	/**Constructor amb paràmetres per a Conductor, que rep el codi del conductor
	 * el nom del conductor i el número de mòbil.
	 */
	public Conductor(String codiConductor, String nomConductor, int numeroMobil){
		this.codiConductor=codiConductor;
		this.nomConductor=nomConductor;
		this.numeroMobil=numeroMobil;		
	}
	
	/**Getter trajecte.
	 * 
	 * @return trajecte
	 */
	public LlistaTrajectes getTrajecte() {
		return trajecte;
	}
	
	/**Setter de trajecte.
	 * 
	 * @param trajecte
	 */
	public void setTrajecte(LlistaTrajectes trajecte) {
		this.trajecte = trajecte;
	}

	/**Mètode per a afegir un trajecte.
	 */
	public void afegirTrajecte (Trajecte traj){
		trajecte.afegeixElement(traj);
	}
	
	/**Mètode per a afegir un trajecte.
	 */
	public void esborrarTrajecte (Trajecte traj){
		trajecte.esborraElement(traj);
	}

	/** Getter del número de mòbil.
	 */
	public int getNumeroMobil() {
		return numeroMobil;
	}
	
	/**Getter del nom del conductor.
	 */
	public String getNomConductor() {
		return nomConductor;
	}

	/**Getter del Codi del conductor.
	 */
	public String getCodiConductor() {
		return codiConductor;
	}

	/**String de la classe conductor
	 * que retorna les dades del
	 * conductor: nom, DNI i telèfon.
	 */
	public String toString(){
		return ("\nNom del conductor: "+nomConductor+"\n\t- DNI: "+codiConductor+"\n\t- Telèfon: "+numeroMobil);
	}

}
