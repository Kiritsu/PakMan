package game;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

import simbad.gui.Simbad;

public class PakCustomWindow extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private PakConfiguration config;
	
	private JPanel panel;
	private JLabel score;
	private JLabel rules;
	
	public PakCustomWindow(String name, Simbad instance, PakConfiguration config) {
		super(name);
		
		this.config = config;
		
		panel = new JPanel();
		score = new JLabel();
		rules = new JLabel();
		
		panel.setLayout(new GridLayout(10, 1));
		panel.add(rules);
		panel.add(score);
		setContentPane(panel);
	    setLocation(750, 10);
	    setSize(550, 700);
	}
	
	public void updateRules() {
		this.rules.setText("<html>" + config.getTextByKey("goal") + "<br>" + config.getTextByKey("robot") + "</html>");
		//this.rules.revalidate();
	}
	
	public void updateScore(int currentScore) {
		score.setText("Vous avez " + currentScore + " points.");
	}
}
