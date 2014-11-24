import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author Oriol
 *
 */
public class Tram {
	//private Via via; //atribut extra perque cada via ja coneix els seus trams NO TOCAR ATRIBS EXTRA DE MOMENT
	private int nTram;
	private String poble1;
	private String poble2;
	//private LlistaTrajectes llistaTrajectes; //atribut extra perque cada trajecte ja coneix els seus trams
	//private Incidencia incidencia; //atribut extra perque cada incidencia ja coneix el seu tram
	
	public Tram (int nTram, String poble1, String poble2){
		this.nTram=nTram;
		this.poble1=poble1;
		this.poble2=poble2;		
	}

	public int getnTram() {
		return nTram;
	}
	
	public String getPoblacions() {
		return ("Aquest tram uneix les poblacions "+poble1+" i "+poble2);
	}
	
	public boolean correlative(Tram t2){
		boolean areCorrelative=false;
		if(poble1.equals(t2.poble1))
			areCorrelative=true;
		if(poble1.equals(t2.poble2))
			areCorrelative=true;
		if(poble2.equals(t2.poble1))
			areCorrelative=true;
		if(poble2.equals(t2.poble2))
			areCorrelative=true;
		return areCorrelative;	
	}
	
	public String toString() {
		return "Tram [nTram=" + nTram + ", poble1=" + poble1 + ", poble2="
				+ poble2 + "]";
	}
   
	public void actualitzarLlista(LlistaVies llistaVies) throws IOException{
		File temp = new File("temp.txt");
		if (!temp.exists()){
				temp.createNewFile();
		}
		File trams = new File("trams.txt");
		
		try{		
			PrintWriter escribir = new PrintWriter(new FileWriter("temp.txt"));

			escribir.println(numTrajectes);
				for (int i = 0; i < numTrajectes; i++) {
					String vies="";
					int numTrams=0;
					while(numTrams<llista[i].getTrams().length){
						vies+=llistaVies.getViaNumTram(llista[i].getTrams()[numTrams].getPoblacio()[0], llista[i].getTrams()[numTrams].getPoblacio()[1]);
					numTrams++;
					}
					int num_trams=0;
					StringTokenizer token = new StringTokenizer(vies, ",");
					while(token.nextToken()!=null){
						num_trams++;
					}
					num_trams=num_trams/2;
					escribir.println(llista[i].getNomConductor()+","+llista[i].getNomTrajecte()+","+num_trams+","+vies);
				}
			escribir.close();
			trams.delete();
			temp.renameTo(trams);
				
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
}
