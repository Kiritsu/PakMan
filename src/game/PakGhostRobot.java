package game;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;

public class PakGhostRobot extends Agent {
	private double speed;
	
	public PakGhostRobot(Vector3d position, String name, double speed) {
		super(position, name);
		this.setCanBeTraversed(false);
		this.speed = speed;
		this.setColor(new Color3f(255, 255, 255));
	}
	
	public void initBehavior() {
		
	}
	
	public void performBehavior() {
		setTranslationalVelocity(speed);

		if (collisionDetected()) {
			int rnd = (int)(Math.random() * 100);
			if (rnd < 25) {
				rotateY(Math.PI);
			} else {
				if (rnd < 62) {
					rotateY(Math.PI / 2);
				} else {
					rotateY(-(Math.PI / 2));
				}
			}
		}
	}
}
