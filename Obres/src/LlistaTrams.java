import llistes.Tram;

/**
 * 
 * @author Julián
 *
 */
public class LlistaTrams {
	private Tram llistaTrams[];
	private int numTrams;
	
	public LlistaTrams(){								// Definim la llista de trams
		llistaTrams=new Tram[100];
		numTrams=0;
	}
	
	public LlistaTrams(int numTrams){					// Definim la llista de trams amb paràmetres
		llistaTrams=new Tram[numTrams+10];
		numTrams=0;
	}
	public Tram[] getLlistaTrams(){
		return llistaTrams;
	}
	public void afegeixTram(Tram element){				// Mètode per a afegir el tram "element" a la llista, està fet amb una ampliació de 10
		if(llistaTrams.length == numTrams){				// elements per a que mai ens surti de la llista, així evitem errors
			Tram llistaAux[] = new Tram[numTrams+10];
			for(int i=0; i<numTrams; i++)
				llistaAux[i] = llistaTrams[i];
			llistaTrams = llistaAux;
		} 
	}
	public int getNumTrams(){ 							// Getter que retorna el número de trams
		return numTrams;
	}
	
	public void esborraTram(Tram element){ 				// Mètode per a esborrar un tram i redimensionar la llista de Trams
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
	public Tram getElementNum(int n){
		if(n<0 || n>=numTrams) return null;				// Pendent de llençar excepció!!!!!
		return llistaTrams[n];
	}
}
