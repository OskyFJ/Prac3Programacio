package Model;
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

	public class LlistaIncidencies {

	private Incidencia[] llista;
	private int numIncidencies;

	/**
	 * CONSTRUCTOR --> rebra per par�metre l'amplitud de la llista de incid�ncies
	 * 
	 * @param max
	 */
	
	public LlistaIncidencies(int max){
		llista=new Incidencia[max];
		numIncidencies=0;
	}
	
	/**
	 * GETTERS i SETTERS
	 * 
	 * getNumIncidencies():
	 * 
	 * @return el n�mero de incid�ncies
	 */
	
	public int getNumIncidencies() {
		return numIncidencies;
	}

	 /** getllista():
	 * 
	 * @return la llista de incid�ncies
	 */
	
	public Incidencia[] getllista(){
		return llista;
	}
	
	/**
	 * M�TODES
	 * 
	 * agregarIncidencia(): agregar una incid�ncia a la llista.
	 * 
	 */
	
	
	public void agregarIncidencia(Incidencia incidencia){
		if(numIncidencies<llista.length){
			llista[numIncidencies]=incidencia;
			numIncidencies++;
		}
		else if(numIncidencies==(llista.length)){
			Incidencia[] incidencias=new Incidencia[llista.length+10];
			int cont=0;
			while(cont<numIncidencies){
				incidencias[cont]=llista[cont];
			cont++;
			}
			incidencias[cont]=incidencia;
			numIncidencies++;
		}
		
	}
	
	/** getAccidents(): obtenim la llista de accidents
	*
	*/

	public Accident[] getAccidents(){
		Accident[] accidents;
		int cont=0;
		int contaccident=0;
		while(cont<numIncidencies){
			if(llista[cont] instanceof Accident) contaccident++;
		cont++;
		}
		cont=0;
		accidents=new Accident[contaccident];
		contaccident=0;
		while(cont<numIncidencies){
			if(llista[cont] instanceof Accident){
				accidents[contaccident]=(Accident)llista[cont];
				contaccident++;
			}
		cont++;
		}
	return accidents;
	}
	
	/** getObres(): obtenim la llista de Obres
	*
	*/

	public Obra[] getObres(){
		Obra[] obres;
		int cont=0;
		int contobres=0;
		while(cont<numIncidencies){
			if(llista[cont] instanceof Obra) contobres++;
		cont++;
		}
		cont=0;
		obres=new Obra[contobres];
		contobres=0;
		while(cont<numIncidencies){
			if(llista[cont] instanceof Obra){
				obres[cont]=(Obra)llista[cont];
				contobres++;
			}
		cont++;
		}
	return obres;
	}
	
	 /** posicioincidencia(incidencia): busquem la posicio d'una incidencia passada per
	 * par�metre. Si no existeix, retornar� -1. modifiquem una obra de la llista. Sempre pot passar que la data
	 * de inici o de finalitzaci� s'avanci o s'en
	 *
	 * @param incidencia incid�ncia que volem buscar.
	 * 
	 */
	
	public int posicioincidencia(Incidencia incidencia){
		int pos=-1;
		int cont=0;
		while(cont<numIncidencies){
			boolean igualtram=llista[cont].tramAfectat.correlative(incidencia.tramAfectat);
			if(igualtram) pos=cont;
		cont++;
		}
		
		return pos;
	}
	
	 /** modificarIncidencia(posicio_incidencia, incidencia): modifiquem una obra de la llista. Sempre pot passar que la data
	 * de inici o de finalitzaci� s'avanci o s'endarrereixi. Podrem modificar aquesta/aquestes 
	 * data/dates.
	 * 
	 * @param posicio_incidencia posici� de la incid�ncia on es vol modificar.
	 * @param incidencia incid�ncia que es vol modificar.
	 * 
	 */
	
	public void modificarIncidencia(int posicio_incidencia, Incidencia incidencia){
		llista[posicio_incidencia-1]=incidencia;
	}
	
	 /** eliminarIncidencia(posicio_incidencia): eliminar la incidencia de la llista. 
	  * Creem una llista amb una longitud menor que la de la propia classe. Fiquem en la 
	  * nova llista totes les incidencies, menys la posicio de la llista que passem per 
	  * par�metre.
	  * 
	  * Atribuim la nova llista a la llista de la propia classe.
	  * 
	 * @param posicio_incidencia posicio de la llista de incidencies ones vol modificar.
	 * 
	 */

	
	public void eliminarIncidencia(int posicio_incidencia){
		Incidencia[] incidencies=new Incidencia[llista.length-1];
		int cont=0;
		int cont_i=0;
		while(cont<numIncidencies){
			if(cont!=posicio_incidencia){
				incidencies[cont_i]=llista[cont];
				cont_i++;
			}
			cont++;
		}
		llista=incidencies;
		numIncidencies--;
	}
	
	 /** buscarIncidencia(tram): busquem una incid�ncia segons el tram passat per par�metre. 
	 * 
	 * @param tram que tenim que comparar amb el tram afectat de les incid�ncies.
	 * 
	 */

	
	public Incidencia buscarIncidenciaTram(Tram tram){
		int cont=0;
		int pos=-1;
		while(cont<numIncidencies){
			boolean igualtram=llista[cont].tramAfectat.correlative(tram);
			if(igualtram) pos=cont;
		cont++;
		}
		return llista[pos];
	}
	
	 /** buscarIncidenciaVia(via): retornar� totes les incid�ncies de la via passada per par�metre. 
	 * 
	 * @param via que tenim que comparar amb les vies afectades pels incidents.
	 * 
	 */

	
	public Incidencia[] buscarIncidenciaVia(String via){ //DIRECTOR: el metode s'hauria de dir buscar IncidenciES
		int cont=0;
		Incidencia[] incidencies = null;
		int contIncidencies=0;
		while(cont<numIncidencies){
			//if(llista[cont].tramAfectat.getVia().equals(via)) contIncidencies++; DIRECTOR:
		cont++; //Encara no es pot fer un "getVia" pero ara ja he activat els parametres extres pk es pugui fer directament
		}
		cont=0;
		incidencies=new Incidencia[contIncidencies];
		contIncidencies=0;
		
		while(cont<numIncidencies){
			/*if(llista[cont].tramAfectat.getVia().equals(via)){
				incidencies[contIncidencies]=llista[cont];
				contIncidencies++;	
			}*/
		cont++;
		}
		
		return incidencies;
	}
	
	 /** buscarIncidenciaTrajecte(conductor): retornar� totes un/unes incid�ncies si el tram afectat 
	 * de les incid�ncies, concorden amb els trams que utilitzen els conductors en els seus trajectes 
	 * habituals. 
	 * 
	 * @param conductor: agafarem els trams del seus trajectes per comparar-los amb els trams afectats per incidents.
		 
	*/

	
	public Incidencia[] getIncidenciaTrajecte(Conductor conductor){ //trobo que es un metode massa llarg pero de moment fem k funcioni
		Incidencia[] incidencies=null; //DIRECTOR: i aquest array pke?
		
//		Trajecte[] trajectes = conductor.getTrajectes(); //DIRECTOR: les operacions sobre la llista son metodes a la classe "llistaTrajectes"
						// sempre pots escriureli o fer k escrigui el titol dels metodes i aix� ja compila lo teu
				//sempre tot lo k necessitis metodes a saco
		int cont=0;
		int contTrajectes=0;
		int contTrams=0;
		int contIncidencies=0;
		
		while(cont<numIncidencies){
			Tram tram = llista[cont].tramAfectat;
			/*while(contTrajectes<conductor.getTrajectes().length){ //DIRECTOR: metode "quantsTrajectes()" de "conductor"
				Tram[] trams = trajectes[contTrajectes].getTrams();
				while(contTrams<trams.length){
					//boolean igualPoblacio1=trajectes[contTrajectes].getTrams().getPoblacio()[0].equals(tram.getPoblacio()[0]);
					//boolean igualPoblacio2=trajectes[contTrajectes].getTrams().getPoblacio()[1].equals(tram.getPoblacio()[1]);;
					//if(igualPoblacio1 && igualPoblacio2) contIncidencies++;
					// DIRECTOR: aquests carros! xD encapsulaci�! :)
				contTrams++;
				}
				contTrajectes++;				
				contTrams=0;
			}*/
			cont++;
			contTrajectes=0;
			contTrams=0;
		}
		cont=0;
		contTrajectes=0;
		contTrams=0;
		
		incidencies=new Incidencia[contIncidencies];
		contIncidencies=0;
			
		
		while(cont<numIncidencies){
			Tram tram = llista[cont].tramAfectat;
		/*	while(contTrajectes<conductor.getTrajectes().length){
				Tram[] trams = trajectes[contTrajectes].getTrams();
				while(contTrams<trams.length){
					boolean igualPoblacio1=trajectes[contTrajectes].getTrams().getPoblacio()[0].equals(tram.getPoblacio()[0]);
					boolean igualPoblacio2=trajectes[contTrajectes].getTrams().getPoblacio()[1].equals(tram.getPoblacio()[1]);;
					if(igualPoblacio1 && igualPoblacio2){
						incidencies[contIncidencies]=llista[cont];
						contIncidencies++;
					}
				contTrams++;
				}
				contTrajectes++;				
				contTrams=0;
			}*/
			cont++;
			contTrajectes=0;
			contTrams=0;
		}
		
		return incidencies;
	}
	
	/** actualitzarLlista(): guardar� les incid�ncies en un fitxer de text (*.txt). Nom�s caldr� crear
	 * un t�nel per poder escriure (PrintWriter fitxerout = new PrintWriter(new fileWriter("temp.txt"))).
	 * 
	 * Primer de tot, escriurem en la primera l�nia amb (fitxerout.println()) el numero de incid�ncies, 
	 * per poder controlar quantes incid�ncies hi ha en la llista.
	 * 
	 * Despr�s, farem el recorregut de la llista de incid�ncies. Si la incid�ncia es una obra,  es guardar� 
	 * amb el seg�ent format:
	 * 
	 *  Codi_incid�ncia,obra,tipus_obra, data_inici, data_finalitzaci�
	 *
	 *  Si la incidencia es un accident es guardar� amb el seg�ent format:
	 *  
	 *  Codi_inicd�ncia,accident,data_accident 
	 *  
	 *  Tancarem el tunel del fluxe de dade amb fluxout.close().
	 *  
	 */

	
	public void actualitzarLlista() throws IOException{
		File temp = new File("temp.txt");
		if (!temp.exists()){
			temp.createNewFile();
		}
		File incidencies = new File("trajectes.txt");
		if(!incidencies.exists()){
			incidencies.createNewFile();
		}
		
		try{		
		PrintWriter fitxerout = new PrintWriter(new FileWriter("temp.txt"));
			if(numIncidencies!=0){
				fitxerout.println(numIncidencies);
					for (int i = 0; i < numIncidencies; i++) {
						if(llista[i] instanceof Obra){
							Obra obra = (Obra) llista[i];
							fitxerout.println();//((i+1)+","+obra.getDataInici()+","+obra.getDataFi()+","+obra.getTipusObra());
							//DIRECTOR: aqu� el que hauries de fer s� o s� �s un m�tode "String getInfo()" que retorni aquest carro
						}
						else{
							Accident accident = (Accident) llista[i];
						//	fitxerout.println((i+1)+","+accident.getData()); //getDataAccident()!!
						}
					}
				fitxerout.close();
				incidencies.delete();
				temp.renameTo(incidencies);
			}
		
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
}
