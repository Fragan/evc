package app;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ControlsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton moveToButton;
	private JRadioButton moveRButton;
	private JRadioButton rotateRButton;
	
	public ControlsPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		moveToButton = new JButton("MOVE TO");
		moveRButton = new JRadioButton("MOVE");
		rotateRButton = new JRadioButton("ROTATE");
		
		add(moveToButton);
		add(moveRButton);
		add(rotateRButton);
	}
	
	
}
