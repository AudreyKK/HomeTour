package game;


public class Parser {

	// all commands
	
	// collection of movement commands
	public static String[] moves = 
		{"MOVE", "GO", "WALK", "NORTH", "EAST", "SOUTH", "WEST"}; 
	
	// simple linear search. returns true if input is in given array.
	public static boolean inArray(String str, String[] group) {
		for (int i = 0; i < group.length; i++) {
			if (str == group[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void parse(String[] command, Player player) {
		String action = command[0].toUpperCase().intern();
		
		if (inArray(action, moves)) {
			System.out.println("todo");
		} else if (action == "QUIT") {
			Main.endGame();
		}
		
		
		
	}


}
