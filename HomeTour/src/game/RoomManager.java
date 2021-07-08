package game;

import fixtures.Room;

public class RoomManager {
	
	// All room instances
	
	// bedroom
	Room bedroom = new Room(
			"bedroom",
			"It's a small bedroom with one window.",
			"A small bedroom, there are several plants and a futon " + 
					"folded neatly against the wall. A single window faces" +
					"east and a door faces west."
			);
	// bedroom exits
	//bedroom.exits
	
	// upper landing
	Room upstairsLanding = new Room(
			"hallway", 
			"A small hallway that appears to be the 2nd floor landing of a" +
					"building.",
			"A short hallway at the top of a set of stairs. A mirror hangs" +
					"on the wall to the south. At the end of the hall, to " +
					" the north, there are stairs leading down. To the south"+
					" there is a door. West, and directly ahead, there is a" +
					" second door."
			);
	
	
	// Starting state
	Room startingRoom = bedroom;

	Room[] rooms;
}
