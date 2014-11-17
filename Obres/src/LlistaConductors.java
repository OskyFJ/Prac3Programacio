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
public class LlistaConductors {
	private Conductor[] llista;
	private int numConductors;
	
	public LlistaConductors(int max){
		llista=new Conductor[max];
		numConductors=0;
	}
	
	public Conductor[] getllista(){
		return llista;
	}
	
	public boolean buscarnou(String dni){
		boolean trobat=false;
		int cont=0;
		while(cont<numConductors && !trobat){
			if(llista[cont].getdni().equals(dni)) trobat=true;
		cont++;
		}
		return trobat;
	}
	
	public void agregarconductor(Conductor conductor){
		
		if(numConductors<llista.length){
			llista[numConductors]=conductor;
			numConductors++;
		}
		else if(numConductors==(llista.length)){
			Conductor[] conductors=new Conductor[llista.length+10];
			int cont=0;
			while(cont<numConductors){
				conductors[cont]=llista[cont];
			cont++;
			}
			conductors[cont]=conductor;
			numConductors++;
		}
	}
	
	public int buscarconductor(String dni){
		int cont=0;
		int pos=-1;
		while(cont<numConductors){
			if(llista[cont].getdni().equals(dni)) pos=cont;
		cont++;
		}
		return pos;
	}
	
	public void eliminarconductor(Conductor conductor){
		int pos=buscarconductor(conductor.getdni());
		Conductor[] conductors=new Conductor[llista.length-1];
		int cont=0;
		int cont_c=0;
		while(cont<numConductors){
			if(cont!=pos){
				conductors[cont_c]=llista[cont];
				cont_c++;
			}
			cont++;
		}
		llista=conductors;
		numConductors--;
	}
	
	public void actualitzarllista(){
		File temp = new File("temp.txt");
		if (!temp.exists()){
				temp.createNewFile();
		}
		File conductors = new File("conductors.txt");
		PrintWriter escribir = new PrintWriter(new FileWriter("temp.txt"));
		
		try{
			escribir.println(numConductors);
				for (int i = 0; i < numConductors; i++) {
					escribir.println(llista[i].getdni()+","+llista[i].getnum_telefon()+","+llista[i].getnom_conductor());
				}
			escribir.close();
			conductors.delete();
			temp.renameTo(conductors);
				
		}
	}
	
	public Conductor getconductor(String dni){
		int cont=0;
		Conductor conductor=null;
		while(cont<numConductors){
			if(llista[cont].getdni().equals(dni)) conductor=llista[cont];
			cont++;
		}
		
	return conductor;
	}
	
}
