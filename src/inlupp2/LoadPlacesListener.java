package inlupp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;

public class LoadPlacesListener implements ActionListener {
	
	private Map map;
	private JFileChooser fileChooser = new JFileChooser(".");
	
	public LoadPlacesListener(Map map) {
		this.map = map;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		loadPlaces();
	}
	
	private void loadPlaces() {
		int answer = fileChooser.showOpenDialog(null);
		
		if (answer == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			createPlaces(file.getAbsolutePath());
		}
	}
	
	private List<String> createPlaces(String path) {
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			while ((line=br.readLine()) != null) {
				String[] data = line.split(",");
				
				String type = data[0];
				String category = data[1];
				int x = Integer.parseInt(data[2]);
				int y = Integer.parseInt(data[3]);
				String name = data[4];
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
