package game;

import java.util.Scanner;
import game.Player;
import game.RoomManager;

public class Main {
	
	public static void main(String[] args) {
		boolean running = true;
		RoomManager rm = new RoomManager();
		Player p = new Player();
		
		rm.mapInitializer();
		p.currentRoom = rm.startingRoom;
		
		while(running) {
			
			printRoom(p);
			String[] input = collectInput();
			
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
	
	//
	private static void parse(String[] command, Player player) {
		System.out.println("parse on parser");
	}

}
