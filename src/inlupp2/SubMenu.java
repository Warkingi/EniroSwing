package inlupp2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubMenu extends JPanel {
	SubMenu() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		JLabel newLabel = new JLabel("New: ");
		JComboBox newCombo = new JComboBox(new String[]{"Named", "Described"});
		JButton search = new JButton("Search");
		JButton hide = new JButton("Hide");
		JButton remove = new JButton("Remove");
		JButton whatIsHere = new JButton("What is here?");
		
		add(newLabel);
		add(newCombo);
		add(search);
		add(hide);
		add(remove);
		add(whatIsHere);
	}
}
