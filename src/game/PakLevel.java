package game;

import simbad.gui.Simbad;
import simbad.sim.World;

public class PakLevel {
	private PakEnvironment env;
	private Simbad frame;
	private PakThreading thread;
	private PakCustomWindow window;
	private PakConfiguration config;
	private int level;
	
	public PakLevel(PakConfiguration config, int level) {
		this.config = config;
		this.level = level;
	}
	
	public void start() {
		env = new PakEnvironment(config);
		env.initialize("./levels/" + level + ".txt");
		
		frame = new Simbad(env, false);
		frame.getWorld().changeViewPoint(World.VIEW_FROM_TOP, null);
		frame.addKeyListener(new PakListener(env.getPlayer(), frame.getSimulator(), config));
		
		window = new PakCustomWindow("Pak Window", frame);
		frame.addFrame(window);
		
		thread = new PakThreading(frame);
		thread.run();
	}
	
	public void stop() {
		thread.stop();
		frame.dispose();
	}
}
