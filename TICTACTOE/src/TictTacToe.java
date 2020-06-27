import java.util.Scanner;

public class TictTacToe {

	private Player player1,player2;
	private Board board;
	
	public static void main(String args[]) {
		TictTacToe t = new TictTacToe();
		t.startGame();
	}

	public void startGame() {
		Scanner s = new Scanner(System.in);
		//Players input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol already taken !! Pick another symbol !!");
			char symbol = s.next().charAt(0);
			player2.setSymbol(symbol);	
		}
		board = new Board(player1.getSymbol(), (player2.getSymbol()));
		//create the board
		boolean player1turn = true;
		int status = Board.INVALID;
		while(status == Board.INCOMPLETE || status == Board.INVALID) {
			if(player1turn) {
				System.out.println("Player 1 -" + player1.getName() + "'s turn");
				System.out.println("Enter x:");
				int x = s.nextInt();
				System.out.println("Enter y:");
				int y = s.nextInt();
				 status = board.move(player1.getSymbol(),x,y);
				if(status != Board.INVALID) {
					player1turn = false;
					board.print();
				}
				else {
					System.out.println("INVALID !! Try Again");
				}
			}
			else {
				System.out.println("Player 2 -" + player2.getName() + "'s turn");
				System.out.println("Enter x:");
				int x = s.nextInt();
				System.out.println("Enter y:");
				int y = s.nextInt();
				status = board.move(player2.getSymbol(),x,y);
				if(status == Board.INVALID) {
					player1turn = true;
					board.print();
				}
			}
		}
		if(status == Board.PLAYER_1_WINS) {
			System.out.println("Player 1 -" + player1.getName() + "wins!!");
		}
		else if(status ==  Board.PLAYER_2_WINS) {
			System.out.println("Player 2 -" + player2.getName() + "wins!!");
		}
		else {
			System.out.println("DRAW");
		}
		//conduct game
		
	}
   private Player takePlayerInput(int num) {
	   Scanner s = new Scanner(System.in);
	   System.out.println("Enter Player" + num + "name");
	   String name = s.nextLine();
	   System.out.println("Enter Player" + num + "symbol: ");
	   char symbol = s.next().charAt(0);
	   Player p = new Player(name, symbol);
	   return p;
   }
}
