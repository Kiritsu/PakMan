package game;

import javax.swing.*;

public class NoLevelFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * This frame is used to tell the 'user' that the game is over.
	 */
	public NoLevelFrame() {
		add(new JLabel("<html><p style=\"font-size: 50px;\">Vous avez termin� le jeu !<br/>Merci d'avoir jou�.</p></html>"));
		setSize(500, 500);
		setVisible(true);
	}
}
