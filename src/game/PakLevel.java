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
	private int lifes;
	private int score;
	
	public PakLevel(PakConfiguration config, int level) {
		this.config = config;
		System.out.println(level);
		this.level = level;
		this.lifes = 3;
	}
	
	/**
	 * Will increment the score of the player.
	 */
	public void addScore() {
		this.score++;
		window.updateScore(score);
		
		if (score == env.getNbCherries()) {
			stop();
			
			PakLevel lvl = new PakLevel(config, ++level);
			lvl.start();
		}
	}
	
	/**
	 * Will decrease the life of the player.
	 */
	public void decLife() {
		this.lifes--;
		window.updateLife(lifes);
		
		if (this.lifes == 0) {
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			stop();
		}
	}
	
	public PakEnvironment getEnv() {
		return this.env;
	}
	
	public PakThreading getThreading() {
		return this.thread;
	}
	
	public PakCustomWindow getWindow() {
		return this.window;
	}
	
	public PakConfiguration getConfig() {
		return this.config;
	}
	
	/**
	 * Starts the game: it initializes the environment with the given level, creates the frame, 
	 * creates the other windows and start a special thread to keep focus on the frame (needed to catch keys pressed).
	 */
	public void start() {
		env = new PakEnvironment(this);
		env.initialize(System.getProperty("java.class.path").split(";")[0] + "/levels/" + level + ".txt");
		
		frame = new Simbad(env, false);
		frame.getWorld().changeViewPoint(World.VIEW_FROM_TOP, null);
		frame.addKeyListener(new PakListener(env.getPlayer(), frame.getSimulator(), config));
		
		window = new PakCustomWindow("Pak Window", frame, config);
		window.updateRules();
		window.updateScore(0);
		frame.addFrame(window);
		
		thread = new PakThreading(frame);
		thread.run();
	}
	
	/**
	 * Stops the game and releases different ressources.
	 */
	public void stop() {
		thread.stop();
		frame.dispose();
	}
}
