package inlupp2;

import java.awt.Dimension;

import javax.swing.*;

public class Map extends JPanel {
	
	private JLabel map = new JLabel();
	
	Map() {
		add(map);
	}
	
	public void loadMap(String path) {
		ImageIcon mapIcon = new ImageIcon(path);
		map.setIcon(mapIcon);
	}
}
