/**
 * 
 * @author Julián
 *
 */
public class Via {
	private LlistaTrams llistaTrams;
	private String poble1;
	private String poble2;
	private TipusVia tipusVia;
	private String codiVia;
	
	public Via (String poble1, String poble2, TipusVia tipusVia, String codiVia){
		this.poble1=poble1;
		this.poble2=poble2;
		this.tipusVia=tipusVia;
		this.codiVia=codiVia;
	}

	public LlistaTrams getLlistaTrams() {
		return llistaTrams;
	}

	public String getPoble1() {
		return poble1;
	}

	public String getPoble2() {
		return poble2;
	}

	public TipusVia getTipusVia() {
		return tipusVia;
	}

	public String getCodiVia() {
		return codiVia;
	}
	
	public String toString(){
		return("Tipus de via: "+tipusVia+" des de "+poble1+" a "+poble2);
	}
}
