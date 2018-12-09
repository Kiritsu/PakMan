package game;

import javax.swing.*;

public class NoLevelFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * This frame is used to tell the 'user' that the game is over.
	 */
	public NoLevelFrame() {
		add(new JLabel("<html><p style=\"font-size: 75px;\">Vous avez terminé le jeu !<br/>Merci d'avoir joué.</p></html>"));
		setSize(300, 300);
		setVisible(true);
		pack();
	}
}
