package inlupp2;

public class DescribedPlace extends NamedPlace {
	private String description;
	
	DescribedPlace(String name, Position pos, String description) {
		super(name, pos);
		this.description = description;
	}
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
}
