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
	* CONSTRUCTOR --> rebr� per par�metre l'amplitud inicial de la llista
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
	 * M�TODES
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
	 * posici� rebuda per par�metre. El modifiquem per el conductor modificat per par�mtre.
	 * 
	 * @param posicio_conductor posicio del conductor a modificar
	 * @param conductor a modificar per l'existent en la llista
	 * 
	 */
	
	public void modificarConductor(int posicio_conductor, Conductor conductor){
		llista[posicio_conductor-1]=conductor;
	}
	
	/**
	 * buscarConductor(dni): busquem un conductor de la llista  segons el dni passat per par�metre.
	 * 
	 * @param dni del conductor que volem buscar
	 * 
	 * @return la posici� del conductor
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
	 * eliminarConductor(posicio_conductor): eliminem el conductor de la llista de la posici� que rebem per par�metre
	 * 
	 * @param posicio_conductor: posici� del conductor que volem eliminar.
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
	
	/** actualitzarLlista(): guardar� els conductor en un fitxer de text (*.txt). Nom�s caldr� crear
	* un t�nel per poder escriure (PrintWriter fitxerout = new PrintWriter(new fileWriter("temp.txt"))).
	 * 
	 * Primer de tot, escriurem en la primera l�nia amb (fitxerout.println()) el numero de conductors, per poder controlar quants conductors hi ha en la llista.
	* 
	* Despr�s, farem el recorregut de la llista de conductors i escriurem a la hora en una l�nia el conductor
	* 
	* El format es el seg�ent:
	* 
	* dni_conductor,telefon_conductor,nom_conductor
	*   
	* Tancarem el t�nel del flux de dades amb fluxout.close().
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
