import java.util.Scanner;

public class PlayablePosition extends Position{
	public int counter = 0; //
	public Scanner sc = new Scanner(System.in); //
	
//    Board b = new Board(null, null, counter);
    
	
	public boolean canPlay(Position[][] board, Player p1, Player p2) {
		boolean canMove = false;
		int x = sc.nextInt();
	    int y = sc.nextInt();
		if(counter % 2 == 0) {
			
			do {
				System.out.println("Black");
				System.out.println("Please make a move between 0 and 8.");
				System.out.println("Please make a move in x: ");
				x = sc.nextInt();
				System.out.println("Please make a move in y: ");
			    y = sc.nextInt();
				if((x < 0 || x > 8) && (y < 0 || y > 8)) {
					System.out.println("Please make a move between 0 and 8.");
					System.out.println("Please make a move in x: ");
					x = sc.nextInt();
					System.out.println("Please make a move in y: ");
					y = sc.nextInt();
				} 
				else if ((board[x][y].getPiece() == Position.UNPL) || 
						(board[x][y].getPiece() == Position.BLACK) || 
						(board[x][y].getPiece() == Position.WHITE)){
					System.out.println("Please make a move on a playable empty square.");
					System.out.println("Please make a move in x: ");
					x = sc.nextInt();
					System.out.println("Please make a move in y: ");
					y = sc.nextInt();
				}
				else {
					canMove = true;
					}
				
			} while (!canMove);
			
		}
		else {
			
			do {
				System.out.println("White Turn");
				System.out.println("Please make a move between 0 and 8.");
				System.out.println("Please make a move in x: ");
				x = sc.nextInt();
				System.out.println("Please make a move in y: ");
			    y = sc.nextInt();
				if((x < 0 || x > 8) && (y < 0 || y > 8)) {
					System.out.println("Please make a move between 0 and 8.");
					System.out.println("Please make a move for in x: ");
					x = sc.nextInt();
					System.out.println("Please make a move for in y: ");
					y = sc.nextInt();
				} 
				else if ((board[x][y].getPiece() == Position.UNPL) || 
						(board[x][y].getPiece() == Position.BLACK) || 
						(board[x][y].getPiece() == Position.WHITE)){
					System.out.println("Please make a move on a playable empty square.");
					System.out.println("Please make a move for in x: ");
					x = sc.nextInt();
					System.out.println("Please make a move for in y: ");
					y = sc.nextInt();
				}
				else {
					canMove = true;
					
				}
			} while (!canMove);
		}
//		b.check(board, x, y);
		return canMove;
		
	}
}
	
	
