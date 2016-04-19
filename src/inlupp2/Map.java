package inlupp2;

import java.awt.Dimension;

import javax.swing.*;

public class Map extends JPanel {
	
	private JLabel map = new JLabel();
	
	Map() {
		add(map);
		add(new NamedPlace("foo", new Position(0, 0)));
	}
	
	public void loadMap(String path) {
		ImageIcon mapIcon = new ImageIcon(path);
		map.setIcon(mapIcon);
	}
}
