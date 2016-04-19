package inlupp2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class DescribedPlace extends NamedPlace {
	private String description;
	
	DescribedPlace(String name, Position pos, String description, Category category) {
		super(name, pos, category);
		this.description = description;
		this.state = State.UNFOLDED;
	}
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	@Override
	public void paintUnfolded(Graphics g) {
		super.paintUnfolded(g);
		Graphics2D g2d = (Graphics2D) g.create();
		
		int rectWidth = 100;
		int rectHeight = 50;
		int fontSize = g2d.getFont().getSize();
		
		g2d.drawString(getDescription(), pos.getX() - rectWidth/2 + fontSize, pos.getY() - rectHeight/2 + fontSize * 2);
	}
}
