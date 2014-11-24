import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author Daniel
 *
 */
public class LlistaVies {

	private Via[] llista;
	private int numVies=0;
	
	
	public void LlistaVies(int max) {
		llista=new Via[max];
		numVies=0;
	}
	
	public void agregarVia(Via via){
		llista[numVies]=via;
		numVies++;
	}
	
	public Via[] getLlista(){
		return llista;
	}
	
	public Via getVia(String nom_via){
		Via via=null;
		
		int cont=0;
		while(cont<numVies){
			if(llista[cont].getCodiVia().equals(nom_via)) via = llista[cont];
			cont++;
		}
		return via;
	}
	
	public String getViaNumTram(String poblacio1, String poblacio2){
		String nomViaTram="";
		int cont=0;
		while(cont<numVies){
			int contTrams=0;
			while(contTrams<llista[cont].getLlistaTrams().length){
				boolean igualPoblacio1=llista[cont].getLlistaTrams()[contTrams].getPoblacio()[0].equals(poblacio1);
				boolean igualPoblacio2=llista[cont].getLlistaTrams()[contTrams].getPoblacio()[1].equals(poblacio2);
				
				if(igualPoblacio1 && igualPoblacio2) nomViaTram=llista[cont].getCodiVia()+",#"+(contTrams+1);
			}
		cont++;
		}
		return nomViaTram;
	}
	
	public void actualitzarLlista(int num_trams) throws IOException{
		File temp = new File("temp.txt");
		if (!temp.exists()){
				temp.createNewFile();
		}
		File trams = new File("trams.txt");
		
		try{		
			PrintWriter escribir = new PrintWriter(new FileWriter("temp.txt"));
			escribir.println(llista.length+","+num_trams);
			for (int i = 0; i < numVies; i++) {
				String via="";
				via+=llista[i].getLlistaTrams().length+",";
				int numTrams=0;
				while(numTrams<llista[i].getLlistaTrams().length){
					if(llista[i].getLlistaTrams().length==1){
						via+=llista[i].getLlistaTrams()[numTrams].getPoblacio()[0]+","+llista[i].getLlistaTrams()[numTrams].getPoblacio()[1];
					}
					else{
						via+=","+llista[i].getLlistaTrams()[numTrams].getPoblacio()[1];
					}
				numTrams++;
				}
				escribir.println(llista[i].getCodiVia()+","+llista[i].getTipusVia().toString().toLowerCase()+","+via);
			}
		escribir.close();
		trams.delete();
		temp.renameTo(trams);
			
		}catch(IOException e){
			System.err.println(e);
		}
	}
}
	/*
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
		*/