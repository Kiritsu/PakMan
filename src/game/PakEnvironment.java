package game;

import java.util.ArrayList;
import java.util.HashMap;

import simbad.sim.EnvironmentDescription;

public class PakEnvironment extends EnvironmentDescription {
	private HashMap<String, ArrayList<Object>> environmentObjects;
	private PakConfiguration config;
	
	public PakEnvironment(PakConfiguration config) {
		this.config = config;
	}
	
	/**
	 * This initializes the environmentObjects and parse our different entities.
	 */
	public void initialize(String levelPath) {
		environmentObjects = PakEnvironmentParser.parseEnvironment(this, levelPath, config);
		setWorldSize(22);
		createWorld();
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
	 * Returns our player robot.
	 */
	public PakRobot getPlayer() {
		return (PakRobot) environmentObjects.get("Player").get(0);
	}
}
