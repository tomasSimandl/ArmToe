import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		InputStream is = new ByteArrayInputStream(((String)args[1]).getBytes());
		
		Scanner scanner = new Scanner(is); //System.in
		int myInt = scanner.nextInt();
		
		
		System.out.println(myInt);
		
		
		scanner.close();	
	}

}
