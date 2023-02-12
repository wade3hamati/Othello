
public abstract class Position {
	
	public char piece;
	public final static char EMPTY = '_';
	public final static char UNPL = '*'; //unplayable
	public final static char BLACK = 'B';
	public final static char WHITE = 'W';
	
	Position(){
		
	}
	public boolean canPlay() {
		return false;
	}
	public char getPiece() {
		return piece;
	}
	public void setPiece(char piece) {
		this.piece = piece;
	}
	
}
