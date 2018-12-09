package game;

import javax.vecmath.Vector3d;

import game.PakConfiguration.Keys;
import simbad.sim.Agent;

public class PakRobot extends Agent {
	private char lastRotationKey;
	private Keys keys;
	
	public PakRobot(Vector3d position, String name, PakConfiguration config) {
		super(position, name);
		this.keys = config.getKeys();
		this.lastRotationKey = this.keys.getRight();
	}
	
	/**
	 * Updates the speed of our robot (aka Player).
	 * @param speed New speed of our robot.
	 */
	public void updateSpeed(double speed) {
		setTranslationalVelocity(speed);
	}
	
	/**
	 * This tell our robot (aka Player) to change the direction as soon as possible.
	 * @param direction
	 */
	public void changeDirection(char key) {
		System.out.println(lastRotationKey);
		
		if (lastRotationKey == keys.getUp()) {
			if (key == keys.getLeft()) {
				rotateY(Math.PI / 2);
			} else if (key == keys.getDown()) {
				rotateY(Math.PI);
			} else if (key == keys.getRight()) {
				rotateY(-(Math.PI / 2));
			} else {
				return;
			}
		} else if (lastRotationKey == keys.getLeft()) {
			if (key == keys.getUp()) {
				rotateY(-(Math.PI / 2));
			} else if (key == keys.getDown()) {
				rotateY(Math.PI / 2);
			} else if (key == keys.getRight()) {
				rotateY(Math.PI);
			} else {
				return;
			}
		} else if (lastRotationKey == keys.getDown()) {
			if (key == keys.getUp()) {
				rotateY(Math.PI);
			} else if (key == keys.getLeft()) {
				rotateY(-(Math.PI / 2));
			} else if (key == keys.getRight()) {
				rotateY(Math.PI / 2);
			} else {
				return;
			}
		} else if (lastRotationKey == keys.getRight()) {
			if (key == keys.getUp()) {
				rotateY(Math.PI / 2);
			} else if (key == keys.getLeft()) {
				rotateY(Math.PI);
			} else if (key == keys.getDown()) {
				rotateY(-(Math.PI / 2));
			} else {
				return;
			}
		} 	
		
		lastRotationKey = key;
	}
	
	public void initBehavior() {
	}
	
	public void performBehavior() {
	}
}
