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
	public int getNumIncidencies() {
		return numIncidencies;
	}

	public void setNumIncidencies(int numIncidencies) {
		this.numIncidencies = numIncidencies;
	}

	private Incidencia[] llista;
	private int numIncidencies;

	public LlistaIncidencies(int max){
		llista=new Incidencia[max];
		numIncidencies=0;
	}
	
	public Incidencia[] getllista(){
		return llista;
	}
	
	public Incidencia buscarIncidenciaTram(Tram tram){
		Obra obra=null;
		Accident accident=null;
		Obra obraLlista=null;
		Accident accidentLlista=null;
		Obra obraBuscar=null;
		Accident accidentBuscar=null;
		int cont=0;
		String poblacio1=tram.getPoblacio()[0];
		String poblacio2=tram.getPoblacio()[1];
		
		while(cont<numIncidencies){
			
			if(llista[cont] instanceof Obra) obraLlista = (Obra) llista[cont]; 
			else accidentLlista = (Accident) llista[cont]; 
				
			boolean igualPoblacio1=llista[cont].tramAfectat.getPoblacio()[0].equals(poblacio1);
			boolean igualPoblacio2=llista[cont].tramAfectat.getPoblacio()[1].equals(poblacio2);
			
			if(obraLlista!=null && (igualPoblacio1 && igualPoblacio2)) obraBuscar=obraLlista; 
			
			else if(accidentLlista!=null && (igualPoblacio1 && igualPoblacio2)) accidentBuscar=accidentLlista;
			
			obraLlista=null;
			accidentLlista=null;
		cont++;
		}
		if(obraBuscar!=null) return obraBuscar;
		else if(obraBuscar!=null) return accidentBuscar;
		else return null;
		
		
	}
	
	public Incidencia[] buscarIncidenciaVia(String via){
		int cont=0;
		Incidencia[] incidencies = null;
		int contIncidencies=0;
		while(cont<numIncidencies){
			if(llista[cont].tramAfectat.getVia().equals(via)) contIncidencies++;	
		cont++;
		}
		cont=0;
		incidencies=new Incidencia[contIncidencies];
		contIncidencies=0;
		
		while(cont<numIncidencies){
			if(llista[cont].tramAfectat.getVia().equals(via)){
				incidencies[contIncidencies]=llista[cont];
				contIncidencies++;	
			}
		cont++;
		}
		
		return incidencies;
	}
	
	public void agregarincidencia(Incidencia incidencia){
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
	
	public void eliminarconductor(Incidencia incidencia){
		int pos=buscarincidencia(incidencia);
		Incidencia[] incidencies=new Incidencia[llista.length-1];
		int cont=0;
		int cont_i=0;
		while(cont<numIncidencies){
			if(cont!=pos){
				incidencies[cont_i]=llista[cont];
				cont_i++;
			}
			cont++;
		}
		llista=incidencies;
		numIncidencies--;
	}
	
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
							fitxerout.println((i+1)+","+obra.getDataInici()+","+obra.getDataFi()+","+obra.getTipusObra());
						}
						else{
							Accident accident = (Accident) llista[i];
							fitxerout.println((i+1)+","+accident.getData());
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
