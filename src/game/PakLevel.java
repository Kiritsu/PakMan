package game;

import simbad.gui.Simbad;
import simbad.sim.World;

public class PakLevel {
	private PakEnvironment env;
	private Simbad frame;
	private PakThreading thread;
	private String levelPath;
	
	public PakLevel(String levelPath) {
		this.levelPath = levelPath;
	}
	
	public void start() {
		env = new PakEnvironment();
		env.initialize(levelPath);
		
		frame = new Simbad(env, false);
		frame.getWorld().changeViewPoint(World.VIEW_FROM_TOP, null);
		frame.addKeyListener(new PakListener(env.getPlayer(), frame.getSimulator()));
		
		thread = new PakThreading(frame);
		thread.run();
	}
	
	public void stop() {
		thread.stop();
		frame.dispose();
	}
}
