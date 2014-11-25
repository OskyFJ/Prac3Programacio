/**
 * 
 * @author Daniel
 *
 */
public class Obra extends Incidencia {
	
	private Incidencia tram_afectat;
	private TipusObra tipusObra;
	private int nivell_obra = 0;
	
	private Data dia_inici;
	private Data mes_inici;
	private Data any_inici;
	private Data dia_final;
	private Data mes_final;
	private Data any_final;
	

public void Obra (Data diaInici, Data mesInici, Data anyInici,Data diaFi, Data mesFi, Data anyFi, int nivell, Incidencia tram ) {

	this.dia_inici= diaInici;
	this.mes_inici=mesInici;
	this.any_inici=anyInici;
	
	this.dia_final=diaFi;
	this.mes_final=mesFi;
	this.any_final=anyFi;
	
	this.tram_afectat= tram;
    
	
	/* preguntar com assignar valor a la variable tipusObra perque no tinc ni puta idea */ 
	
	if(nivell==1) tipusObra ="MILLORA_FERM";
	else 	if (nivell==2) tipusObra= MILLORA_SEGURETAT;
			else tipusObra=RESTAURACIO;
	
}


public String toString() {
	return  "\n\t- Tipus de obra: "+tipusObra+ 
		    
			"\n\t- Data inici de la obra: "+dia_inici+"/"+mes_inici+"/"+any_inici+
	        
			"\n\t- Data finalització: "+dia_final+"/"+mes_final+"/"+any_final;

	
	}







public Incidencia getTram_afectat() {
	return tram_afectat;
}


public void setTram_afectat(Incidencia tram_afectat) {
	this.tram_afectat = tram_afectat;
}


public int getNivell_obra() {
	return nivell_obra;
}


public void setNivell_obra(int nivell_obra) {
	this.nivell_obra = nivell_obra;
}


public Data getDia_inici() {
	return dia_inici;
}


public void setDia_inici(Data dia_inici) {
	this.dia_inici = dia_inici;
}


public Data getMes_inici() {
	return mes_inici;
}


public void setMes_inici(Data mes_inici) {
	this.mes_inici = mes_inici;
}


public Data getAny_inici() {
	return any_inici;
}


public void setAny_inici(Data any_inici) {
	this.any_inici = any_inici;
}


public Data getDia_final() {
	return dia_final;
}


public void setDia_final(Data dia_final) {
	this.dia_final = dia_final;
}


public Data getMes_final() {
	return mes_final;
}


public void setMes_final(Data mes_final) {
	this.mes_final = mes_final;
}


public Data getAny_final() {
	return any_final;
}


public void setAny_final(Data any_final) {
	this.any_final = any_final;
}









}
