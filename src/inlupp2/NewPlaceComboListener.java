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
		String categoryName = (String) categoryMenu.getOptionList().getSelectedValue();
		Category category = map.getCategory(categoryName);
		//If no category selection has been made cancel action
		if (category == null) return;
		
		PlaceBuilder builder = new PlaceBuilder(map, null, null);
		builder.crossCursor();
	}
}
