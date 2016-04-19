package inlupp2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.*;

public class NamedPlace extends JComponent {
	private String name;
	private Position pos;
	
	private static final int size = 15;
	
	NamedPlace(String name, Position pos) {
		this.name = name;
		this.pos = pos;
		
		setPreferredSize(new Dimension(size * 2, size * 2 + 1)); //Add one due to fix triangle bottom shape cutting
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		Polygon trianglePol = new Polygon(new int[]{pos.getX() + size, pos.getX() + size * 2, pos.getX()}, new int[]{pos.getY(), pos.getY() + size * 2, pos.getY() + size * 2}, 3);
		g2d.setColor(Color.BLUE);
		g2d.fill(trianglePol);
	}
	
	public String getName() { return name; }
	public Position getPosition() { return pos; }
	public void setName(String name) { this.name = name; }
	public void setPosition(Position pos) { this.pos = pos; }
}
