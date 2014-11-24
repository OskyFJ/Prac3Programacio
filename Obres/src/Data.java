/**
 * 
 * @author Daniel
 *
 */
public class Data {
	private int dia;
	private int mes;
	private int any;

	
	
	/** constructor de les dates, guarda la data de la incidencia actual i comprova que els dies, els mesos i els anys
	  son correctes*/
	
	public Data (int dia,int mes, int any) throws foraderang {
		
		
		try {this.dia=dia;
		    if (dia<0 || dia>31) throw new foraderang(0,30);
		}
		
	 catch (foraderang e) {System.out.println();}
		
		
		
		
		
		this.mes=mes;
		this.any=any;
		
	}
	
	
	public String toString() {
	
		return("Data: dia--> "+dia+" mes--> "+mes+"any--> "+any);
	}
	
	
	
	
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAny() {
		return any;
	}
	
	public void setAny(int any) {
		this.any = any;
	}
	
	
	
	
	
	
	

}


