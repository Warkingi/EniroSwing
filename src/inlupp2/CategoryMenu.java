package inlupp2;

import java.awt.BorderLayout;

import javax.swing.*;

public class CategoryMenu extends JPanel {
	private JLabel categories = new JLabel("Categories");
	private JList optionList = new JList(new String[] {"Buss", "Tunnelbana", "Tåg"});
	private JButton hideCategory = new JButton("Hide category");
	
	CategoryMenu() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		optionList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	
		panel.add(categories, BorderLayout.NORTH);
		panel.add(optionList, BorderLayout.CENTER);
		panel.add(hideCategory, BorderLayout.SOUTH);
		
		add(panel);
	}
	
	public JLabel getCategories() { return categories; }
	public JList getOptionList() { return optionList; }
	public JButton getHideCategory() { return hideCategory; }
}
