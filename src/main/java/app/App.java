package app;

import java.awt.Canvas;
import java.io.File;

import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	private File fileWRML;

	public App() {
		fileWRML = new File("/ws/29001933/evc/java3d/samples/colorcube2.wrl");
		
		canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		
		
		setSize(800, 600);
		setPreferredSize(getSize());
		
		pack();
		
		this.add(canvas);
	}

	public static void main(String[] args) {
		App app = new App();
		app.setVisible(true);
	}

}
