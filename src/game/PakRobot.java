package game;

import javax.vecmath.Vector3d;

import game.PakConfiguration.Keys;
import simbad.sim.Agent;
import simbad.sim.CherryAgent;
import simbad.sim.SimpleAgent;

public class PakRobot extends Agent {
	private PakLevel level;
	private char lastRotationKey;
	private Keys keys;
	
	public PakRobot(Vector3d position, String name, PakLevel level) {
		super(position, name);
		this.setCanBeTraversed(false);
		this.keys = level.getConfig().getKeys();
		this.lastRotationKey = this.keys.getRight();
		this.level = level;
	}
	
	/**
	 * Updates the speed of our robot (aka Player).
	 * @param speed New speed of our robot.
	 */
	public void updateSpeed(double speed) {
		setTranslationalVelocity(speed);
	}
	
	/**
	 * Tells our robot (aka Player) to change the direction as soon as possible.
	 * @param direction
	 */
	public void changeDirection(char key) {
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
		if (anOtherAgentIsVeryNear()) {
			SimpleAgent agent = getVeryNearAgent();
			if (agent instanceof CherryAgent) {
				agent.detach();
				level.addScore();
			} else if (agent instanceof PakGhostRobot) {
				level.decLife();
				moveToStartPosition();
				lastRotationKey = this.keys.getRight();
				agent.moveToStartPosition();
			}
		}
	}
}
