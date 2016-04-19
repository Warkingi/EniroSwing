package inlupp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class LoadPlacesListener implements ActionListener {
	
	private Map map;
	private JFileChooser fileChooser = new JFileChooser(".");
	
	public LoadPlacesListener(Map map) {
		this.map = map;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int answer = fileChooser.showOpenDialog(null);
		
		if (answer == JFileChooser.APPROVE_OPTION) {
			File fil = fileChooser.getSelectedFile();
			//Load places
		}
	}

}
