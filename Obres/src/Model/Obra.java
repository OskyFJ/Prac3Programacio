package Model;
/**
 * 
 * @author Daniel
 *
 */
public class Obra extends Incidencia {
	
	private Tram tram_afectat;
	private TipusObra tipusObra;
	private int nivell_obra = 0;
	private String nomVia;
	private Data dataInici;
	private Data dataFinal;

public Obra (Data data1, Data data2, int nivell, String nomVia, Tram tram ) {

	this.nomVia=nomVia;
	this.dataInici=data1;
	this.dataFinal=data2;
	this.tram_afectat= tram;
    
	if(nivell==1) tipusObra =TipusObra.MILLORA_FERM;
	else if (nivell==2) tipusObra= TipusObra.MILLORA_SEGURETAT;
		else tipusObra=TipusObra.RESTAURACIO;
	
}


public String toString() {
	return  "Via  on s'ha produit la obra? "+nomVia+
			"\n\t- Tipus de obra: "+tipusObra+ 
			"\n\t- Data inici de la obra: "+dataInici.data()+
			"\n\t- Data de finalització de la obra: "+dataFinal.data();
}

public String getNomVia(){
	return nomVia;
}

public Tram getTramAfectat() {
	return tram_afectat;
}



public int getNivell_obra() {
	return nivell_obra;
}


public Data getDataInici() {
	return dataInici;
}

public Data getDataFinal() {
	return dataFinal;
}

public void setDataInici(Data data) {
	this.dataInici = data;
}

public void setDataFinal(Data data) {
	this.dataFinal = data;
}

}
