package inlupp2;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaceBuilder extends MouseAdapter {
	private Map map;
	private CategoryMenu categoryMenu;
	
	PlaceBuilder(Map map, CategoryMenu categoryMenu) { this.map = map; this.categoryMenu = categoryMenu;}
	
	public void mousePressed(MouseEvent e) {
		Map clickedMap = (Map) e.getSource();
		if (!map.equals(clickedMap)) return;
		
		String categoryName = (String) categoryMenu.getOptionList().getSelectedValue();
		Category category = map.getCategory(categoryName);
		//If no category selection has been made cancel action
		if (category == null) return;
		
		map.addPlace(new NamedPlace("Foo", new Position(e.getX(), e.getY()), category));
		map.repaint();
	}
	
	public void newPlace() { crossCursor(); }
	
	public void crossCursor() {
		Cursor c = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
		map.setCursor(c);
	}
	
	private Category getCategory() { return null; }
	public void setCategoryMenu(CategoryMenu categoryMenu) { this.categoryMenu = categoryMenu; }
}
