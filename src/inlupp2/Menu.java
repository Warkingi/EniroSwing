package inlupp2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Menu {
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu archiveMenu = new JMenu("Archive");
	private JMenuItem newMap = new JMenuItem("New Map");
	private JMenuItem loadPlaces = new JMenuItem("Load Places");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem exit = new JMenuItem("Exit");
	
	Menu() {
		prepareMenu();
	}
	
	private void prepareMenu() {
		menuBar.add(archiveMenu);
		
		archiveMenu.add(newMap);
		archiveMenu.add(loadPlaces);
		archiveMenu.add(save);
		archiveMenu.add(exit);
	}
	
	public JMenuBar getMenuBar() { return menuBar; }
	public JMenu getArchiveMenu() { return archiveMenu; }
	public JMenuItem getNewMap() { return newMap; }
	public JMenuItem getLoadPlaces() { return loadPlaces; }
	public JMenuItem getSave() { return save; }
	public JMenuItem getExit() { return exit; }
}
