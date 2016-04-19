package inlupp2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubMenu extends JPanel {
	private JLabel newLabel = new JLabel("New: ");
	private JComboBox newCombo = new JComboBox(new String[]{"Named", "Described"});
	private JButton search = new JButton("Search");
	private JButton hide = new JButton("Hide");
	private JButton remove = new JButton("Remove");
	private JButton whatIsHere = new JButton("What is here?");
	
	SubMenu() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		add(newLabel);
		add(newCombo);
		add(search);
		add(hide);
		add(remove);
		add(whatIsHere);
	}
	
	public JLabel getNewLabel() { return newLabel; }
	public JComboBox getNewCombo() { return newCombo; }
	public JButton getSearch() { return search; }
	public JButton getHide() { return hide; }
	public JButton getRemove() { return remove; }
	public JButton getWhatIsHere() { return whatIsHere; }
	
}
