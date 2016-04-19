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
		prepareCategories();
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
	
	public void addCategory(Category category) { categories.put(category.getName(), category);}
	public void addPlace(NamedPlace place) { places.put(place.getPosition(), place); }
	public Category getCategory(String name) { return categories.get(name); }
	public HashMap<String, Category> getCategories() { return categories; }
	public HashMap<Position, NamedPlace> getPlaces() { return places; }
	
	private void paintPlaces(Graphics g) {
		Iterator<Entry<Position, NamedPlace>> it = places.entrySet().iterator();
		
		while (it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			
			NamedPlace place = (NamedPlace) pair.getValue();
			place.setBounds(0, 0, place.SIZE, place.SIZE);
			place.paintComponent(g);
		}
	}
	
	private void prepareCategories() {
		categories.put("Buss", new Category("Buss", Color.RED));
		categories.put("None", new Category("None", Color.BLACK));
		categories.put("Tunnelbana", new Category("Tunnelbana", Color.BLUE));
		categories.put("Tåg", new Category("Tåg", Color.GREEN));
	}
}
