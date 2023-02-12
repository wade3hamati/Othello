import java.util.Scanner;

public class Board { 
	
	public Player p1;
	public Player p2;
	Position[][] board = new Position[10][10];
	PlayablePosition pp = new PlayablePosition();
	public Scanner sc = new Scanner(System.in);
	public int counter = 0;
	
//	Board (String save_file){
//	
//}

	public Board (Player p1, Player p2, int start){
		this.p1 = p1;
		this.p2 = p2;
		
		if(start == 1) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
				board[i][j] = new PlayablePosition();
				board[i][j].setPiece(Position.EMPTY);
				}
			}
			board[1][1].setPiece(Position.UNPL);
			board[8][8].setPiece(Position.UNPL);
			board[1][8].setPiece(Position.UNPL);
			board[8][1].setPiece(Position.UNPL);

			board[4][4].setPiece(Position.WHITE);
			board[5][5].setPiece(Position.WHITE);
			board[4][5].setPiece(Position.BLACK);
			board[5][4].setPiece(Position.BLACK);
			
			for(int i = 0; i < 10; i++) {
				board[0][i].setPiece(Position.UNPL);
			}
			for(int i = 0; i < 10; i++) {
				board[i][0].setPiece(Position.UNPL);
			}
			for(int i = 0; i < 10; i++) {
				board[9][i].setPiece(Position.UNPL);
			}
			for(int i = 0; i < 10; i++) {
				board[i][9].setPiece(Position.UNPL);
			}
			drawBoard();
							
		}
		if(start == 2) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
				board[i][j] = new PlayablePosition();
				board[i][j].setPiece(Position.EMPTY);
				}
			}
			board[1][1].setPiece(Position.UNPL);
			board[8][8].setPiece(Position.UNPL);
			board[1][8].setPiece(Position.UNPL);
			board[8][1].setPiece(Position.UNPL);
			
			board[3][3].setPiece(Position.WHITE);
			board[3][4].setPiece(Position.WHITE);
			board[4][3].setPiece(Position.WHITE);
			board[4][4].setPiece(Position.WHITE);
			board[5][5].setPiece(Position.WHITE);
			board[5][6].setPiece(Position.WHITE);
			board[6][5].setPiece(Position.WHITE);
			board[6][6].setPiece(Position.WHITE);
			
			board[3][5].setPiece(Position.BLACK);
			board[3][6].setPiece(Position.BLACK);
			board[4][5].setPiece(Position.BLACK);
			board[4][6].setPiece(Position.BLACK);
			board[5][3].setPiece(Position.BLACK);
			board[5][4].setPiece(Position.BLACK);
			board[6][3].setPiece(Position.BLACK);
			board[6][4].setPiece(Position.BLACK);
			
			for(int i = 0; i < 10; i++) {
				board[0][i].setPiece(Position.UNPL);
			}
			for(int i = 0; i < 10; i++) {
				board[i][0].setPiece(Position.UNPL);
			}
			for(int i = 0; i < 10; i++) {
				board[9][i].setPiece(Position.UNPL);
			}
			for(int i = 0; i < 10; i++) {
				board[i][9].setPiece(Position.UNPL);
			}
			drawBoard();
		}
		takeTurn();
		
	}

	public void drawBoard() {
		for(int i = 0; i <= 8; i++) {
			char[] letters = {' ', ' ','1', '2', '3', '4', '5', '6', '7', '8'};
			System.out.print(letters[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 10; i++) {
			char[] letters = {' ','1', '2', '3', '4', '5', '6', '7', '8', ' ', ' '};
			System.out.print(letters[i]);
			System.out.print(" ");
			for(int j = 0; j < 10; j++) {
				System.out.print(board[i][j].getPiece() + " ");
			}
			System.out.println();
		}
		
	}
//	public static Board load() {
//		return null;
//	}
//	public void play() {
//		
//	}
//	private void save() {
//		
//	}
	
	public void check(Position[][] board, int fstInput, int secInput) { //

		//this method can check if the position chosen by the player is valid 
		//and then flip the appropriate pieces if true.
		//If false, it will return false and ask the player to enter a different location
		
		int x = fstInput;
		int y = secInput;
		int counter2 = 0;
		if(counter % 2 == 0) { ///////////// when it's black's turn///////////////
			System.out.println("Black Piece's Turn");
			while(board[x][y].getPiece() == Position.EMPTY) { //checking NW
				
				while(board[x-1][y-1].getPiece() == Position.WHITE) {
					x--;
					y--;
					counter2++;
				}
				
				if (board[x-1][y-1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i++, j++) {
						board[i][j].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking W
				while(board[x][y-1].getPiece() == Position.WHITE) {
					y--;
					counter2++;
				}
				
				if (board[x][y-1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, j = y; t <= counter2; t++, j++) {
						board[x][j].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY) { // checking SW
				while(board[x+1][y-1].getPiece() == Position.WHITE) {
					x++;
					y--;
					counter2++;
				}
				
				if (board[x+1][y-1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j++) {
						board[i][j].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY) { //checking S
				
				while(board[x+1][y].getPiece() == Position.WHITE) {
					x++;
					counter2++;
				}
				
				if (board[x+1][y].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x; t <= counter2; t++, i-- ) {
						board[i][y].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY) { //checking SE
				while(board[x+1][y+1].getPiece() == Position.WHITE) {
					x++;
					y++;
					counter2++;
				}
				
				if (board[x+1][y+1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j--) {
						board[i][j].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking E
				while(board[x][y+1].getPiece() == Position.WHITE) {
					y++;
					counter2++;
				}
				
				if (board[x][y+1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, j = y; t <= counter2; t++, j--) {
						board[x][j].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking NE
				while(board[x-1][y+1].getPiece() == Position.WHITE) {
					x--;
					y++;
					counter2++;
				}
				
				if (board[x-1][y+1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++,i++,j--) {
						board[i][j].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking N
				while(board[x-1][y].getPiece() == Position.WHITE) {
					x--;
					counter2++;
				}
				
				if (board[x-1][y].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x; t <= counter2; t++, i++) {
						board[i][y].setPiece(Position.BLACK);
					}
				}
				else {
					break;
				}
			}
			counter++;
		}
		else { ////////// when it's white's turn //////////////////
			System.out.println("White Piece Turn");
			while(board[x][y].getPiece() == Position.EMPTY) { //checking NW
				
				while(board[x-1][y-1].getPiece() == Position.BLACK) {
					x--;
					y--;
					counter2++;
				}
				
				if (board[x-1][y-1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i++, j++) {
						board[i][j].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking W
				while(board[x][y-1].getPiece() == Position.BLACK) {
					y--;
					counter2++;
				}
				
				if (board[x][y-1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, j = y; t <= counter2; t++, j++) {
						board[x][j].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY) { // checking SW
				while(board[x+1][y-1].getPiece() == Position.BLACK) {
					x++;
					y--;
					counter2++;
				}
				
				if (board[x+1][y-1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j++) {
						board[i][j].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking S
				
				while(board[x+1][y].getPiece() == Position.BLACK) {
					x++;
					counter2++;
				}
				
				if (board[x+1][y].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x; t <= counter2; t++, i-- ) {
						board[i][y].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking SE
				while(board[x+1][y+1].getPiece() == Position.BLACK) {
					x++;
					y++;
					counter2++;
				}
				
				if (board[x+1][y+1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j--) {
						board[i][j].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY) { //checking E
				while(board[x][y+1].getPiece() == Position.BLACK) {
					y++;
					counter2++;
				}
				
				if (board[x][y+1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, j = y; t <= counter2; t++, j--) {
						board[x][j].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY ) { //checking NE
				while(board[x-1][y+1].getPiece() == Position.BLACK) {
					x--;
					y++;
					counter2++;
				}
				
				if (board[x-1][y+1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++,i++,j--) {
						board[i][j].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.EMPTY) { //checking N
				while(board[x-1][y].getPiece() == Position.BLACK) {
					x--;
					counter2++;
				}
				
				if (board[x-1][y].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x; t <= counter2; t++, i++) {
						board[i][y].setPiece(Position.WHITE);
					}
				}
				else {
					break;
				}
			}
			counter++;
		}
	}
	public void check2(Position[][] board, int fstInput, int secInput) { //
		//

		//this method can check if the position chosen by the player is valid 
		//and then flip the appropriate pieces if true.
		//If false, it will return false and ask the player to enter a different location
		
		int x = fstInput;
		int y = secInput;
		int counter2 = 0;
		if(counter2 % 2 == 0) { ///////////// when it's black's turn///////////////
			System.out.println("Black Piece's Turn");
			if(board[x-1][y-1].getPiece() == Position.BLACK) {
				while(board[x][y].getPiece() == Position.BLACK) { //checking NW
					
					while(board[x-1][y-1].getPiece() == Position.WHITE) {
						x--;
						y--;
						counter2++;
					}
					
					if (board[x-1][y-1].getPiece() == Position.BLACK){
						System.out.println("black piece");	
						for(int t = 0, i = x, j = y; t <= counter2; t++, i++, j++) {
							board[i][j].setPiece(Position.BLACK);
						}
						break;
					}
					else {
						break;
					}
				}
			}
			if(board[x][y-1].getPiece() == Position.BLACK) {
				while(board[x][y].getPiece() == Position.BLACK ) { //checking W
					while(board[x][y-1].getPiece() == Position.WHITE) {
						y--;
						counter2++;
					}
					
					if (board[x][y-1].getPiece() == Position.BLACK){
						System.out.println("black piece");	
						for(int t = 0, j = y; t <= counter2; t++, j++) {
							board[x][j].setPiece(Position.BLACK);
						}
						break;
					}
					else {
						break;
					}
				}
			}
			if(board[x+1][y-1].getPiece() == Position.BLACK) {
				while(board[x][y].getPiece() == Position.BLACK) { // checking SW
					while(board[x+1][y-1].getPiece() == Position.WHITE) {
						x++;
						y--;
						counter2++;
					}
					
					if (board[x+1][y-1].getPiece() == Position.BLACK){
						System.out.println("black piece");	
						for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j++) {
							board[i][j].setPiece(Position.BLACK);
						}
						break;
					}
					else {
						break;
					}
				}
			}
			while(board[x][y].getPiece() == Position.BLACK) { //checking S
				
				while(board[x+1][y].getPiece() == Position.WHITE) {
					x++;
					counter2++;
				}
				
				if (board[x+1][y].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x; t <= counter2; t++, i-- ) {
						board[i][y].setPiece(Position.BLACK);
					}
					break;
				}
				else {
					break;
				}
			}
			if(board[x+1][y+1].getPiece() == Position.BLACK) {
			
				while(board[x][y].getPiece() == Position.BLACK) { //checking SE
					
					while(board[x+1][y+1].getPiece() == Position.WHITE) {
						x++;
						y++;
						counter2++;
					}
					
					if (board[x+1][y+1].getPiece() == Position.BLACK){
						System.out.println("black piece");	
						for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j--) {
							board[i][j].setPiece(Position.BLACK);
						}
						break;
					}
					else {
						break;
					}
				}
			}
			
			while(board[x][y].getPiece() == Position.BLACK ) { //checking E
				while(board[x][y+1].getPiece() == Position.WHITE) {
					y++;
					counter2++;
				}
				
				if (board[x][y+1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, j = y; t <= counter2; t++, j--) {
						board[x][j].setPiece(Position.BLACK);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.BLACK ) { //checking NE
				while(board[x-1][y+1].getPiece() == Position.WHITE) {
					x--;
					y++;
					counter2++;
				}
				
				if (board[x-1][y+1].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++,i++,j--) {
						board[i][j].setPiece(Position.BLACK);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.BLACK ) { //checking N
				while(board[x-1][y].getPiece() == Position.WHITE) {
					x--;
					counter2++;
				}
				
				if (board[x-1][y].getPiece() == Position.BLACK){
					System.out.println("black piece");	
					for(int t = 0, i = x; t <= counter2; t++, i++) {
						board[i][y].setPiece(Position.BLACK);
					}
					break;
				}
				else {
					break;
				}
			}
			counter++;
		}
		else { ////////// when it's white's turn //////////////////
			System.out.println("White Piece Turn");
			while(board[x][y].getPiece() == Position.WHITE) { //checking NW
				
				while(board[x-1][y-1].getPiece() == Position.BLACK) {
					x--;
					y--;
					counter2++;
				}
				
				if (board[x-1][y-1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i++, j++) {
						board[i][j].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE ) { //checking W
				while(board[x][y-1].getPiece() == Position.BLACK) {
					y--;
					counter2++;
				}
				
				if (board[x][y-1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, j = y; t <= counter2; t++, j++) {
						board[x][j].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE) { // checking SW
				while(board[x+1][y-1].getPiece() == Position.BLACK) {
					x++;
					y--;
					counter2++;
				}
				
				if (board[x+1][y-1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j++) {
						board[i][j].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE ) { //checking S
				
				while(board[x+1][y].getPiece() == Position.BLACK) {
					x++;
					counter2++;
				}
				
				if (board[x+1][y].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x; t <= counter2; t++, i-- ) {
						board[i][y].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE ) { //checking SE
				while(board[x+1][y+1].getPiece() == Position.BLACK) {
					x++;
					y++;
					counter2++;
				}
				
				if (board[x+1][y+1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++, i--, j--) {
						board[i][j].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE) { //checking E
				while(board[x][y+1].getPiece() == Position.BLACK) {
					y++;
					counter2++;
				}
				
				if (board[x][y+1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, j = y; t <= counter2; t++, j--) {
						board[x][j].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE ) { //checking NE
				while(board[x-1][y+1].getPiece() == Position.BLACK) {
					x--;
					y++;
					counter2++;
				}
				
				if (board[x-1][y+1].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x, j = y; t <= counter2; t++,i++,j--) {
						board[i][j].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			while(board[x][y].getPiece() == Position.WHITE) { //checking N
				while(board[x-1][y].getPiece() == Position.BLACK) {
					x--;
					counter2++;
				}
				
				if (board[x-1][y].getPiece() == Position.WHITE){
					System.out.println("white piece");	
					for(int t = 0, i = x; t <= counter2; t++, i++) {
						board[i][y].setPiece(Position.WHITE);
					}
					break;
				}
				else {
					break;
				}
			}
			counter++;
		}
		System.out.println("still in while loop");
	}

	
	private void takeTurn() {
		System.out.println("Black");
		System.out.println("Please make a move between 0 and 8.");
		System.out.println("Please make a move in x: ");
		int x = sc.nextInt();
		System.out.println("Please make a move in y: ");
	    int y = sc.nextInt();
		
		if(pp.canPlay(board, p1, p2)) {
			check(board, x, y);
			drawBoard();
			System.out.println(board[x+1][y+1].getPiece());
			check2(board, x, y);
			drawBoard();
			takeTurn();
		}
		else {
			System.out.println("Cannot Place Piece There");
			counter++;
		}
	}
	
}
