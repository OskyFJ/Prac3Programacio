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
		int cont=0;
		int pos=-1;
		Obra obra=null;
		Accident accident=null;
		Obra obraLlista=null;
		Accident accidentLlista=null;
		Obra obraBuscar=null;
		Accident accidentBuscar=null;
		
		while(cont<numIncidencies){
			if(llista[cont] instanceof Obra) obraLlista = (Obra) llista[cont]; 
			else accidentLlista = (Accident) llista[cont]; 
		
			if(accidentLlista!=null){
				boolean igualsDataInici=obra.getDataInici().equals(obraLlista.getDataInici());
				boolean igualsDataFi=obra.getDataFi().equals(obraLlista.getDataFi());
				boolean igualsTipus=obra.getTipus().equals(obraLlista.getTipus());
				if(igualsDataFi && igualsDataInici && igualsTipus) accidentBuscar=accidentLlista; 
			}
			
		cont++;
		}
		return pos;
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
							int tipus;
							System.out.println(obra.getTipusObra());
							//fitxerout.println(llista[i].getTipus());
						}
						//else fitxerout.println(llista[i].getDni()+","+llista[i].getnum_telefon()+","+llista[i].getnom_conductor());
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
