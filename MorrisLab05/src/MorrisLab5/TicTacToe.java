package MorrisLab5;
import edu.du.dudraw.*;

public class TicTacToe {

	private enum Contents{EMPTY, EX, OH}
	
	public class Cell {
		
		private Contents Owner;
		private Boolean lock;
		
		
		private Cell() {
			Owner = Contents.EMPTY;
			lock = false;
		}
		
		private Contents getCellType() {
			return Owner;
		}
		
		private void setContents(Contents val) {
			if (!lock) {
				Owner = val;
				lock = true;
				message = Xturn ? "Its O's Turn!" : "Its X's Turn!";
				Xturn = !Xturn;
			}
			else
				message = "Try another place, this one is taken!";
			lock = true;
			
			
		}
	}
	
	private Cell[][] board;
	private String message;
	private boolean Xturn;

	public TicTacToe() {
		DUDraw.setCanvasSize(600, 700);
		DUDraw.setXscale(0, 3);
		DUDraw.setYscale(0, 3.5);

		board = new Cell[3][3];

		this.message = "X goes first!";
		this.Xturn = true;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new Cell();
			}
		}
	}

	public void draw() {
		DUDraw.clear(DUDraw.WHITE);
		DUDraw.setPenColor(DUDraw.BLACK);
		DUDraw.line(1, 0, 1, 3);
		DUDraw.line(2, 0, 2, 3);
		DUDraw.line(0, 1, 3, 1);
		DUDraw.line(0, 2, 3, 2);
		DUDraw.text(1.5, 3.25, this.message);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getCellType() == Contents.EX) {
					DUDraw.text(i+.5,j+.5,"X");
				}
				else if (board[i][j].getCellType() == Contents.OH) {
					DUDraw.text(i+.5,j+.5,"O");
				}
			}
		}
		
	}

	public void playGame() {
		DUDraw.enableDoubleBuffering();
		do {
			draw();
			if (DUDraw.isMousePressed()) {
				if(DUDraw.mouseX() < 1){
					if (DUDraw.mouseY() < 1) {
						this.set(0,0);
					}
					else if (DUDraw.mouseY() < 2) {
						this.set(0, 1);
					}
					else if (DUDraw.mouseY() < 3) {
						this.set(0, 2);
					}
				}
				else if(DUDraw.mouseX() < 2){
					if (DUDraw.mouseY() < 1) {
						this.set(1,0);
					}
					else if (DUDraw.mouseY() < 2) {
						this.set(1, 1);
					}
					else if (DUDraw.mouseY() < 3) {
						this.set(1, 2);
					}
				}
				else if(DUDraw.mouseX() < 3){
					if (DUDraw.mouseY() < 1) {
						this.set(2,0);
					}
					else if (DUDraw.mouseY() < 2) {
						this.set(2, 1);
					}
					else if (DUDraw.mouseY() < 3) {
						this.set(2, 2);
					}
				}
			}
			
			DUDraw.show();
			DUDraw.pause(100);
		} while (!gameWon() && !allFilled());
		
		if (gameWon()) {
			message = Xturn ? "Game over, O wins!" : "Game over, X wins!";
		} else {
			message = "Game over, it's a tie!";
		}
		draw();
		DUDraw.show();
	}

	// Check if someone has won the game
	public boolean gameWon() {
		
		//TODO: check each column
		if (this.wins(board[0][0].getCellType(), board[0][1].getCellType(), board[0][2].getCellType())) {
			return true;
		}
		if (this.wins(board[0][0].getCellType(), board[0][1].getCellType(), board[0][2].getCellType())) {
			return true;
		}
		if (this.wins(board[1][0].getCellType(), board[1][1].getCellType(), board[1][2].getCellType())) {
			return true;
		}
		if (this.wins(board[2][0].getCellType(), board[2][1].getCellType(), board[2][2].getCellType())) {
			return true;
		}
		//TODO: check each row
		if (this.wins(board[0][0].getCellType(), board[1][0].getCellType(), board[2][0].getCellType())) {
			return true;
		}
		
		if (this.wins(board[0][1].getCellType(), board[1][1].getCellType(), board[2][1].getCellType())) {
			return true;
		}
		
		if (this.wins(board[0][2].getCellType(), board[1][2].getCellType(), board[2][2].getCellType())) {
			return true;
		}
		if (this.wins(board[0][0].getCellType(), board[1][1].getCellType(), board[2][2].getCellType())) {
			return true;
		}
		//TODO: check diagonals
		if (this.wins(board[0][0].getCellType(), board[1][1].getCellType(), board[2][2].getCellType())) {
			return true;
		}
		if (this.wins(board[2][0].getCellType(), board[1][1].getCellType(), board[0][2].getCellType())) {
			return true;
		}
		
		return false;


	}
	private boolean wins(Contents c1, Contents c2, Contents c3) {
		//Contents c1, Contents c2, Contents c3
		
		if (c1==Contents.EMPTY)
			return false;
			
		return c1 == c2 && c1 == c3;
		
		
	}

	private boolean allFilled() {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getCellType() == Contents.EMPTY) {
					return false;
				}
			}
		}

		return true;
	}
	
	private void set(int i, int j) {
		if (Xturn) {
			board[i][j].setContents(Contents.EX);
		}
		else
			board[i][j].setContents(Contents.OH);
		
	}
	
}
