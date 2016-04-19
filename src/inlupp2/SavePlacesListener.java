package inlupp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;

public class SavePlacesListener implements ActionListener {
	private Map map;
	private JFileChooser fileChooser = new JFileChooser(".");
	
	SavePlacesListener(Map map) { this.map = map; }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			String filePath = null;
			
			int userSelection = fileChooser.showSaveDialog(null);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				filePath = file.getAbsolutePath();
			}
			
			FileWriter outFile = new FileWriter(filePath);
			PrintWriter out = new PrintWriter(outFile);
			
			HashMap<Position, NamedPlace> places = map.getPlaces();
			Iterator it = places.entrySet().iterator();
			
			while (it.hasNext()) {
				HashMap.Entry pair = (HashMap.Entry) it.next();
				NamedPlace place = (NamedPlace) pair.getValue();
				
				String categoryName = place.getCategory().getName();
				String data = String.format("Named,%s,%d,%d,%s", categoryName, place.getPosition().getX(), place.getPosition().getY(), place.getName());
				out.println(data);
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
