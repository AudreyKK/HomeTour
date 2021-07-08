package game;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		boolean running = true;
		
		while(running) {
			
			// The core logic is that the game will describe the player's 
			// surroundings and then wait for the player's input. And this will
			// repeat until the game is quit.
			// the loop should have a boolean that only quits if player types
			// "quit" then there should be an "if hasNext, getNext, if quit,
			// then quit, otherwise do other functionality.
			
			//printRoom();
			//collectInput();
			Scanner sc = new Scanner(System.in);
			int index = 0;
			String[] input = new String[8];
			
			while (sc.hasNext()) {
				System.out.println("say something");
				input[index] = sc.next();
				System.out.println(input[index]);
				System.out.println(index);
				index = (1 + index);
			}
			sc.close();
			
			
			running = false;
		}
		
	}
	
	//
	static void printRoom(Player player) {
		System.out.println("play on player")
	}
	
	//
	private static String[] collectInput() {
		String[] strang = new String[5];
		return strang;
	}
	
	//
	private static void parse(String[] command, Player player) {
		System.out.println("parse on parser");
	}

}
