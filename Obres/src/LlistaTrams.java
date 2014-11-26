import llistes.Tram;

/**
 * 
 * @author Juli�n
 *
 */
public class LlistaTrams {
	private Tram llistaTrams[];
	private int numTrams;
	
	public LlistaTrams(){								// Definim la llista de trams
		llistaTrams=new Tram[100];
		numTrams=0;
	}
	
	public LlistaTrams(int numTrams){					// Definim la llista de trams amb par�metres
		llistaTrams=new Tram[numTrams+10];
		numTrams=0;
	}
	public Tram[] getLlistaTrams(){
		return llistaTrams;
	}
	public void afegeixTram(Tram element){				// M�tode per a afegir el tram "element" a la llista, est� fet amb una ampliaci� de 10
		if(llistaTrams.length == numTrams){				// elements per a que mai ens surti de la llista, aix� evitem errors
			Tram llistaAux[] = new Tram[numTrams+10];
			for(int i=0; i<numTrams; i++)
				llistaAux[i] = llistaTrams[i];
			llistaTrams = llistaAux;
		} 
	}
	public int getNumTrams(){ 							// Getter que retorna el n�mero de trams
		return numTrams;
	}
	
	public void esborraTram(Tram element){ 				// M�tode per a esborrar un tram i redimensionar la llista de Trams
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
	public Tram getElementNum(int n){
		if(n<0 || n>=numTrams) return null;				// Pendent de llen�ar excepci�!!!!!
		return llistaTrams[n];
	}
}
