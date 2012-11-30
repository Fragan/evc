package app;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;


	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new ControlsPanel(), BorderLayout.WEST);
		add(new CanvasLoader(), BorderLayout.CENTER);
		
		setSize(800, 600);
		setPreferredSize(getSize());
		
		pack();
	}
	


	public static void main(String[] args) {
		App app = new App();
		app.setVisible(true);
	}

}
