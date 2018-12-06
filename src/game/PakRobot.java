package game;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;

public class PakRobot extends Agent {
	private char lastRotationKey = 'd';
	
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
				default:
					return;
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
				default:
					return;
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
				default:
					return;
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
				default:
					return;
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
