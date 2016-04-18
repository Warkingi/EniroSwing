package inlupp2;

public class NamedPlace {
	private String name;
	private Position pos;
	
	NamedPlace(String name, Position pos) {
		this.name = name;
		this.pos = pos;
	}
	
	public String getName() { return name; }
	public Position getPosition() { return pos; }
	public void setName(String name) { this.name = name; }
	public void setPosition(Position pos) { this.pos = pos; }
}
