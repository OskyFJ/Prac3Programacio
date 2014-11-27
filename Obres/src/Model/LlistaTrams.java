package Model;

/**
 * 
 * @author Julián
 *
 */
public class LlistaTrams {
	private Tram llistaTrams[];
	private int numTrams;
	
	/**Constructor sense paràmetres 
	 * que crea una llista de 10 trams
	 */
	public LlistaTrams(){
		llistaTrams=new Tram[10];
		numTrams=0;
	}
	
	/**Constructor amb paràmetres,
	 * se li passa el número de trams,
	 * per a crear una llista de numTrams+1
	 */
	public LlistaTrams(int numTrams){
		llistaTrams=new Tram[numTrams+1];
		this.numTrams=numTrams;
	}
	
	/**Constructor amb paràmetres,
	 * se li passa l'array tram.
	 * @param tram
	 */
	public LlistaTrams(Tram[] tram){
		numTrams=tram.length;
		llistaTrams=new Tram[numTrams+1];
	}
	
	/**Getter de llistaTrams
	 * 
	 * @return
	 */
	public Tram[] getLlistaTrams(){
		return llistaTrams;
	}
	
	/**Mètode per a afegir el tram "element" a la llista.
	 * @param element que es el tram a afegir
	 */
	public void afegeixTram(Tram element){
		if(llistaTrams.length == numTrams){		// Si la llista està plena, la redimensionem
			redimensionarLlistaTrams();			// per a afegir el nou tram.
			llistaTrams[numTrams]=element;
			numTrams++;
		} 
		if(llistaTrams.length > numTrams){			// Si la llista encara no està plena
			for(int i=0; i<numTrams; i++)			// busquem la primera posició buida
				if(llistaTrams[i]==null){			// i en aquesta posició fiquem el nou tram
				llistaTrams[i]=element;}
		}
		numTrams++;
	}
	
	/**Mètode per a redimensionar la llista de trams
	 * utilitza una llista auxiliar per a copiar la llista
	 * i ampliar una posició més aquesta llista
	 */
	public void redimensionarLlistaTrams(){
		Tram llistaAux[] = new Tram[numTrams+1];
		for(int i=0; i<numTrams; i++)
			llistaAux[i] = llistaTrams[i];
		llistaTrams = llistaAux;
	}
	
	/**Getter del número de trams
	 * 
	 * @return el número de trams actuals
	 */
	public int getNumTrams(){
		return numTrams;
	}
	
	/**Mètode per a esborrar un tram i redimensionar la llista de Trams
	 * 
	 * @param element que es el tram a esborrar
	 */
	public void esborraTram(Tram element){
		//pendent de llençar una excepcio de no trobat!!!!!!
		for(int i=0; i<numTrams; i++){
			if(llistaTrams[i].equals(element)){
				for(int j=0; j<numTrams-1; j++)
					llistaTrams[j] = llistaTrams[j+1];
				llistaTrams[--numTrams] = null;
				break;
			}
		}
		
		if(numTrams < llistaTrams.length/2){
			Tram llistaAux[] = new Tram[numTrams+5];
			for(int i=0; i<numTrams; i++){
				llistaAux[i] = llistaTrams[i];
			}
			llistaTrams = llistaAux;
		}
	}
	
	/**Mètode que retorna el tram a la posició n
	 * 
	 * @param n posició del tram a la llistaTrams[]
	 * @return
	 */
	public Tram getElementNum(int n){
		if(n<0 || n>=numTrams) return null;				// Pendent de llençar excepció!!!!!
		return llistaTrams[n];
	}
}