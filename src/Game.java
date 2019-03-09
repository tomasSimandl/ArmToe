import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(args[0].getBytes());
		
		Scanner scanner = new Scanner(is); //System.in
		String[] input = scanner.next().split(",");
		
		int[][] gameState = new int[9][7]; 
		for(int i = 0; i<input.length;i++) {
			gameState[i/7][i%7] = Integer.parseInt(input[i]);
		}
		
		printGameState(gameState);
		
		
		scanner.close();	
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
