package game;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;

public class PakRobot extends Agent {
	private double translational;
	
	private boolean mustRotate;
	private double rotational;
	
	public PakRobot(Vector3d position, String name) {
		super(position, name);
		
		translational = 0;
		rotational = 0;
	}
	
	/**
	 * Updates the speed of our robot (aka Player).
	 * @param speed New speed of our robot.
	 */
	public void updateSpeed(double speed) {
		this.translational = speed;
	}
	
	/**
	 * This tell our robot (aka Player) to change the direction as soon as possible.
	 * @param direction
	 */
	public void changeDirection(double direction) {
		this.rotational = direction;
		this.mustRotate = true;
	}
	
	public void initBehavior() {
		
	}
	
	public void performBehavior() {
		setTranslationalVelocity(translational);
		
		if (mustRotate) {
			rotateY(rotational);
			mustRotate = false;
		}
	}
}
