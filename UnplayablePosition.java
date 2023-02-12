
public class UnplayablePosition extends Position{
	
	public final char UNPLAYABLE = '*';
	
	public boolean canPlay() {
		return false;
	}
}
