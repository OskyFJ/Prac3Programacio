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

	/*public static Tram[] trams(int cont, Tram[] tram){
		Tram[] trams_1=new Tram[tram.length-cont];
		int cont_1=0;
		int cont_t=0;
		while(cont_1<tram.length && cont_t<trams_1.length){
			int cont_2=0;
			boolean trobat=false;
			while(cont_2<tram.length && !trobat){
				if(tram[cont_2].equals(poblacions[cont_1])) trobat=true;
			cont_2++;
			}
			if(!trobat){
				poblacions_1[cont_p]=poblacions[cont_1];
				cont_p++;
			}
		cont_1++;
		}
		return poblacions_1;
	}*/

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
		int numTrams;
		int numVies;
		String[] poblacio=new String[2];
		int cont_t=0;
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("trams.txt"));
			String linea = f1.readLine();
			StringTokenizer tok = new StringTokenizer(linea, ",");
			numVies = Integer.parseInt(tok.nextToken());
			numTrams = Integer.parseInt(tok.nextToken());
			LlistaTrams llista;
			for (int i = 0; i < numVies; i++) {
				
				linia = f1.readLine();
				tok = new StringTokenizer(linia, ",");
				nom_via = tok.nextToken();
				tipus=tok.nextToken();
				int numTramsVia = Integer.parseInt(tok.nextToken());			
				Tram[] trams=new Tram[numTrams];
				int cont=0;								
				String pob_antigua = null, poblacio1 = null, poblacio2 = null;
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
			TipusVia tipusV = null;
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
			Tram[] trams=new Tram[num_trams];
			String[] vies=new String[num_trams];
			int numTram[]=new int[num_trams];
			while(cont<num_trams*2){
				vies[cont]=tok.nextToken();
				numTram[cont]=Integer.parseInt(tok.nextToken());
				trams[cont]=llistaVies.getTramVia(vies[cont],numTram[cont-1]);
				cont++;
			}
			Conductor conductor = llistaConductors.getllista()[llistaConductors.buscarConductor(codi)];
			Trajecte trajecte = new Trajecte(codi, nom_trajecte, vies);
			LlistaTrams llista = new LlistaTrams(trams);
			trajecte.setLlista(llista);
			conductor.afegirTrajecte(trajecte);
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
						TipusVia tipus = null;
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
						Tram[] trams = null;
						while(cont<num_trams){
						String p_antigua = null;	
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
					Tram[] tramsVia=via.getLlistaTrams().getLlistaTrams();
					int numTrams=tramsVia.length;
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
					
					Tram tram = new Tram(numTrams,poblacio1[0],poblacio2);

					cont=0;
					boolean trobat=false;
					while(cont<numTrams && !trobat){
						if(tramsVia[cont].correlative(tram)) trobat=true;
					cont++;
					}

					if(!trobat){
						Tram[] trams=new Tram[numTrams+1];
						cont=0;
						while(cont<numTrams){
						trams[cont]=tramsVia[cont];
						cont++;
						}
						trams[cont]=tram;					
						LlistaTrams trams_via = new LlistaTrams(trams);
						via.setLlistaTrams(trams_via);
					}
					else System.out.println("Ja existeix aquest tram en aquesta via! No la pots agregar! ");
					
					break;
					
					case 3:
						
						int opcioIncidencies=0;
						while(opcioIncidencies!=7 || opcioIncidencies<1 || opcioIncidencies>7){
							System.out.println("Gestionar incidencies: \n");
							System.out.println("1) Afegir obra");
							System.out.println("2) Afegir accident");
							System.out.println("3) Eliminar obra");
							System.out.println("4) Eliminar accident");
							System.out.println("5) Consultar Incidencia per via");
							System.out.println("6) Consultar Incidencia per tram");
							System.out.println("7) Enrere");
							System.out.println("\nOpcio del menú? ");
							opcioIncidencies=scan.nextInt();
							
							switch(opcioIncidencies){
								case 1:
								
								int o_tipus=0;
								nom_via="";
								int n_via=0;
								cont=0;
								int o_via=0;
								Via[] vies = llistaVies.getLlista();
								numVies=llistaVies.getLlista().length;
								while(n_via<1 || n_via>numVies){
									System.out.println("Via en la qual ha succeït la obra? \n");
									while(cont<numVies){
										System.out.println((cont+1)+") "+vies[cont].getCodiVia());
									cont++;
									}
									System.out.println("\nOpcio de via? ");
									o_via=scan.nextInt();
									if(n_via<1 || n_via>numVies) System.out.println("Opció de via incorrecta! Intenta-ho de nou!");
								}
								via= vies[o_via-1];
								nom_via=via.getCodiVia();
								while(o_tipus<1 || o_tipus>3){
									System.out.println("Motiu de la obra?\n ");	
									System.out.println("1) Obres per a la millora del ferm");
									System.out.println("2) Obres per a la millora dels elemnts de seguretat");
									System.out.println("3) Obres per a arreglar desperfectes d'actes vandàlics");
									System.out.println("\nOpció de tipus? ");
									o_tipus=scan.nextInt();
									if(o_tipus<0 || o_tipus>3) System.out.println("\nOpció de tipus incorrecte! Prova-ho de nou.");
								}
								
								Tram[] trams=via.getLlistaTrams().getLlistaTrams();
								numTrams=trams.length;
								System.out.println("Sobre quin tram ha succeït la obra? \n");
								cont=0;
								int o_tram=0;
								while(o_tram<1 || o_tram>numTrams){
									while(cont<numTrams){
										String[] poblacio=trams[cont].getPoblacio();
										System.out.println((cont+1)+") "+poblacio[0]+" - "+poblacio[1]);
									cont++;
									}
									System.out.println("\nOpció de tram? ");
									o_tram=scan.nextInt();
									if(o_tram<0 || o_tram>numTrams) System.out.println("\nOpció de tipus incorrecte! Prova-ho de nou.");
								}
								tram = trams[o_tram-1];
								int dia_inici=0;
								int mes_inici=0;
								int any_inici=0;
								int dia_final=0;
								int mes_final=0;
								int any_final=0;
									
								while(dia_inici<1 || dia_inici>30){
									System.out.println("Dia de inici de la obra: ");
									dia_inici=scan.nextInt();
									if(dia_inici>30 || dia_inici<0) System.out.println("Dia entre 1 - 30. Prova-ho de nou");
								}
								while(mes_inici<1 || mes_inici>12){
									System.out.println("Mes de inici de la obra: ");
									mes_inici=scan.nextInt();
									if(mes_inici>1 || mes_inici<13) System.out.println("Mes entre 1 - 12. Prova-ho de nou");
								}
								while(any_inici<2014 || any_inici>2999){
									System.out.println("Any de inici de la obra: ");
									any_inici=scan.nextInt();
									if(any_inici<2014 || any_inici>2999) System.out.println("Any entre 2014 - 2999. Prova-ho de nou");
								}
								while(dia_final<1 || dia_final>30){
									System.out.println("Dia de finalització de la obra: ");
									mes_final=scan.nextInt();
									if(dia_final>30 || dia_final<1) System.out.println("Dia entre 1 - 30. Prova-ho de nou");
								}
								while(mes_final<1 || mes_final>12){
									System.out.println("Mes de finalització de la obra: ");
									mes_final=scan.nextInt();
									if(mes_final>12 || mes_final<1) System.out.println("Mes entre 1 - 12. Prova-ho de nou");
								}
								while(any_final<2014 || any_final>2999){
									System.out.println("Any de finalització de la obra: ");
									any_final=scan.nextInt();
									if(any_final<2014 || any_final>2999) System.out.println("Any entre 2014 - 2099. Prova-ho de nou");
								}
								Data data1 = new Data(dia_inici,mes_inici,any_inici);
								Data data2 = new Data(dia_final,mes_final,any_final);
								
								Incidencia incidencia= new Obra(data1,data2,o_tipus,nom_via,tram);
								llistaIncidencies.agregarIncidencia(incidencia);
									
								break;
							
								case 2:
								
									nom_via="";
									n_via=0;
									cont=0;
									o_via=0;
									vies = llistaVies.getLlista();
									numVies=llistaVies.getLlista().length;
									while(n_via<1 || n_via>numVies){
										System.out.println("Via en la qual ha succeït el acident? \n");
										while(cont<numVies){
											System.out.println((cont+1)+") "+vies[cont].getCodiVia());
										cont++;
										}
										System.out.println("\nOpcio de via? ");
										o_via=scan.nextInt();
										if(n_via<1 || n_via>numVies) System.out.println("Opció de via incorrecta! Intenta-ho de nou!");
									}
									via= vies[o_via-1];
									nom_via=via.getCodiVia();
									trams=via.getLlistaTrams().getLlistaTrams();
									numTrams=trams.length;
									System.out.println("Sobre quin tram ha succeït l'accident? \n");
									cont=0;
									o_tram=0;
									while(o_tram<1 || o_tram>numTrams){
										while(cont<numTrams){
											String[] poblacio=trams[cont].getPoblacio();
											System.out.println((cont+1)+") "+poblacio[0]+" - "+poblacio[1]);
										cont++;
										}
										System.out.println("\nOpció de tram? ");
										o_tram=scan.nextInt();
										if(o_tram<0 || o_tram>numTrams) System.out.println("\nOpció de tipus incorrecte! Prova-ho de nou.");
									}
									tram = trams[o_tram-1];
									int dia=0;
									int mes=0;
									int any=0;
										
									while(dia<1 || dia>30){
										System.out.println("Dia del accident? ");
										dia=scan.nextInt();
										if(dia>30 || dia<0) System.out.println("Dia entre 1 - 30. Prova-ho de nou");
									}
									while(mes<1 || mes>12){
										System.out.println("Mes del accident?");
										mes=scan.nextInt();
										if(mes>1 || mes<13) System.out.println("Mes entre 1 - 12. Prova-ho de nou");
									}
									while(any<2014 || any>2999){
										System.out.println("Any del accident: ");
										any=scan.nextInt();
										if(any<2014 || any>2999) System.out.println("Any entre 2014 - 2999. Prova-ho de nou");
									}
									Data data = new Data(dia,mes,any);
									incidencia = new Accident(data,tram,nom_via);
									llistaIncidencies.agregarIncidencia(incidencia);
									
								break;
								
								case 3 :
									
									System.out.println("Obra a eliminar? \n");
									cont=0;
									int opcio_ob=0;
									Obra[] obres = llistaIncidencies.getObres();
									int numObres=obres.length;
									while(opcio_ob<1 || opcio_ob>numObres){
										while(cont<numObres){
											System.out.println((cont+1)+"1) "+obres[cont]+"\n");
											cont++;
										}
									System.out.println("\nNúmero de la obra a esborrar?");
									opcio_ob=scan.nextInt();
										if(opcio_ob<1 || opcio_ob>numObres) System.out.println("Opcio de obra incorrecta! Intenta-ho de nou!\n");
									}
									Obra obra = obres[opcio_ob-1];
									int pos = llistaIncidencies.posicioincidencia(obra);
									llistaIncidencies.eliminarIncidencia(pos);
								
								break;
								
								case 4:
									
									System.out.println("Accident a eliminar? \n");
									cont=0;
									int opcio_ac=0;
									Accident[] accidents = llistaIncidencies.getAccidents();
									int numAccidents=accidents.length;
									while(opcio_ac<1 || opcio_ac>numAccidents){
										while(cont<numAccidents){
											System.out.println((cont+1)+"1) "+accidents[cont]+"\n");
											cont++;
										}
									System.out.println("\nNúmero del accident a esborrar?");
									opcio_ac=scan.nextInt();
										if(opcio_ac<1 || opcio_ac>numAccidents) System.out.println("Opcio de accident incorrecta! Intenta-ho de nou!\n");
									}
									Accident accident = accidents[opcio_ac-1];
									pos = llistaIncidencies.posicioincidencia(accident);
									llistaIncidencies.eliminarIncidencia(pos);
								
								break;
								
								case 5:
									
									nom_via="";
									n_via=0;
									cont=0;
									o_via=0;
									vies = llistaVies.getLlista();
									numVies=llistaVies.getLlista().length;
									while(n_via<1 || n_via>numVies){
										System.out.println("Via en la qual ha succeït el acident? \n");
										while(cont<numVies){
											System.out.println((cont+1)+") "+vies[cont].getCodiVia());
										cont++;
										}
										System.out.println("\nOpcio de via? ");
										o_via=scan.nextInt();
										if(n_via<1 || n_via>numVies) System.out.println("Opció de via incorrecta! Intenta-ho de nou!");
									}
									via= vies[o_via-1];
									nom_via=via.getCodiVia();
									Incidencia[] incidencies = llistaIncidencies.buscarIncidenciaVia(nom_via);
									int numIncidencies=incidencies.length;
									cont=0;
									if(incidencies.length!=0){
										System.out.println("Incidències en la via '"+nom_via+"'");
										while(cont<numIncidencies){
											System.out.println(incidencies[cont]+"\n");
										cont++;
										}
									}
									else System.out.println("No existeix cap incidència en la via '"+nom_via+"'");
								
								break;
								
								case 6:
									
									trams= Main_Administrador.llistaTrams.getLlistaTrams();
									numTrams=trams.length;
									System.out.println("Sobre quin tram vols consultar l'incidència? \n");
									cont=0;
									o_tram=0;
									while(o_tram<1 || o_tram>numTrams){
										while(cont<numTrams){
											String[] poblacio=trams[cont].getPoblacio();
											System.out.println((cont+1)+") "+poblacio[0]+" - "+poblacio[1]);
										cont++;
										}
										System.out.println("\nOpció de tram? ");
										o_tram=scan.nextInt();
										if(o_tram<0 || o_tram>numTrams) System.out.println("\nOpció de tipus incorrecte! Prova-ho de nou.");
									}
									tram = trams[o_tram-1];
									incidencia = llistaIncidencies.buscarIncidenciaTram(tram);
									if(incidencia==null) System.out.println("No existeix cap incidencia en aquest tram");
									else{
										System.out.println("Incidència en aquest tram: \n");
										System.out.println(incidencia+"\n");
									}
									
								break;
									
								default: System.out.println("Opcio incorrecta! Intenta-ho de nou! \n");
									
								break;
								
								}
							}

							
					
					break;
					
					case 4:
						
						int opcio_c=0;
						while(opcio_c<1 || opcio_c>5){
							
							Conductor[] conductors = llistaConductors.getllista();
							int numConductors=conductors.length;
							
							System.out.println("Gestionar conductors:\n");
							System.out.println("1) Consultar dades d'un conductor: ");
							System.out.println("2) Consultar trajectes habituals d'un conductor: ");
							System.out.println("3) Eliminar trajecte habitual d'un conductor: ");
							System.out.println("4) Consultar les dades dels conductors: ");
							System.out.println("5) Consultar trajectes habituals dels conductors");
							System.out.println("6) Eliminar un trajecte habitual dels conductors");
							System.out.println("\nOpcio del menú?: ");
							opcio_c=scan.nextInt();
							
							switch(opcio_c){
							
								case 1:
								
								cont=0;
								int num_c=0;
								while(num_c<1 || num_c>numConductors){
									while(cont<numConductors){
										System.out.println((cont+1)+") "+conductors[cont].getCodiConductor());
									cont++;
									}
									System.out.println("\nNumero de conductor? ");
									num_c=scan.nextInt();
									if(num_c<1 || num_c>numConductors) System.out.println("Número de conductor incorrecte. Prova-ho de nou! ");
								}
								Conductor conductor = conductors[num_c-1];
								System.out.println(conductor);
								
								break;
								
								case 2:
									
								cont=0;
								num_c=0;
								
								while(num_c<1 || num_c>numConductors){
									while(cont<numConductors){
										System.out.println((cont+1)+") "+conductors[cont].getCodiConductor());
									cont++;
									}
									System.out.println("\nNumero de conductor? ");
									num_c=scan.nextInt();
									if(num_c<1 || num_c>numConductors) System.out.println("Número de conductor incorrecte. Prova-ho de nou! ");
								}
								conductor = conductors[num_c-1];
								cont=0;
								Trajecte[] trajectes=conductor.getTrajecte().
								if(conductor.getTrajecte().length!=0){
									System.out.println("Trajectes del conductor: '"+llistaConductors.Getllista()[num_c-1].dni+"'");
									while(cont<conductor.gettrajectes().length){
										System.out.println(conductor.gettrajectes()[cont]);
										cont++;
									}
								}
								else System.out.println("No existeix cap trajecte habitual d'aquest conductor\n");
								
								break;
							
								case 3:
									
								int cont=0;
								int num_c=0;
								while(num_c<1 || num_c>llistaConductors.Getnumconductors()){
									while(cont<llistaConductors.Getnumconductors()){
										System.out.println((cont+1)+") "+llistaConductors.Getllista()[cont].dni);
									cont++;
									}
									System.out.println("\nNumero de conductor? ");
									num_c=scan.nextInt();
									if(num_c<1 || num_c>llistaConductors.Getnumconductors()) System.out.println("Número de conductor incorrecte. Prova-ho de nou! ");
								}
								Conductor conductor = llistaConductors.getconductor(llistaConductors.Getllista()[num_c-1].dni);
								cont=0;
								int opcio_t=0;
								if(conductor.gettrajectes().length!=0){
									while(opcio_t<1 && opcio_t>conductor.gettrajectes().length){
										System.out.println("Trajectes del conductor: '"+llistaConductors.Getllista()[num_c-1].dni+"'");
										while(cont<conductor.gettrajectes().length){
											System.out.println(conductor.gettrajectes()[cont]);
											cont++;
										}
										System.out.println("Número del trajecte a esborrar? ");
										opcio_t=scan.nextInt();
									}
									conductor.eliminartrajecte(conductor.gettrajectes()[opcio_t-1]);
									trajectes.eliminartrajecte(conductor.gettrajectes()[opcio_t-1]);
								}		
								else System.out.println("No existeix cap trajecte habitual d'aquest conductor\n");
								
								break;
								
								default: System.out.println("Opcio incrrecte! Intenta-ho de nou! ");
								
								break;
							}
						
					break;
				}
				
			}
			
		}
		llistaVies.actualitzarLlista(llistaTrams.getNumTrams());
		llistaConductors.actualitzarllista();
		llistaTrajectes.actualitzarLlista(llistaVies);
	}

}
