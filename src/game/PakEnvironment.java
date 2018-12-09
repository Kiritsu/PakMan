package game;

import java.util.ArrayList;
import java.util.HashMap;

import simbad.sim.EnvironmentDescription;

public class PakEnvironment extends EnvironmentDescription {
	private HashMap<String, ArrayList<Object>> environmentObjects;
	private PakLevel level;
	private int nbCherries;
	
	public PakEnvironment(PakLevel level) {
		this.level = level;
	}
	
	/**
	 * This initializes the environmentObjects and parse our different entities.
	 */
	public void initialize(String levelPath) {
		environmentObjects = PakEnvironmentParser.parseEnvironment(this, levelPath, level);
		setWorldSize(22);
		createWorld();
		nbCherries = environmentObjects.get("Point").size();
	}
	
	/**
	 * Initializes the world of our environment.
	 */
	private void createWorld() {
		for (String key : environmentObjects.keySet()) {
			for (Object bwo : environmentObjects.get(key)) {
				add(bwo);
			}
		}
	}
	
	/**
	 * Returns the amount of Cherries (AKA Points) in the current world.
	 */
	public int getNbCherries() {
		return nbCherries;
	}
	
	/**
	 * Returns our player robot.
	 */
	public PakRobot getPlayer() {
		return (PakRobot) environmentObjects.get("Player").get(0);
	}
}
