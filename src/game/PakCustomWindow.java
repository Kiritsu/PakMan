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
	private JLabel lifes;
	private JLabel gameover;
	
	public PakCustomWindow(String name, Simbad instance, PakConfiguration config) {
		super(name);
		
		this.config = config;
		
		panel = new JPanel();
		score = new JLabel();
		rules = new JLabel();
		lifes = new JLabel();
		gameover = new JLabel();
		gameover.setVisible(false);
		gameover.setText("<html><p style=\"font-size: 50px\">GAME OVER</p></html>");
		
		panel.setLayout(new GridLayout(10, 1));
		panel.add(rules);
		panel.add(score);
		panel.add(lifes);
		panel.add(gameover);
		
		setContentPane(panel);
	    setLocation(750, 10);
	    setSize(550, 700);
	}
	
	public void updateRules() {
		rules.setText("<html>" + config.getTextByKey("goal") + "<br>" + config.getTextByKey("robot") + "</html>");
	}
	
	public void updateScore(int currentScore) {
		score.setText("Vous avez " + currentScore + " point(s).");
	}
	
	public void updateLife(int life) {
		score.setText("Il vous reste " + life + " vie(s).");
		if (life == 0) {
			gameover.setVisible(true);
		}
	}
}