package fixtures;

public abstract class Fixture {
	
	// 
	protected String name;
	//
	protected String shortDescription;
	//
	protected String longDescription;
	
	public Fixture(String name, String shortDesc, String longDesc) {
		super();
		this.name = name;
		this.shortDescription = shortDesc;
		this.longDescription = longDesc;
	}
}
