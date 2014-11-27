package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author Oriol
 *
 */
public class Main_Administrador {
	
	public static LlistaConductors llistaConductors;
	public static LlistaIncidencies llistaIncidencies;
	public static LlistaVies llistaVies;
	public static LlistaTrajectes llistaTrajectes;
	public static LlistaTrams llistaTrams;
	static String[] poblacions=new String[23];
	
public static void Administrador() throws IOException{
		
		BufferedReader leer = new BufferedReader(new FileReader("trams.txt"));
		String linea=leer.readLine();
		StringTokenizer tok = new StringTokenizer(linea, ",");
		int numVies=Integer.parseInt(tok.nextToken());
		int numTrams=Integer.parseInt(tok.nextToken());
		
		llistaIncidencies = new LlistaIncidencies(100);
		llistaTrams=new LlistaTrams(numTrams);
		llistaVies=new LlistaVies(numVies);
		BufferedReader leer1 = new BufferedReader(new FileReader("conductors.txt"));
		int numConductors=Integer.parseInt(leer1.readLine());
		llistaConductors=new LlistaConductors(numConductors);
		BufferedReader leer2 = new BufferedReader(new FileReader("trajectes.txt"));
		int numTrajectes=Integer.parseInt(leer2.readLine());
		llistaTrajectes=new LlistaTrajectes(numTrajectes);
		carregarTrams();
		carregarConductors();
		//agregarpoblacions();
		carregarTrajectes();
		leer.close();
		leer1.close();
		leer2.close();
		poblacions();
	}

	public static void poblacions(){
		int contPob=0;
		int numVies=0;
		int numTrams=0;
		int contVies=0;
		int contTrams=0;
		int contPobTram=0;
		int numPobTram=2;
		Via[] vies=llistaVies.getLlista();
		numVies=vies.length;
		
		while(contVies<numVies){
			Tram[] tramsVia=vies[contVies].getLlistaTrams().getLlistaTrams();
			numTrams=vies[contVies].getLlistaTrams().getNumTrams();
			if(contVies==0){
				while(contTrams<numTrams){
					while(contPobTram<numPobTram){
					String[] poblacio=tramsVia[contTrams].getPoblacio();
					poblacions[contPob]=poblacio[contPobTram];
					contPob++;
					contPobTram++;
					}
				contPobTram=0;
				contTrams++;
				}
			}
			else{
				if(contPob<23){
					while(contTrams<numTrams){
						String[] poblacio=tramsVia[contTrams].getPoblacio();
						while(contPobTram<numPobTram){
							int cont_1=0;
							boolean trobat=false;
							while(cont_1<contPob && !trobat){
								if(poblacions[cont_1].equals(poblacio[contPobTram])) trobat=true;
							cont_1++;
							}
							if(!trobat && contPob<23){
								poblacions[contPob]=poblacio[contPobTram];
								contPob++;
							}
							contPobTram++;
						}
						contTrams++;
						contPobTram=0;					
					}	
				}
				
			}
		contPobTram=0;
		contTrams=0;
		contVies++;
		}
	}
	
	public static String[] actpoblacions(String[] poblacio, int cont) {
		String[] poblacions_1=new String[poblacions.length-cont];
		int cont_1=0;
		int cont_p=0;
		while(cont_1<poblacions.length && cont_p<poblacions_1.length){
			int cont_2=0;
			boolean trobat=false;
			while(cont_2<poblacio.length && !trobat){
				if(poblacio[cont_2].equals(poblacions[cont_1])) trobat=true;
			cont_2++;
			}
			if(!trobat){
				poblacions_1[cont_p]=poblacions[cont_1];
				cont_p++;
			}
		cont_1++;
		}
		return poblacions_1;
	}

