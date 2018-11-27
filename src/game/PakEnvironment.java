package game;

import java.util.ArrayList;
import java.util.HashMap;

import simbad.gui.Simbad;
import simbad.sim.BlockWorldObject;
import simbad.sim.EnvironmentDescription;

public class PakEnvironment extends EnvironmentDescription {
	private HashMap<String, ArrayList<BlockWorldObject>> environmentObjects;
	
	public PakEnvironment() {
		this.environmentObjects = EnvironmentParser.parseEnvironment(this, "./levels/1.txt");
	}
	
	public static void main(String[] args) {
		Simbad frame = new Simbad(new PakEnvironment(), false);
	}
}
