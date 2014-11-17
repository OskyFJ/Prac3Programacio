/**
 * 
 * @author Xavi
 *
 */
public abstract class Incidencia {
	private Tram tramAfectat;
	int a;
	
	public Incidencia(Tram tram, int a){
		tramAfectat=tram;
		this.a=a;
	}
	
	public Tram gettram() {
		return tramAfectat;
	}
	
}
