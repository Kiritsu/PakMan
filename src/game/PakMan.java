package game;

public class PakMan {
	public static void main(String[] args) {
		PakConfiguration config = new PakConfiguration();
		config.parseAll(System.getProperty("java.class.path").split(";")[0] + "/levels/config.ini");
		
		PakLevel level = new PakLevel(config, config.getLevel());
		level.start();
	}
}