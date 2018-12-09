package game;

public class PakMan {
	public static void main(String[] args) {
		PakConfiguration config = new PakConfiguration();
		config.parseAll("./levels/config.ini");
		
		PakLevel level = new PakLevel(config, config.getLevel());
		level.start();
	}
}