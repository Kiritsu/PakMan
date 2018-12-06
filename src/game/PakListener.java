package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import simbad.sim.Simulator;

public class PakListener implements KeyListener {
	private PakRobot pak;
	private Simulator simulator;
	private boolean walking;
	
	public PakListener(PakRobot pak, Simulator simulator) {
		this.pak = pak;
		this.simulator = simulator;
		walking = false;
	}
	
	/**
	 * Method called by the javax API when we pressed a key. It will change the speed/direction of our robot (aka Player).
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (!walking && e.getKeyChar() == ' ') {
			simulator.startSimulation();
			pak.updateSpeed(2.5);
			walking = true;
			return;
		}
		pak.changeDirection(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
