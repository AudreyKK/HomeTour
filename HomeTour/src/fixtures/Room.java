package fixtures;

import java.util.HashMap;
import java.util.Set;

public class Room extends Fixture{
	
	public static void main(String[] args) {
//		Room roomy = new Room("name", "short", "long", new String[] {"N"});
//		System.out.println(roomy.name);
//		System.out.println(roomy.getName());
	}

	// 2 dimensional array that holds room objects
	Room[][] exits;
	
	// array of strings are formatted as a single letter or two letters
	// the first letter dictates cardinal direction
	// the second letter dictates left or right
	// example: "NR" north right, or "WL" west left
	String[] cardinalExits;
	
	// String descriptions for if the player wants to look where they're going.
	String northDescription;
	String eastDescription;
	String southDescription;
	String westDescription;
	
	// the stuff you can interact with in a room
	HashMap<String, Object> stuff = new HashMap<>();
	
	// Constructor
	public Room(String name, String shortDescription, String longDescription,
			String[] cardinalExits) {
		super(name, shortDescription, longDescription);
		
		// 4 arrays for the 4 cardinal directions 0 through 3 are NESW 
		// respectively. In each direction there can be at most 2 exits, but
		// this can and probably will change. 
		//
		// For now, the optional 2 indices will represent exits going from left
		// to right (index 0=Left, index 1=Right).
		// Could also change capacity to account for exits that go up or down.
		this.exits = new Room[4][2];
		this.cardinalExits = new String[8];
		this.cardinalExits = cardinalExits;
	}
	
	//
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	// 
	public String getLongDescription() {
		return this.longDescription;
	}
	
	//
	public String getName() {
		return this.name;
	}
	
	//
	public Room[][] getExits() {
		return this.exits;
	}
	
	// get cardinal exits
	public String[] getCardinalExits() {
		return this.cardinalExits;
	}
	
	// set the value of a single exit
	public void setExit(int cardinal, int leftOrRight,Room room) {
		this.exits[cardinal][leftOrRight] = room;
	}
	
	// place an object in a room so it can be interacted with
	public void setStuff(Fixture object) {
		this.stuff.put(object.getName(), object);
	}
	
	// determine if object is in room and therefore within range of interaction
	public boolean inRoom(String objectName) {
		Set<String> keys = this.stuff.keySet();
		for (String s: keys) {
			if (s == objectName) {
				return true;
			}
		}
		return false;
	}
	
	// returns a dictionary
	public HashMap<String, Object> getStuff() {
		return this.stuff;
	}
	
	// returns an array of rooms
	public Room[] roomArray(Room... rooms) {
		return rooms;
	}
	
	// automatically fill the rooms with null or Room values. instead 
	// of assigning exits one at a time
	// THE LENGTH OF ROOMS AND DIRECTIONS HAS TO BE THE SAME AND THEIR 
	// INDICES SHOULD BE RESPECTIVE
	public void fillExits(Room[] rooms, String... directions) {
		for (int i = 0; i < directions.length; i++) {
			switch(directions[i]) {
				case("NL"): // allow fall through for same functionality
				case("N"): {
					this.exits[0][0] = rooms[i];
					break;
				}
				case("EL"):
				case("E"):  {
					this.exits[1][0] = rooms[i];
					break;
				}
				case("SL"):
				case("S"): {
					this.exits[2][0] = rooms[i];
					break;
				}
				case("WL"):
				case("W"): {
					this.exits[3][0] = rooms[i];
					break;
				}
				case("NR"): {
					this.exits[0][1] = rooms[i];
					break;
				}
				case("ER"): {
					this.exits[1][1] = rooms[i];
					break;
				}
				case("SR"): {
					this.exits[2][1] = rooms[i];
					break;
				}
				case("WR"): {
					this.exits[3][1] = rooms[i];
					break;
				}
				default:
					break;
			}
		}
	}
	
	// If only the cardinal direction is given, we will assume the returned
	// index is this.exits[cardinalDirection][0]
	public Room getExit(int cardinalDirection) {
		return this.exits[cardinalDirection][0];
	}
	
	// Overloaded method
	public Room getExit(int cardinalDirection, int leftOrRight) {
		return this.exits[cardinalDirection][leftOrRight];
	}
	
	// Does this exit exist? Returns true if cardinal direction value is present
	public boolean exitExist(String direction) {
		direction = direction.toUpperCase().intern();
		for (int i = 0; i < this.cardinalExits.length; i++) {
			if (this.cardinalExits[i] == direction) {
				return true;
			}
		}
		return false;
	}
	
}

