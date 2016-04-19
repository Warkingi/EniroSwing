package inlupp2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.*;

public class NamedPlace extends JComponent {
	private String name;
	private Category category;
	protected State state;
	protected Position pos;
	
	public static final int SIZE = 15;
	
	public enum State {
		FOLDED,
		UNFOLDED
	}
	
	NamedPlace(String name, Position pos, Category category) {
		this.name = name;
		this.pos = pos;
		this.category = category;
		this.state = State.FOLDED;
		
		setPreferredSize(new Dimension(SIZE * 2, SIZE * 2 + 1)); //Add one due to fix triangle bottom shape cutting
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch(state) {
		case FOLDED:
			paintFolded(g);
			break;
		case UNFOLDED:
			paintUnfolded(g);
			break;
		}
	}
	
	public String getName() { return name; }
	public Position getPosition() { return pos; }
	public Category getCategory() { return category; }
	public void setName(String name) { this.name = name; }
	public void setPosition(Position pos) { this.pos = pos; }
	public void setCategory(Category category) { this.category = category; }
	
	private void paintFolded(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		Polygon trianglePol = new Polygon(new int[]{pos.getX(), pos.getX() + SIZE, pos.getX() - SIZE}, new int[] {pos.getY(), pos.getY() - SIZE, pos.getY() - SIZE}, 3);
		g2d.setColor(category.getColor());
		g2d.fill(trianglePol);
	}
	
	public void paintUnfolded(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		int rectWidth = 100;
		int rectHeight = 50;
		
		Rectangle backgroundRect = new Rectangle(pos.getX() - rectWidth/2, pos.getY() - rectHeight/2, rectWidth, rectHeight);
		
		g2d.setColor(Color.WHITE);
		g2d.fill(backgroundRect);
		
		int fontSize = g2d.getFont().getSize();
		g2d.setColor(Color.BLACK);
		g2d.drawString(getName(), pos.getX() - rectWidth/2 + fontSize , pos.getY() - rectHeight/2 + fontSize);
	}
}
