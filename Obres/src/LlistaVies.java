/**
 * 
 * @author Daniel
 *
 */
public class LlistaVies {
	private Via[] llista;
	private int numVies=0;

	public LlistaVies(){
		llista = new Via[10];
		numVies = 0;
	}	
		
		public LlistaVies(int numVies){
			llista = new Via[numVies+10];
			numVies = 0;
			
		}

		
		public void afegeixVia(Via element){
			if(llista.length == numVies){
				
				Via llistaAux[] = new Via[numVies+10];
				for(int i=0; i<numVies; i++)
					llistaAux[i] = llista[i];
				llista = llistaAux;
			}
			llista[numVies++] = element;
		}

		
		public void esborraElement(Via element){ //aqui podriem llençar una excepcio de no trobat
			System.out.println("esborrant "+element);
			for(int i=0; i<numVies; i++){
				if(llista[i].equals(element)){
					for(int j=0; j<numVies-1; j++)
						llista[j] = llista[j+1];
					llista[--numVies] = null;
					break;
				}
			}
			
			if(numVies < llista.length/2){
				System.out.println("Redimensionant llista, passa de tenir tamany total "+
						llista.length +" a tamany total "+ (numVies+5));
				Via llistaAux[] = new Via[numVies+5];
				for(int i=0; i<numVies; i++){
					llistaAux[i] = llista[i];
				}
				llista = llistaAux;
			}
			
			
		}
		
		public Via getNumElements(int n){
			if(n<0 || n>=numVies) return null; //llençar excepcio
			return llista[n];
		}	
			
			
			
		}
		






