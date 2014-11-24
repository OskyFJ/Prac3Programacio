/**
 * 
 * @author Julián
 *
 */
public class Accident extends Incidencia {
	private Data dataAccident;
	private String tramAfectat;

	
	public Accident(Data dataAccident, String tramAfectat){
		this.dataAccident=dataAccident;
		this.tramAfectat=tramAfectat;
	}
	
	
	public Data getDataAccident() {
		return dataAccident;
	}
	

	public String getTram() {
		return tramAfectat;
	}
	

	public String toString(){

		 return ("Accident al tram '"+tramAfectat+"':"+dataAccident);
	}
	
	}
