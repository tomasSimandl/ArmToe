import java.io.IOException;
import java.util.Scanner;



public class Game {

	private static final String IP = "127.0.0.1";//"192.168.0.11";
	private static final int PORT = 59002;

	private static final int MAX_PLY = 4;

	private SocketManager socketManager;
	private Scanner scanner;



	public static void main(String[] args) throws IOException, InterruptedException {
		new Game();
	}

	public Game() throws InterruptedException, IOException {

		socketManager = new SocketManager(IP, PORT);
		if(!socketManager.isOpen()){
			System.out.println("Connection was not established!");
			System.exit(1);
		}

		scanner = new Scanner(System.in);


		try {
			while (true) {
				int[][] gameState = readInputData();
				Board board = new Board(gameState);

				MinMax.run(Board.State.O, board, MAX_PLY);
				int[] lastMove = MinMax.lastMove;
				socketManager.sendCoordinates(lastMove[0], lastMove[1]);
			}
		}catch (Exception e){
			e.printStackTrace();
			socketManager.stopConnection();
		}

		scanner.close();
	}

	private int[][] readInputData(){
		String[] input = scanner.next().split(",");

		int[][] gameState = new int[9][7];
		for(int i = 0; i<input.length;i++) {
			gameState[i/7][i%7] = Integer.parseInt(input[i]);
		}

		return gameState;
	}
}
