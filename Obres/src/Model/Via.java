package Model;

/**
 * 
 * @author Julián
 *
 */
public class Via {
	private LlistaTrams llistaTrams;
	private String poble1;
	private String poble2;
	private Enum tipusVia;
	private String codiVia;
	
	/**Constructor que rep per paràmetres els pobles de origen
	 * i destí, el codi de la via, i la llista de Trams d'aquesta via.
	 * @param poble1
	 * @param poble2
	 * @param tipusVia
	 * @param codiVia
	 * @param llistaTrams
	 */
	public Via (String poble1, String poble2, Enum tipusVia, String codiVia, LlistaTrams llistaTrams){
		this.poble1=poble1;
		this.poble2=poble2;
		this.tipusVia=tipusVia;
		this.codiVia=codiVia;
		this.llistaTrams=llistaTrams;
	}
	
	/**Getter llistaTrams
	 * 
	 * @return
	 */
	public LlistaTrams getLlistaTrams() {
		return llistaTrams;
	}
	
	/**Setter llistaTrams
	 * 
	 * @param llistaTrams
	 */
	public void setLlistaTrams(LlistaTrams llistaTrams) {
		this.llistaTrams = llistaTrams;
	}

	/**Getter poble1
	 * 
	 * @return
	 */
	public String getPoble1() {
		return poble1;
	}

	/**Getter poble2
	 * 
	 * @return
	 */
	public String getPoble2() {
		return poble2;
	}

	/**Getter tipusVia
	 * 
	 * @return
	 */
	public Enum getTipusVia() {
		return tipusVia;
	}
	
	/**Getter codiVia
	 * 
	 * @return
	 */
	public String getCodiVia() {
		return codiVia;
	}
	
	/**String que retorna el tipus de via i
	 * els pobles d'origen i destí.
	 */
	public String toString(){
		return("Tipus de via: "+tipusVia+" des de "+poble1+" a "+poble2);
	}
	
	/**Getter numTrams, retorna el número de trams
	 * de la llistaTrams
	 * @return
	 */
	public int getNumTrams(){
		return llistaTrams.getNumTrams();
		}
}