package simpleos.io;

import java.util.Scanner;

public class StandardInput {
	
	private Scanner scanner;
	
	public StandardInput() {
		scanner = new Scanner(System.in);
	}
	public int in() {
		int input = -1;
		try {
			input = scanner.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return input;
	}

}
