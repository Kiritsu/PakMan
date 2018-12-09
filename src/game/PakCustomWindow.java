package game;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

import simbad.gui.Simbad;

public class PakCustomWindow extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel score;
	private JLabel rules;
	
	public PakCustomWindow(String name, Simbad instance) {
		super(name);
		panel = new JPanel();
		score = new JLabel();
		rules = new JLabel();
		
		panel.setLayout(new GridLayout(10, 1));
		panel.add(rules);
		panel.add(score);
		setContentPane(panel);
	    setLocation(750, 10);
	    
	    pack();
	}
	
	public void setRules(String rules) {
		this.rules.setText(rules);
	}
	
	public void updateScore(int currentScore) {
		score.setText("Vous avez " + currentScore + " points.");
	}
}
