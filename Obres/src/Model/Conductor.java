package Model;
/**
 * 
 * @author Julián
 *
 */
public class Conductor {
	protected String nom_conductor;
	protected int numero_mobil;
	protected String codi_conductor;
	
	public Conductor(String codi_conductor, String nom_conductor, int numero_mobil){
		this.codi_conductor=codi_conductor;
		this.nom_conductor=nom_conductor;
		this.numero_mobil=numero_mobil;		
	}
	
	//Afegir trajecte a un conductor
	
	public int getNumero_mobil() {
		return numero_mobil;
	}

	public String getNom_conductor() {
		return nom_conductor;
	}

	public String getCodi_conductor() {
		return codi_conductor;
	}

	public String toString(){
		return ("\nNom del conductor: "+nom_conductor+"\n\t- DNI: "+codi_conductor+"\n\t- Telèfon: "+numero_mobil);
	}

}
