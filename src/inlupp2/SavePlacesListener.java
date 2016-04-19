package inlupp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;

public class SavePlacesListener implements ActionListener {
	private Map map;
	
	SavePlacesListener(Map map) { this.map = map; }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileOutputStream outFile = new FileOutputStream("file.dat");
			DataOutputStream out = new DataOutputStream(outFile);
			
			HashMap<Position, NamedPlace> places = map.getPlaces();
			Iterator it = places.entrySet().iterator();
			
			while (it.hasNext()) {
				HashMap.Entry pair = (HashMap.Entry) it.next();
				NamedPlace place = (NamedPlace) pair.getValue();
				
				String categoryName = place.getCategory().getName();
				
				String data = String.format("Named,%s,%d,%d,%s\n", categoryName, place.getPosition().getX(), place.getPosition().getY(), place.getName());
				out.writeChars(data);
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
