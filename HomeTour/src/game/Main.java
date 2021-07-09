package game;

import java.util.Scanner;
import game.Player;
import game.RoomManager;
import game.Parser;

public class Main {
	private static boolean running = true;
	private static String spaces = "\n\n\n";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RoomManager rm = new RoomManager();
		Player p = new Player();
		Parser parser = new Parser();
		
		rm.mapInitializer();
		p.setCurrentRoom(rm.startingRoom);
		
		while(running) {
			
			printRoom(p); // display state
			String[] input = collectInput(sc); // collect input
			Parser.parse(input, p);// process input
			// update state
			// repeat 
			
			
		}
		sc.close();
	}
	
	//
	static void printRoom(Player player) {
		System.out.println(spaces);
		System.out.println(player.getCurrentRoom().getShortDescription());
		System.out.println(spaces);
	}
	
	//
	private static String[] collectInput(Scanner s) {
		String[] input = new String[8];
		
		input = s.nextLine().split("\\s");
		
		return input;
	}
	
	public static void endGame() {
		running = false;
	};
}
