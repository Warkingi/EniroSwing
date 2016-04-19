package inlupp2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Application extends JFrame {
	
	private Menu menu = new Menu();
	private Map map = new Map();
	private SubMenu subMenu = new SubMenu();
	private CategoryMenu categoryMenu = new CategoryMenu(); 
	
	private JScrollPane mapScroll;
	
	Application() {
		prepareGUI();
		prepareListeners();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void prepareGUI() {
		setLayout(new BorderLayout());
		setJMenuBar(menu.getMenuBar());
		
		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(new BorderLayout());
		mapPanel.add(map, BorderLayout.NORTH);
		mapScroll = new JScrollPane(mapPanel);
		
		add(subMenu, BorderLayout.NORTH);
		add(mapScroll, BorderLayout.CENTER);
		add(categoryMenu, BorderLayout.EAST);
	}
	
	private void prepareListeners() {
		menu.getNewMap().addActionListener(new NewMapListener(map));
		menu.getLoadPlaces().addActionListener(new LoadPlacesListener(map));
	}
}
