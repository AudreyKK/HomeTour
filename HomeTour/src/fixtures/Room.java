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
