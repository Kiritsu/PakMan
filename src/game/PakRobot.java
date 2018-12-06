package game;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;

public class PakRobot extends Agent {
	private char lastRotationKey = 's';
	
	public PakRobot(Vector3d position, String name) {
		super(position, name);
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
		switch (lastRotationKey) {
			case 'z':
				switch (key) {
				case 'q':
					rotateY(Math.PI / 2);
					break;
				case 's':
					rotateY(Math.PI);
					break;
				case 'd':
					rotateY(-(Math.PI / 2));
					break;
				}
				break;
			case 'q':
				switch (key) {
				case 'z':
					rotateY(-(Math.PI / 2));
					break;
				case 's':
					rotateY(Math.PI / 2);
					break;
				case 'd':
					rotateY(Math.PI);
					break;
				}
				break;
			case 's':
				switch (key) {
				case 'z':
					rotateY(Math.PI);
					break;
				case 'q':
					rotateY(-(Math.PI / 2));
					break;
				case 'd':
					rotateY(Math.PI / 2);
					break;
				}
				break;
			case 'd':
				switch (key) {
				case 'z':
					rotateY(Math.PI / 2);
					break;
				case 'q':
					rotateY(Math.PI);
					break;
				case 's':
					rotateY(-(Math.PI / 2));
					break;
				}
				break;
		} 	
		
		lastRotationKey = key;
	}
	
	public void initBehavior() {
	}
	
	public void performBehavior() {
	}
}
