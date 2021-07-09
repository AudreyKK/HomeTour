package game;

import java.util.Scanner;
import game.Player;
import game.RoomManager;
import game.Parser;

public class Main {
	private static boolean running = true;
	
	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		Player p = new Player();
		Parser parser = new Parser();
		
		rm.mapInitializer();
		p.currentRoom = rm.startingRoom;
		
		while(running) {
			
			printRoom(p); // display state
			String[] input = collectInput(); // collect input
			// process input
			// update state
			// repeat 
			
			running = false;
			
		}
	}
	
	//
	static void printRoom(Player player) {
		System.out.println(player.currentRoom.getShortDescription());
	}
	
	//
	private static String[] collectInput() {
		Scanner sc = new Scanner(System.in);
		String[] input = new String[8];
		
		input = sc.nextLine().split("\\s");
		
		sc.close();
		return input;
	}
	
	public static void endGame() {
		running = false;
	};
}
