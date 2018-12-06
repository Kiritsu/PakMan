package game;

public class PakMan {
	public static void main(String[] args) {
		//hardcoded level 1:
        String path = "./levels/1.txt";
        
        if (args.length > 0) {
            path = args[0];
        }
        
		PakLevel level = new PakLevel(path);
		level.start();
	}
}
