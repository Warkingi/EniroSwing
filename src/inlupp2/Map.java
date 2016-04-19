package inlupp2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.*;

public class Map extends JLabel {
	private HashMap<Position, NamedPlace> places = new HashMap<Position, NamedPlace>();
	private HashMap<String, Category> categories = new HashMap<String, Category>();
	
	Map() {
		Category busses = new Category("Busses", Color.CYAN);
		
		NamedPlace place = new NamedPlace("Foo", new Position(0, 0), busses);
		NamedPlace place2 = new NamedPlace("Bar", new Position(30, 0), busses);
		
		places.put(place.getPosition(), place);
		places.put(place2.getPosition(), place2);
	}
	
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
	
	public void addCategory(Category category) {
		categories.put(category.getName(), category);
	}
	
	public void addPlace(NamedPlace place) {
		places.put(place.getPosition(), place);
	}
	
	private void paintPlaces(Graphics g) {
		Iterator<Entry<Position, NamedPlace>> it = places.entrySet().iterator();
		
		while (it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			
			NamedPlace place = (NamedPlace) pair.getValue();
			place.setBounds(0, 0, place.SIZE, place.SIZE);
			place.paintComponent(g);
		}
	}
}
