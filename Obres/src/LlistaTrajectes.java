// import .Trajecte; falta posar el nom del Package !!!!!!!!!!!!!!!

/**
 * 
 * @author Oriol
 *
 */
public class LlistaTrajectes {
	private Trajecte[] llista;
	private int numTrajectes;
	
	/**
	 * constructor buit de la llista
	 */
	public LlistaTrajectes(){
		llista = new Trajecte[10];
		numTrajectes = 0;
		System.out.println("Llista inicial té 10 espais");
	}
	
	/**
	 * Constructor on l'usuari indica l'espai de la llista
	 * @param nTrajectes espai de la llista indicat per l'usuari
	 */
	public LlistaTrajectes(int nTrajectes){
		llista = new Trajecte[nTrajectes+10];
		nTrajectes = 0;
		System.out.println("Llista inicial té "+(nTrajectes+10)+" espais");
	}
	
	/**
	 * Metode per afegir un nou trajecte a la llista i la redimensiona si es necesari
	 * @param element nou element a afegir
	 */
	public void afegeixElement(Trajecte element){
		if(llista.length == numTrajectes){
			System.out.println("Redimensionant llista, passa de tenir tamany total "+
		numTrajectes+" a tamany total "+ (numTrajectes+10));
			Trajecte llistaAux[] = new Trajecte[numTrajectes+10];
			for(int i=0; i<numTrajectes; i++)
				llistaAux[i] = llista[i];
			llista = llistaAux;
		} 
		
		llista[numTrajectes++] = element;
	}
	
	/**
	 * Metode per saber quants elements te la llista
	 * @return nombre de trajectes de la llista
	 */
	public int quantsElements(){ 
		return numTrajectes;
	}
	
	/**
	 * Metode que permet eliminar un element de la llista i la redimensiona si es necesari
	 * @param element Element a eliminar
	 */
	public void esborraElement(Trajecte element){ //aqui podriem llençar una excepcio de no trobat
		System.out.println("esborrant "+element);
		for(int i=0; i<numTrajectes; i++){
			if(llista[i].equals(element)){
				for(int j=0; j<numTrajectes-1; j++)
					llista[j] = llista[j+1];
				llista[--numTrajectes] = null;
				break;
			}
		}
		
		if(numTrajectes < llista.length/2){
			System.out.println("Redimensionant llista, passa de tenir tamany total "+
					llista.length +" a tamany total "+ (numTrajectes+5));
			Trajecte llistaAux[] = new Trajecte[numTrajectes+5];
			for(int i=0; i<numTrajectes; i++){
				llistaAux[i] = llista[i];
			}
			llista = llistaAux;
		}
	}
	
	/**
	 * Metode que retorna un element de la llista en concret
	 * @param n número d'element que es vol retornar
	 * @return Element que ens han demanat retornar
	 */
	public Trajecte getElementNum(int n){
		if(n<0 || n>=numTrajectes) return null; //llençar excepcio
		return llista[n];
	}
}


