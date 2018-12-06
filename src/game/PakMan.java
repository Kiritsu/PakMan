package game;

public class PakMan {
	public static void main(String[] args) {
		//hardcoded level 1:
		PakLevel level = new PakLevel(args[0]);
		level.start();
	}
}
