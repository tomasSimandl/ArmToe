import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;



public class Game {

	public static void main(String[] args) {
		String game = "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0,"
				+ "0,1,2,0,1,2,0";
		String game0 = "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,"
				+ "0,0,0,0,0,0,0,";
		InputStream is = new ByteArrayInputStream(game0.getBytes());
		
		Scanner scanner = new Scanner(System.in); //System.in
		/*
		String[] input = scanner.next().split(",");
		
		int[][] gameState = new int[9][7]; 
		for(int i = 0; i<input.length;i++) {
			gameState[i/7][i%7] = Integer.parseInt(input[i]);
		}
		
		printGameState(gameState);
		*/
		
		Board b = new Board();
		while(!b.isGameOver()) {
			System.out.println(b.toString());
			System.out.println();
			b.move(Integer.parseInt(scanner.nextLine()),Integer.parseInt(scanner.nextLine()));
			System.out.println(b.toString());
			System.out.println();
			MinMax.run(b.getTurn(), b, 4);
			System.out.println(Arrays.toString(MinMax.lastMove));
		}
		
		//scanner.close();	
	}
	
	public static void printGameState(int[][] gameState){
		for(int i = 0; i<gameState.length;i++) {
			for(int j = 0; j<gameState[0].length;j++) {
				System.out.print(gameState[i][j]+" ");
			}
			System.out.println();
		}
	}

}
