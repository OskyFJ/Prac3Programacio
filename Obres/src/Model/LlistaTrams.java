package Model;

/**
 * 
 * @author Juli�n
 *
 */
public class LlistaTrams {
	private Tram llistaTrams[];
	private int numTrams;
	
	/**Constructor sense par�metres 
	 * que crea una llista de 10 trams
	 */
	public LlistaTrams(){
		llistaTrams=new Tram[10];
		numTrams=0;
	}
	
	/**Constructor amb par�metres,
	 * se li passa el n�mero de trams,
	 * per a crear una llista de numTrams+1
	 */
	public LlistaTrams(int numTrams){
		llistaTrams=new Tram[numTrams+1];
		this.numTrams=numTrams;
	}
	
	/**Constructor amb par�metres,
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
	
	/**M�tode per a afegir el tram "element" a la llista.
	 * @param element que es el tram a afegir
	 */
	public void afegeixTram(Tram element){
		if(llistaTrams.length == numTrams){		// Si la llista est� plena, la redimensionem
			redimensionarLlistaTrams();			// per a afegir el nou tram.
			llistaTrams[numTrams]=element;
			numTrams++;
		} 
		if(llistaTrams.length > numTrams){			// Si la llista encara no est� plena
			for(int i=0; i<numTrams; i++)			// busquem la primera posici� buida
				if(llistaTrams[i]==null){			// i en aquesta posici� fiquem el nou tram
				llistaTrams[i]=element;}
		}
		numTrams++;
	}
	
	/**M�tode per a redimensionar la llista de trams
	 * utilitza una llista auxiliar per a copiar la llista
	 * i ampliar una posici� m�s aquesta llista
	 */
	public void redimensionarLlistaTrams(){
		Tram llistaAux[] = new Tram[numTrams+1];
		for(int i=0; i<numTrams; i++)
			llistaAux[i] = llistaTrams[i];
		llistaTrams = llistaAux;
	}
	
	/**Getter del n�mero de trams
	 * 
	 * @return el n�mero de trams actuals
	 */
	public int getNumTrams(){
		return numTrams;
	}
	
	/**M�tode per a esborrar un tram i redimensionar la llista de Trams
	 * 
	 * @param element que es el tram a esborrar
	 */
	public void esborraTram(Tram element){
		//pendent de llen�ar una excepcio de no trobat!!!!!!
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
	
	/**M�tode que retorna el tram a la posici� n
	 * 
	 * @param n posici� del tram a la llistaTrams[]
	 * @return
	 */
	public Tram getElementNum(int n){
		if(n<0 || n>=numTrams) return null;				// Pendent de llen�ar excepci�!!!!!
		return llistaTrams[n];
	}
}