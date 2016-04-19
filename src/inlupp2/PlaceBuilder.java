package inlupp2;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlaceBuilder extends MouseAdapter {
	private Map map;
	private SubMenu subMenu;
	private CategoryMenu categoryMenu;
	
	PlaceBuilder(Map map, SubMenu subMenu, CategoryMenu categoryMenu) { 
		this.map = map; 
		this.subMenu = subMenu;
		this.categoryMenu = categoryMenu;
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) { //Left click
			Map clickedMap = (Map) e.getSource();
			if (!map.equals(clickedMap)) return;
			
			String type = (String)subMenu.getNewCombo().getSelectedItem();
			
			if (type == "Named") {
				newNamedPlace(e.getX(), e.getY());
			} else if (type == "Described") {
				newDescribedPlace(e.getX(), e.getY());
			}
		}
	}
	
	public void crossCursor() {
		Cursor c = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
		map.setCursor(c);
	}
	
	private void newNamedPlace(int x, int y) {
		JPanel form = new JPanel();
		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
		
		JPanel row = new JPanel();
		JTextField nameField = new JTextField(8);
		row.add(new JLabel("Name: "));
		row.add(nameField);
		
		form.add(row);
		
		JOptionPane.showMessageDialog(null, form, "New NamedPlace", JOptionPane.QUESTION_MESSAGE);
		
		map.addPlace(new NamedPlace(nameField.getText(), new Position(x,y), getSelectedCategory()));
		map.repaint();
	}
	
	private void newDescribedPlace(int x, int y) {
		JPanel form = new JPanel();
		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
		
		JPanel row = new JPanel();
		JTextField nameField = new JTextField(8);
		row.add(new JLabel("Name: "));
		row.add(nameField);
		
		JPanel row2 = new JPanel();
		JTextField descField = new JTextField(8);
		row2.add(new JLabel("Description: "));
		row2.add(descField);
		
		form.add(row);
		form.add(row2);
		
		JOptionPane.showMessageDialog(null, form, "New DescribedPlace", JOptionPane.QUESTION_MESSAGE);
		
		map.addPlace(new DescribedPlace(nameField.getText(), new Position(x,y), descField.getText(), getSelectedCategory()));
		map.repaint();
	}
	
	private Category getSelectedCategory() { 
		String categoryName = (String) categoryMenu.getOptionList().getSelectedValue();
		return map.getCategory(categoryName);
	}
	
	public void setCategoryMenu(CategoryMenu categoryMenu) { this.categoryMenu = categoryMenu; }
}
