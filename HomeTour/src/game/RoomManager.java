package game;

import java.util.HashMap;

import fixtures.Room;
import fixtures.Window;


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
				"A small bedroom, there are several plants and a futon \n" + 
						"folded neatly against the wall. A single window faces\n" +
						"east and a door faces west. There is a mess desk by the \n" +
						"south wall.",
				new String[] {"W"}
				);
		
		// upper landing
		Room upstairsLanding = new Room(
				"hallway", 
				"A small hallway that appears to be the 2nd floor landing of a\n" +
						" building.",
				"A short hallway at the top of a set of stairs. A mirror hangs\n" +
						"on the wall to the south. At the end of the hall, to \n" +
						" the north, there are stairs leading down. To the south\n"+
						" there is a door. West, and directly ahead, there is a\n" +
						" second door.",
				new String[] {"N", "E", "S", "W"}
				);
		
		// living room
		Room livingRoom = new Room(
				"living room",
				"A large room with windows letting in light on the south side.\n",
				"A large room with windows along the south wall facing a \n" +
						"neighboring building. In the middle of the south wall is\n" + 
						" a fireplace. To the west an open door leads into a \n" +
						"kitchen, and to the east, there is a closed door.\n",
				new String[] {"N", "E", "W"}
				);
		
		// attic
		Room attic = new Room(
				"attic",
				"A dusty room filled with junk from the previous owners.",
				"The ceiling is slanted, but tall enough to stand. The room runs \n" +
						"north to south, with a small, high window in each gable.\n" +
						"There is every kind of junk you could imagine in here. \n" +
						"Old wooden speakers, croquet mallets, a supremely gross \n" +
						"stuffed deer head, and who knows what else.",
				new String[] {"E"}
				);
		
		// kitchen
		Room kitchen = new Room(
				"kitchen",
				"A kitchen with a table by the south wall. Stove, sink, and fridge.",
				"A small kitchen with an open door to the living room in the east.\n" +
						" There are windows along the south wall by the table.\n" +
						" Some mail sits on the table, unopened. Another hallway \n" +
						" is attached to the north side of the room, leading out \n" +
						"of sight.",
				new String[] {"N", "E"}
				);
		
		// roommate's room
		Room bedroom2 = new Room(
				"another bedroom",
				"A bedroom with a bed in the center.",
				"A large, neat bedroom with a bed in the center of it. The bed is \n" +
						"covered in a floral, homemade quilt. There is a fireplace\n" +
						" on the south wall and windows letting in lots of light.\n" +
						" There appears to be some jewelry on the mantlepiece of \n" +
						"the fireplace.",
				new String[] {"W"}
				);
		
		// foyer
		Room foyer = new Room(
				"foyer",
				"A small entry hall.",
				"A small entry hall at the bottom of the stairs. There looks to be\n" +
						" a second apartment on this floor, and you can hear \n" +
						"barking from within, and dog leashes hang on the wall by \n" +
						" the front door to the west.",
				new String[] {"E", "W"}
				);
		
		// bathroom
		Room bathroom = new Room (
				"bathroom",
				"A bathroom with a toilet, tub, and sink.",
				"It's a small bathroom with the usual amenities, plus several \n" +
						"rubber ducks sporting various costumes.",
				new String[] {"S"} 
				);
		
		Room porch = new Room (
				"porch",
				"A front porch facing a busy street.",
				"Large rhododendron bushes and sunflowers obscure the porch from \n" + 
				"the street. There are a couple comfortable chairs to sit in and \n" +
						"a windchime hangs overhead."),
				new String[] {"W"}
		);
		
		// store the rooms in the room dictionary
		this.rooms.put("bedroom", bedroom);
		this.rooms.put("hallway", upstairsLanding);
		this.rooms.put("living room", livingRoom);
		this.rooms.put("attic", attic);
		this.rooms.put("kitchen", kitchen);
		this.rooms.put("another bedroom", bedroom2);
		this.rooms.put("foyer", foyer);
		this.rooms.put("bathrrom", bathroom);
		this.rooms.put("porch", porch);
		
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
		
		Room[] bathroomExits = bathroom.roomArray(kitchen);
		bathroom.fillExits(bathroomExits, bathroom.getCardinalExits());
		
		Room[] foyerExits = foyer.roomArray(porch, upstairsLanding);
		foyer.fillExits(foyerExits, foyer.getCardinalExits());
		
		
		// create objects
		Window window = new Window(
				"window", 
				"A window.", 
				"You can see a cat sitting in the window of the neighboring " +
					"building.");
		
		// put the objects in the rooms
		livingRoom.setStuff(window);
		
		
		// Initialize the first room
		this.startingRoom = bedroom;
		
		
		
		
		
	}
	
}
