package inlupp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class NewPlaceComboListener implements ActionListener {
	private Map map;
	private SubMenu subMenu;
	private CategoryMenu categoryMenu;
	
	NewPlaceComboListener(Map map, SubMenu subMenu, CategoryMenu categoryMenu) {
		this.map = map;
		this.subMenu = subMenu;
		this.categoryMenu = categoryMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String type = (String)subMenu.getNewCombo().getSelectedItem();
		String category = (String) categoryMenu.getOptionList().getSelectedValue();
		
		//If no category selection has been made cancel action
		if (category == null) { 
			return;
		}
		
		if (type.equalsIgnoreCase("Named")) {
		} else if (type.equalsIgnoreCase("Described")) {
		}
	}
	
	private void newNamed() {
		
	}
	
	private void newDescribed() {
		
	}
}
