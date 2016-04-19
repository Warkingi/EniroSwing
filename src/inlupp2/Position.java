package inlupp2;

public class Position {
	private int x, y;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Position) {
			Position p = (Position) other;
			
			return getX() == p.getX() && getY() == p.getY();
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getX() * 100000 + getY();
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }	
}
