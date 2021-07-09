package game;

import java.util.HashMap;

import fixtures.Room;


public class RoomManager {
	
	// this will hold all room instances
	HashMap<String, Room> rooms = new HashMap<>();
	Room startingRoom;
	

	// initializes the rooms exits
	public void mapInitializer() {
		
		// ALL ROOMS
		// bedroom
		Room bedroom = new Room(
				"bedroom",
				"A small bedroom with one window.",
				"A small bedroom, there are several plants and a futon " + 
						"folded neatly against the wall. A single window faces" +
						"east and a door faces west. There is a mess desk by the " +
						"south wall.",
				new String[] {"W"}
				);
		
		// upper landing
		Room upstairsLanding = new Room(
				"hallway", 
				"A small hallway that appears to be the 2nd floor landing of a" +
						" building.",
				"A short hallway at the top of a set of stairs. A mirror hangs" +
						"on the wall to the south. At the end of the hall, to " +
						" the north, there are stairs leading down. To the south"+
						" there is a door. West, and directly ahead, there is a" +
						" second door.",
				new String[] {"N", "E", "S", "W"}
				);
		
		// living room
		Room livingRoom = new Room(
				"living room",
				"A large room with windows letting in light on the south side.",
				"A large room with windows along the south wall facing a " +
						"neighboring building. In the middle of the south wall is" + 
						" a fireplace. To the west an open door leads into a " +
						"kitchen, and to the east, there is a closed door.",
				new String[] {"N", "E", "W"}
				);
		
		// attic
		Room attic = new Room(
				"attic",
				"A dusty room filled with junk from the previous owners.",
				"The ceiling is slanted, but tall enough to stand. The room runs " +
						"north to south, with a small, high window in each gable." +
						"There is every kind of junk you could imagine in here. " +
						"Old wooden speakers, croquet mallets, a supremely gross " +
						"stuffed deer head, and who knows what else.",
				new String[] {"E"}
				);
		
		// kitchen
		Room kitchen = new Room(
				"kitchen",
				"A kitchen with a table by the south wall. Stove, sink, and fridge.",
				"A small kitchen with an open door to the living room in the east." +
						" There are windows along the south wall by the table." +
						" Some mail sits on the table, unopened. Another hallway " +
						" is attached to the north side of the room, leading out " +
						"of sight.",
				new String[] {"N", "E"}
				);
		
		// roommate's room
		Room bedroom2 = new Room(
				"another bedroom",
				"A bedroom with a bed in the center.",
				"A large, neat bedroom with a bed in the center of it. The bed is " +
						"covered in a floral, homemade quilt. There is a fireplace" +
						" on the south wall and windows letting in lots of light." +
						" There appears to be some jewelry on the mantlepiece of " +
						"the fireplace.",
				new String[] {"W"}
				);
		
		// foyer
		Room foyer = new Room(
				"foyer",
				"A small entry hall.",
				"A small entry hall at the bottom of the stairs. There looks to be" +
						" a second apartment on this floor, and you can hear " +
						"barking from within, and dog leashes hang on the wall by " +
						" the front door to the west.",
				new String[] {"E", "W"}
				);
		
		// store the rooms in the room dictionary
		this.rooms.put("bedroom", bedroom);
		this.rooms.put("hallway", upstairsLanding);
		this.rooms.put("living room", livingRoom);
		this.rooms.put("attic", attic);
		this.rooms.put("kitchen", kitchen);
		this.rooms.put("another bedroom", bedroom2);
		
		// initialize the exits
		Room[] bedroomExits = bedroom.roomArray(upstairsLanding);
		bedroom.fillExits(bedroomExits, bedroom.getCardinalExits());
		
		Room[] atticExits = attic.roomArray(upstairsLanding);
		attic.fillExits(atticExits, attic.getCardinalExits());
		
		Room[] bedroom2Exits = bedroom2.roomArray(livingRoom);
		bedroom2.fillExits(bedroom2Exits, bedroom2.getCardinalExits());
		
		Room[] livingRoomExits = livingRoom.roomArray(upstairsLanding, bedroom2,
				kitchen);
		livingRoom.fillExits(livingRoomExits, livingRoom.getCardinalExits());
		
		Room[] upstairsLandingExits = upstairsLanding.roomArray(foyer, 
				bedroom, livingRoom, attic);
		upstairsLanding.fillExits(upstairsLandingExits, upstairsLanding.getCardinalExits());
		
		
		
		// Initialize the first room
		this.startingRoom = bedroom;
		
		
		
		
		
	}
	
}
