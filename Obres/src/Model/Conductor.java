package Model;
/**
 * 
 * @author Julián
 *
 */
public class Conductor {
	protected String nomConductor;
	protected int numeroMobil;
	protected String codiConductor;
	
	/**Constructor amb paràmetres per a Conductor*/
	public Conductor(String codiConductor, String nomConductor, int numeroMobil){
		this.codiConductor=codiConductor;
		this.nomConductor=nomConductor;
		this.numeroMobil=numeroMobil;		
	}
	
	
	
	//Afegir trajecte a un conductor
	
	public int getNumeroMobil() {
		return numeroMobil;
	}

	public String getNomConductor() {
		return nomConductor;
	}

	public String getCodiConductor() {
		return codiConductor;
	}

	public String toString(){
		return ("\nNom del conductor: "+nomConductor+"\n\t- DNI: "+codiConductor+"\n\t- Telèfon: "+numeroMobil);
	}

}
