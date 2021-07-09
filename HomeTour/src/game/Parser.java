package game;


public class Parser {

	// all commands
	
	// collection of movement commands
	public static String[] moves = 
		{"MOVE", "GO", "WALK", "NORTH", "EAST", "SOUTH", "WEST"}; 
	// movement commands that are not directions
	public static String[] reducedMoves = 
		{"MOVE", "GO", "WALK"};
	
	// collection of interaction commands
	public static String[] interactions = 
		{"INTERACT", "LOOK", "EXAMINE"};
	
	// collection of the cardinal directions
	public static String[] cardinalDirections = 
		{"NORTH", "EAST", "SOUTH", "WEST"};
	
	// simple linear search. returns true if input is in given array.
	public static boolean inArray(String str, String[] group) {
		for (int i = 0; i < group.length; i++) {
			if (str == group[i]) {
				return true;
			}
		}
		return false;
	}
	
	
	
	// If I had more time I would probably refactor my parse method into multiple
	// overloaded parse methods based on how long command was and what the main
	// action command was.
	public static void parse(String[] command, Player player) {
		String action = command[0].toUpperCase().intern();
		String object = "";
		if (command.length == 2) {
			object = command[1].toUpperCase().intern();
		}
		
		if (inArray(action, moves)) {
			// switch cases for movement
			if (command.length == 1) { 
				// if the player just types a direction, it will be assumed the
				// intention is movement
				switch(action) {
					case("NORTH"): {
						if (player.getCurrentRoom().exitExist("N")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(0));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					case("EAST"): {
						if (player.getCurrentRoom().exitExist("E")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(1));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					case("SOUTH"): {
						if (player.getCurrentRoom().exitExist("S")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(2));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					case("WEST"): {
						if (player.getCurrentRoom().exitExist("W")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(3));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					// no default case because if there is only one command and
					// it's on the list, there should be no error
				}
				
			} else if (command.length == 2 && inArray(action, reducedMoves) &&
						inArray(object, cardinalDirections)) {
				switch(object) {
					case("NORTH"): {
						if (player.getCurrentRoom().exitExist("N")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(0));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					case("EAST"): {
						if (player.getCurrentRoom().exitExist("E")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(1));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					case("SOUTH"): {
						if (player.getCurrentRoom().exitExist("S")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(2));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
					case("WEST"): {
						if (player.getCurrentRoom().exitExist("W")) {
							player.setCurrentRoom(
									player.getCurrentRoom().getExit(3));
						} else {
							System.out.println("No exits in that direction.");
						}
						break;
					}
				}
			}
		} else if (action == "QUIT") {
			Main.endGame();
		}
		
		
		
	}


}
