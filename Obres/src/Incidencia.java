/**
 * 
 * @author Xavi
 *
 */
public abstract class Incidencia {
	protected Tram tramAfectat;
	
	public Tram getTram() {
		return tramAfectat;
	}
	
	@Override
	public abstract String toString();
	
}
