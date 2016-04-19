package inlupp2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.*;

public class Map extends JLabel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (this.getIcon() != null) {
			Graphics2D g2d = (Graphics2D) g.create();
			
			int size = 15;
			Position pos = new Position(0, 0);
			
			Polygon trianglePol = new Polygon(new int[]{pos.getX() + size, pos.getX() + size * 2, pos.getX()}, new int[]{pos.getY(), pos.getY() + size * 2, pos.getY() + size * 2}, 3);
			g2d.setColor(Color.BLUE);
			g2d.fill(trianglePol);
		}
	}
	
	public void loadMap(String path) {
		ImageIcon mapIcon = new ImageIcon(path);
		this.setIcon(mapIcon);
	}
}
