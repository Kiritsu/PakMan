package game;

public class PakMan {
	public static void main(String[] args) throws Exception {
		String path = "./levels/config.ini";
		
		if (args.length > 0 && args[0].equals("--from-script")) {
			path = "../bin/levels/config.ini";
		}
		
		PakConfiguration config = new PakConfiguration();
		config.parseAll(path);
		
		PakLevel level = new PakLevel(config, config.getLevel());
		level.start(args.length > 0 && args[0].equals("--from-script"));
	}
}