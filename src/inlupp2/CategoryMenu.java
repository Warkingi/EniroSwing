package inlupp2;

import java.awt.BorderLayout;

import javax.swing.*;

public class CategoryMenu extends JPanel {
	CategoryMenu() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel categories = new JLabel("Categories");
		JList optionList = new JList(new String[] {"Buss", "Tunnelbana", "Tåg"});
		JButton hideCategory = new JButton("Hide category");
		
		panel.add(categories, BorderLayout.NORTH);
		panel.add(optionList, BorderLayout.CENTER);
		panel.add(hideCategory, BorderLayout.SOUTH);
		
		add(panel);
	}
}
