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
		
		if (this.getIcon() != null) { //If we have loaded a map
			paintPlaces(g);
		}
	}
	
	public void loadMap(String path) {
		ImageIcon mapIcon = new ImageIcon(path);
		this.setIcon(mapIcon);
	}
	
	private void paintPlaces(Graphics g) {
		Category busses = new Category("Busses", Color.CYAN);
		
		NamedPlace place = new NamedPlace("Hej", new Position(0, 0), busses);
		NamedPlace place2 = new NamedPlace("Hej", new Position(30, 0), busses);
		
		place.setBounds(0, 0, place.SIZE, place.SIZE);
		place2.setBounds(0, 0, place2.SIZE, place2.SIZE);
		
		place2.paintComponent(g);
		place.paintComponent(g);
	}
}
