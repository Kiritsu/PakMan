package game;

import simbad.gui.Simbad;

public class PakThreading implements Runnable {
	private Simbad instance;
	private boolean running;
	
	public PakThreading(Simbad instance) {
		this.instance = instance;
	}
	
	@Override
	public void run() {
		this.running = true;
		
		while (running) {
			instance.requestFocus();
			
			try {
				Thread.sleep(250);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		this.running = false;
	}
}
