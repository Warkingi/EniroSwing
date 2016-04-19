package inlupp2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.*;

public class NamedPlace extends JComponent {
	public static final int SIZE = 15;
	
	private String name;
	private Category category;
	protected State state;
	protected Position pos;
	
	private boolean visible = true;
	private boolean selected = false;
	
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
		
		if (getVisible()) {
			
			if (state == State.FOLDED) {
				if (getSelected()) paintSelectedSquare(g);
				
				paintFolded(g);
			} else if (state == State.UNFOLDED) {
				paintUnfolded(g);
			}
			
		}
	}
	
	
	public void paintFolded(Graphics g) {
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
	
	public void paintSelectedSquare(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(pos.getX() - SIZE, pos.getY() - SIZE, SIZE * 2, SIZE);
	}
	
	public String getName() { return name; }
	public Position getPosition() { return pos; }
	public Category getCategory() { return category; }
	public void setName(String name) { this.name = name; }
	public boolean getVisible() { return visible; }
	public boolean getSelected() { return selected; }
	public void setPosition(Position pos) { this.pos = pos; }
	public void setCategory(Category category) { this.category = category; }
	public void setVisibile(boolean visible) { this.visible = visible; }
	public void setSelected(boolean selected) { this.selected = selected; }
}
