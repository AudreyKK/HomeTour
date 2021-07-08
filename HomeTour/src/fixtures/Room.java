package fixtures;

public class Room extends Fixture{

	//
	Room[][] exits;
	
	//
	public Room(String name, String shortDescription, String longDescription) {
		super();
		
		// 4 arrays for the 4 cardinal directions 0 through 3 are NESW 
		// respectively. In each direction there can be at most 2 exits, but
		// this can and probably will change. 
		//
		// For now, the optional 2 indices will represent exits going from left
		// to right (index 0=Left, index 1=Right).
		// Could also change capacity to account for exits that go up or down.
		this.exits = new Room[4][2];
	}
	
	//
	public Room[][] getExits() {
		return this.exits;
	}
	
	// set the value of a single exit
	public void setExit(int cardinal, int leftOrRight,Room room) {
		this.exits[cardinal][leftOrRight] = room;
	}
	
	// automatically fill the rooms with null or Room values. instead 
	// of assigning exits one at a time
	// THE LENGTH OF ROOMS AND DIRECTIONS HAS TO BE THE SAME AND THEIR 
	// INDICES SHOULD BE RESPECTIVE
	// [TODO] input validation
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
	
	// [TODO]
	// potentially make a directionToInt method
	
	// If only the cardinal direction is given, we will assume the returned
	// index is this.exits[cardinalDirection][0]
	public Room getExit(int cardinalDirection) {
		return this.exits[cardinalDirection][0];
	}
	
	//
	public Room getExit(int cardinalDirection, int leftOrRight) {
		return this.exits[cardinalDirection][leftOrRight];
	}
}
