package game;

import java.util.ArrayList;
import java.util.HashMap;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

public class PakEnvironment extends EnvironmentDescription {
	private HashMap<String, ArrayList<Object>> environmentObjects;
	
	/**
	 * This initializes the environmentObjects and parse our different entities.
	 */
	public PakEnvironment() {
		environmentObjects = PakEnvironmentParser.parseEnvironment(this, "./levels/1.txt");
	}
	
	/**
	 * Initializes the world of our environment.
	 */
	public void createWorld() {
		for (String key : environmentObjects.keySet()) {
			for (Object bwo : environmentObjects.get(key)) {
				add(bwo);
			}
		}
	}
	
	/**
	 * Returns our player robot, named Pak.
	 */
	public PakRobot getPak() {
		return (PakRobot) environmentObjects.get("Player").get(0);
	}
	
	public static void main(String[] args) {
		PakEnvironment instance = new PakEnvironment();
		instance.createWorld();
		
		Simbad frame = new Simbad(instance, false);
		frame.addKeyListener(new PakListener(instance.getPak()));
		
		PakThreading thread = new PakThreading(frame);
		thread.run();
	}
}