	public static void carregarTrams() {
		String linia, nom_via, tipus;
		int num_trams;
		String[] poblacio=new String[2];
		int cont_t=0;
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("trams.txt"));
			String linea = f1.readLine();
			StringTokenizer tok = new StringTokenizer(linia, ",");
			int numVies = Integer.parseInt(tok.nextToken());
			int numTrams = Integer.parseInt(tok.nextToken());
			LlistaTrams llista;
			for (int i = 0; i < numVies; i++) {
				
				linia = f1.readLine();
				tok = new StringTokenizer(linia, ",");
				nom_via = tok.nextToken();
				tipus=tok.nextToken();
				int numTramsVia = Integer.parseInt(tok.nextToken());			
				Tram[] trams=new Tram[numTrams];
				int cont=0;								
				String pob_antigua, poblacio1, poblacio2 = null;
				Tram[] trams_t=new Tram[numTramsVia];
				while(cont<numTramsVia){
					int cont_poblacion=0;
					if(cont==0){
						while(cont_poblacion<2){	
							poblacio[cont_poblacion]=tok.nextToken();
							if(cont==0 && cont_poblacion==0) poblacio1=poblacio[cont_poblacion];
							if(cont_poblacion==1){
								pob_antigua=poblacio[cont_poblacion];
							}
						cont_poblacion++;
						}
					}
					else{
						while(cont_poblacion<2){
							if(cont_poblacion==0){
								poblacio[cont_poblacion]=pob_antigua;
								pob_antigua=poblacio[cont_poblacion];
							}
							else poblacio[cont_poblacion]=tok.nextToken();
							if(cont==numTramsVia-1 && cont_poblacion==1) poblacio2=poblacio[cont_poblacion];
						cont_poblacion++;
						}
					}
					trams_t[cont]=new Tram(cont,poblacio[0],poblacio[1]);
					trams[cont_t]=new Tram(cont_t,poblacio[0],poblacio[1]);
					llistaTrams.afegeixTram(trams[cont_t]);
					cont_t++;
				cont++;
				cont_poblacion=0;
				}
			TipusVia tipusV;
			if(tipus.equals("autovia")) tipusV=TipusVia.AUTOVIA;
			if(tipus.equals("autopista")) tipusV=TipusVia.AUTOVIA;
			if(tipus.equals("nacional")) tipusV=TipusVia.NACIONAL;
			if(tipus.equals("altres")) tipusV=TipusVia.ALTRES;

			llista= new LlistaTrams(trams_t);
			Via via=new Via(poblacio1,poblacio2,tipusV,nom_via,llista);
			llistaVies.agregarVia(via);
			cont=0;
					
		}
			f1.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: no s'ha trobat el fitxer");
		} catch (IOException e) {
			System.out.println("ERROR: " + e);}
		}
	
	public static void carregarConductors() {
			String linia, codi, nom_conductor;
			int telefon;		
			try {
				BufferedReader f1 = new BufferedReader(new FileReader(
						"conductors.txt"));
				int max = Integer.parseInt(f1.readLine());
				for (int i = 0; i < max; i++) {
					linia = f1.readLine();
					StringTokenizer tok = new StringTokenizer(linia, ",");
					codi = tok.nextToken();
					telefon = Integer.parseInt(tok.nextToken());
					nom_conductor=tok.nextToken();
					Conductor conductor = new Conductor(codi, nom_conductor,telefon);
					llistaConductors.agregarconductor(conductor);
				}
				f1.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: no s'ha trobat el fitxer");
			} catch (IOException e) {
				System.out.println("ERROR: " + e);
			}
		}
	
	public static void carregarTrajectes() {
		String linia, codi, nom_trajecte;
		try {
		BufferedReader f1 = new BufferedReader(new FileReader("trajectes.txt"));
		int max = Integer.parseInt(f1.readLine());
		for (int i = 0; i < max; i++) {
			linia = f1.readLine();
			StringTokenizer tok = new StringTokenizer(linia, ",");
			codi = tok.nextToken();			
			nom_trajecte= tok.nextToken();
			int cont=0;
			int num_trams=Integer.parseInt(tok.nextToken());
			String[] trams=new String[num_trams];
			String[] vies=new String[num_trams];
			while(cont<num_trams*2){
				vies[cont]=tok.nextToken();
				trams[cont]=tok.nextToken();
				cont++;
			}
			LlistaTrams llista= new LlistaTrams(trams);
			Conductor conductor = llistaConductors.getllista()[llistaConductors.buscarConductor(codi)];
			Trajecte trajecte = new Trajecte(codi, nom_trajecte, vies, llista);
			conductor.agregarTrajecte(trajecte);
			llistaTrajectes.afegeixElement(trajecte);
		}
		f1.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: no s'ha trobat el fitxer");
		} catch (IOException e) {
			System.out.println("ERROR: " + e);
		}
			
	}
	
	
	public static void main(String[] args) throws IOException {
			
		Scanner scan = new Scanner(System.in);
			
		int opcio_admin=0;
		int opcio_client=4;
		int opcio=1;
			
		while(opcio!=2 && opcio_admin!=8 && opcio_client!=5){

		System.out.println("--------------------------------------------------------");
		System.out.println("----- BENVINGUTS A LA ADMINISTRACIÓ DE CARRETERRES -----");
		System.out.println("--------------------------------------------------------\n");

		System.out.println("1) Carregar les llistes (conductors, trajectes i trams)");
		System.out.println("2) Sortir");
		opcio=scan.nextInt();
			
			switch(opcio){
				
				case 1:
					Administrador();
					System.out.println("Les llistes s'han carregat correctament!\n");
				break;
			}
		
			while(opcio_admin!=8 || opcio_client==4){
				opcio_client=0;
				System.out.println("\n--------------------------------------------------------");
				System.out.println("----- BENVINGUTS A LA ADMINISTRACIÓ DE CARRETERRES -----");
				System.out.println("--------------------------------------------------------\n");
			
				System.out.println("1) Afegir via");
				System.out.println("2) Afegir tram");
				System.out.println("3) Gestionar incidencies (afegir o eliminar)");
				System.out.println("4) Gestionar conductors (afegir, eliminar i consultar els seus trajectes habituals)");
				System.out.println("5) Consultar trams/vies");
				System.out.println("6) Consultar trams afectats per obres");
				System.out.println("7) Consultar incidencia que es trobarà un conductor degut als seus trajectes habituals");
				System.out.println("8) Sortir del programa!");
				System.out.println("\n--------------------------------------------------");
				System.out.println("\n 9) ENTRAR COM A CONDUCTOR");
				System.out.println("\n Opcio del menu:");
				opcio_admin=scan.nextInt();
				
				switch(opcio_admin){
				case 1:
					String nom_via;
					System.out.println("Nom de la via a afegir");
					nom_via=scan.next();
					if(llistaVies.getVia(nom_via)!=null) System.out.println("Ja existeix aquesta via");
					else{
						TipusVia tipus;
						int cont=0;
						int op_t=0;
						while(op_t<1 || op_t>5){
							System.out.println("\nTipus de via: \n");
							System.out.println("1) Autovía: ");
							System.out.println("2) Autopista: ");
							System.out.println("3) Nacional: ");
							System.out.println("4) Altres: ");
							System.out.println("5) Comarcal: ");
							System.out.println("\nOpció del tipus de via: ");
							op_t=scan.nextInt();
							if(op_t<1 || op_t>5) System.out.println("Opcio incorrecta! Intenta-ho de nou! ");
						}
						if(op_t==1) tipus=TipusVia.AUTOVIA;
						if(op_t==2) tipus=TipusVia.AUTOVIA;
						if(op_t==3) tipus=TipusVia.NACIONAL;
						if(op_t==4) tipus=TipusVia.ALTRES;
						if(op_t==5) tipus=TipusVia.COMARCAL;
						
						int num_trams=0;
						while(num_trams<1 || num_trams>12){
							System.out.println("Número de trams que ho formen?");
							num_trams=scan.nextInt();
							if(num_trams<1 || num_trams>12) System.out.println("Ha de haver com a mínim un tram i com a màxim el número de poblacions - 1");
						}
						cont=0;
						
						String[] poblacio=new String[num_trams+1];
						while(cont<poblacio.length){
							poblacio[cont]="";
							cont++;
						}
						cont=0;
					
						String[] act_poblacions=poblacions;
						
						int opcio_p=0;
						while(cont<num_trams+1){
							if(cont>0) act_poblacions=actpoblacions(poblacio,cont);
							int cont_p=0;
							while(cont_p<act_poblacions.length){
								System.out.println((cont_p+1)+") "+act_poblacions[cont_p]);
							cont_p++;
							}
							opcio_p=0;
							while(opcio_p<1 || opcio_p>(cont_p+1)){
								System.out.println("\nPoblacio a escollir. Opcio? ");
								opcio_p=scan.nextInt();
								if(opcio_p<0 || opcio_p>cont_p) System.out.println("Opcio incorrecta! Intenta-ho de nou!");
							}
						poblacio[cont]=act_poblacions[opcio_p-1];
						cont++;
						}
						cont=0;
						Tram tram;
						Tram[] trams;
						while(cont<num_trams){
						String p_antigua;	
							if(cont==0){
								tram = new Tram(cont,poblacio[cont],poblacio[cont+1]);
								p_antigua=poblacio[cont+1];
							}
							else{
								tram=new Tram(cont,p_antigua,poblacio[cont+1]);
							}
						p_antigua=poblacio[cont+1];
						trams[cont]=tram;
						cont++;	
						llistaTrams.afegeixTram(tram);
						}
						
						LlistaTrams llista=new LlistaTrams(trams);
						llistaVies.agregarVia(new Via(poblacio[0],poblacio[poblacio.length-1],tipus,nom_via,llista));
					}
					break;
					
				case 2:
					
					System.out.println("Nom de la via a afegir el tram? \n");
					int cont=0;
					int opcio_via=0;
					nom_via="";
					int numVies=llistaVies.getLlista().length;
					while(opcio_via<1 || opcio_via>numVies){
						while(cont<numVies){
							nom_via = llistaVies.getLlista()[cont].getCodiVia();
							System.out.println((cont+1)+") "+nom_via);
							cont++;
						}
						System.out.println("\nOpcio de via? ");
						opcio_via=scan.nextInt();
						if(opcio_via<1 || opcio_via>numVies) System.out.println("\nOpcio de la via incorrecte! Intenta-ho de nou!\n");
					}
					nom_via= llistaVies.getLlista()[opcio_via-1].getCodiVia();
					Via via = llistaVies.getVia(nom_via);
					
					cont=0;
					Tram[] trams=via.getLlistaTrams().getLlistaTrams();
					int numTrams=via.getLlistaTrams().getLlistaTrams().length;
					String[] poblacio1=new String[1];
					String poblacio2;
					int opcio_p=0;
					System.out.println("Desde quina població vols afegir el tram? ");
					while(opcio_p<1 || opcio_p>23){
						System.out.println("Poblacions: \n");
						cont=0;
						while(cont<23){
							System.out.println((cont+1)+") "+poblacions[cont]);
						cont++;	
						}
						System.out.println("\nOpcio de la poblacio? ");
						opcio_p=scan.nextInt();
						if(opcio_p<1 || opcio_p>23) System.out.println("Numero de la poblacio incorrecte! Intenta-ho de nou!");
					}
					poblacio1[0]=poblacions[opcio_p-1];
					String[] poblacions_1=actpoblacions(poblacio1,1);
					opcio_p=0;
					System.out.println("Fins a quina població vols afegir el tram? ");
					while(opcio_p<1 || opcio_p>22){
						System.out.println("Poblacions: \n");
						cont=0;
						while(cont<22){
							System.out.println((cont+1)+") "+poblacions_1[cont]);
						cont++;	
						}
						System.out.println("\nOpcio de la poblacio? ");
						opcio_p=scan.nextInt();
						if(opcio_p<1 || opcio_p>22) System.out.println("Numero de la poblacio incorrecte! Intenta-ho de nou!");
					}
					poblacio2=poblacions_1[opcio_p-1];

					//Aqui comprovariem que no exiteixi aquest tram en la via. 
					
					//Que miri les dues poblacions, independentment de l'ordre de les poblacions.
					
					//Oriol implementa el mètode please :) :)
					
					//Si no existeix aques tram, creeem un nou tram
					
					Tram tram = new Tram(numTrams,poblacio1[0],poblacio2);
					Tram[] trams_1=new Tram[numTrams+1];
					cont=0;
					while(cont<numTrams){
						trams[cont]=trams_1[cont];
						cont++;
					}
					trams_1[cont]=tram;
					
					//Aqui faltaria un mètode per poder modificar una via.
					
					//Aqui faltaria un mètode per poder amplificar a +1 la llista de trams, per
					
					//afegir el tram.
					
					
					break;
					
				}
				
			}
			
		}
		llistaVies.actualitzarLlista(llistaTrams.getNumTrams());
		llistaConductors.actualitzarllista();
		llistaTrajectes.actualitzarLlista(llistaVies);
	}

}
