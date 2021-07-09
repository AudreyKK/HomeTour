package fixtures;

public class Window extends Fixture implements Interactable{
	public Window(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}
	

	public void interact() {
		System.out.println(this.longDescription);
	}
	
	public String getName() {
		return this.name;
	}
}
