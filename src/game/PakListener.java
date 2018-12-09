package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import simbad.sim.Simulator;

public class PakListener implements KeyListener {
	private PakRobot pak;
	private Simulator simulator;
	private PakConfiguration config;
	private boolean walking;
	
	public PakListener(PakRobot pak, Simulator simulator, PakConfiguration config) {
		this.pak = pak;
		this.simulator = simulator;
		this.config = config;
		walking = false;
	}
	
	/**
	 * Method called by the javax API when we pressed a key. It will change the speed/direction of our robot (aka Player).
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (!walking && e.getKeyChar() == config.getKeys().getStart()) {
			simulator.startSimulation();
			pak.updateSpeed(2.5);
			walking = true;
			return;
		} else if (!walking) {
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
