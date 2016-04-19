package inlupp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ExitListener implements ActionListener {

	private JFrame application;
	
	ExitListener(JFrame application) { this.application = application; }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.dispatchEvent(new WindowEvent(application, WindowEvent.WINDOW_CLOSING));
	}
}
