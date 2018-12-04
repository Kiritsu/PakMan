package game;

import java.util.ArrayList;
import java.util.HashMap;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

public class PakEnvironment extends EnvironmentDescription {
	private HashMap<String, ArrayList<Object>> environmentObjects;
	
	public PakEnvironment() {
		environmentObjects = EnvironmentParser.parseEnvironment(this, "./levels/1.txt");
	}
	
	public void createWorld() {
		for (String key : environmentObjects.keySet()) {
			for (Object bwo : environmentObjects.get(key)) {
				add(bwo);
			}
		}
	}
	
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
