package Model;

/**
 * 
 * @author Julián
 *
 */
public class Accident extends Incidencia {
	private Data dataAccident;
	private String tramAfectat;

	/**Constructor que rep per paràmetre la data de l'accident de tipus Data, i el tramAfectat.
	 * 
	 * @param dataAccident
	 * @param tramAfectat
	 */
	public Accident(Data dataAccident, String tramAfectat){
		this.dataAccident=dataAccident;
		this.tramAfectat=tramAfectat;
	}
	
	/**Getter de dataAccident que retorna la data de l'accident.
	 * 
	 * @return
	 */
	public Data getDataAccident() {
		return dataAccident;
	}
	
	/**Getter tramAfectat que retorna el tram afectat.
	 * 
	 * @return
	 */
	public String getTramAfectat() {
		return tramAfectat;
	}
	
	/**String que retorna el tram afectat i la data de l'accident.
	 * 
	 */
	public String toString(){
		 return ("Accident al tram '"+tramAfectat+"':"+dataAccident);
	}
	}