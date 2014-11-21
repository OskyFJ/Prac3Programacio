import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Xavi
 *
 */
public class LlistaConductors {
	private Conductor[] llista;
	private int numConductors;
	
	/**
	* CONSTRUCTOR --> rebrà per paràmetre l'amplitud inicial de la llista
	* 
	* @param max amplitud de la llista
	*/
	
	public LlistaConductors(int max){
		llista=new Conductor[max];
		numConductors=0;
	}
	
	/**
	 * GETTER
	 * 
	 * @return llista dels conductors
	 */

	
	public Conductor[] getllista(){
		return llista;
	}
	
	/**
	 * MÈTODES
	 * 
	 * agregarconductor(conductor): agreguem un conductor a la      llista. Abans comprovarem que ja no existeixi a la llista.
	 * 
	 * @param conductor que volem agregar a la llista
	 */

	
	public void agregarconductor(Conductor conductor){
		
		if(numConductors<llista.length){
			llista[numConductors]=conductor;
			numConductors++;
		}
		else if(numConductors==(llista.length)){
			Conductor[] conductors=new Conductor[llista.length+10];
			int cont=0;
			while(cont<numConductors){
				conductors[cont]=llista[cont];
			cont++;
			}
			conductors[cont]=conductor;
			numConductors++;
		}
	}
	
	/**
	 * modificarConductor(posicio_conductor, conductor): modifiquem el conductor de la llista de la 
	 * posició rebuda per paràmetre. El modifiquem per el conductor modificat per parèmtre.
	 * 
	 * @param posicio_conductor posicio del conductor a modificar
	 * @param conductor a modificar per l'existent en la llista
	 * 
	 */
	
	public void modificarConductor(int posicio_conductor, Conductor conductor){
		llista[posicio_conductor-1]=conductor;
	}
	
	/**
	 * buscarConductor(dni): busquem un conductor de la llista  segons el dni passat per paràmetre.
	 * 
	 * @param dni del conductor que volem buscar
	 * 
	 * @return la posició del conductor
	 */

	
	public int buscarConductor(String dni){
		int cont=0;
		int pos=-1;
		while(cont<numConductors){
			if(llista[cont].getdni().equals(dni)) pos=cont;
		cont++;
		}
		return pos;
	}
	
	/**
	 * eliminarConductor(posicio_conductor): eliminem el conductor de la llista de la posició que rebem per paràmetre
	 * 
	 * @param posicio_conductor: posició del conductor que volem eliminar.
	 * 
	 */

	
	public void eliminarconductor(int posicio_conductor){
		Conductor[] conductors=new Conductor[llista.length-1];
		int cont=0;
		int cont_c=0;
		while(cont<numConductors){
			if(cont!=(posicio_conductor-1)){
				conductors[cont_c]=llista[cont];
				cont_c++;
			}
			cont++;
		}
		llista=conductors;
		numConductors--;
	}
	
	/** actualitzarLlista(): guardarà els conductor en un fitxer de text (*.txt). Només caldrà crear
	* un túnel per poder escriure (PrintWriter fitxerout = new PrintWriter(new fileWriter("temp.txt"))).
	 * 
	 * Primer de tot, escriurem en la primera línia amb (fitxerout.println()) el numero de conductors, per poder controlar quants conductors hi ha en la llista.
	* 
	* Després, farem el recorregut de la llista de conductors i escriurem a la hora en una línia el conductor
	* 
	* El format es el següent:
	* 
	* dni_conductor,telefon_conductor,nom_conductor
	*   
	* Tancarem el túnel del flux de dades amb fluxout.close().
	*  
	*/

	
	public void actualitzarllista(){
		File temp = new File("temp.txt");
		if (!temp.exists()){
				temp.createNewFile();
		}
		File conductors = new File("conductors.txt");
		
		try{		
			PrintWriter escribir = new PrintWriter(new FileWriter("temp.txt"));

			escribir.println(numConductors);
				for (int i = 0; i < numConductors; i++) {
					escribir.println(llista[i].getdni()+","+llista[i].getnum_telefon()+","+llista[i].getnom_conductor());
				}
			escribir.close();
			conductors.delete();
			temp.renameTo(conductors);
				
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	
}
