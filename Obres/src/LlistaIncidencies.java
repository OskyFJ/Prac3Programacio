/**
 * 
 * @author Xavi
 *
 */
public class LlistaIncidencies {
	private Incidencia[] llista;
	private int numIncidencies;

	public LlistaIncidencies(int max){
		llista=new Incidencia[max];
		numIncidencies=0;
	}
	
	public Incidencia[] getllista(){
		return llista;
	}
	
	public int buscarincidencia(Incidencia incidencia){
		int cont=0;
		int pos=-1;
		while(cont<numIncidencies){
			if(llista[cont].getnomtrajecte().equals(nomtrajecte)) pos=cont;
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
	
}
