package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class PakConfiguration {
	private HashMap<String, HashMap<String, String>> rawFile;
	
	private HashMap<String, String> texts;
	private Keys keys;
	private int level;
	
	public PakConfiguration() {
		texts = new HashMap<String, String>();
		rawFile = new HashMap<String, HashMap<String, String>>();
		keys = new Keys();
	}
	
	/**
	 * Parses the configuration and update the different class attributes.
	 * @param path
	 * @throws Exception 
	 */
	public void parseAll(String path) throws Exception {
		boolean block = parseTexts(path);
		if (!block) {
			throw new Exception("Erreur during parse.");
		}
		applyKeys();
		applyTexts();
		applyLevel();
	}
	
	/**
	 * Parses our ini configuration file.
	 * @param path of the configuration file.
	 */
	public boolean parseTexts(String path) {
		try {
			File file = new File(path); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			  
			String st; 
			String element = "";
			while ((st = br.readLine()) != null) {
				System.out.println(st);
				if (st.startsWith("[") && st.endsWith("]")) {
					element = st.replace("[", "").replace("]", "");
					continue;
				}

				if (element.equals("")) {
					continue;
				}
				
				rawFile.putIfAbsent(element, new HashMap<String, String>());
				
				String[] kvp = st.split("\\=");
				if (kvp.length != 2) {
					continue;
				}
				
				rawFile.get(element).putIfAbsent(kvp[0], kvp[1]);
			}	
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Updates our Keys class with the keys from the configuration.
	 */
	public void applyKeys() {
		HashMap<String, String> keys = rawFile.get("KEYS");
		
		this.keys.setStart(keys.get("start").charAt(0));
		this.keys.setLeft(keys.get("left").charAt(0));
		this.keys.setRight(keys.get("right").charAt(0));
		this.keys.setUp(keys.get("up").charAt(0));
		this.keys.setDown(keys.get("down").charAt(0));
	}
	
	/**
	 * Updates our texts attribute with the TEXTS values of our configuration file.
	 */
	public void applyTexts() {
		texts = rawFile.get("TEXTS");
	}
	
	/**
	 * Sets the level on which we must start.
	 */
	public void applyLevel() {
		HashMap<String, String> levelConfig = rawFile.get("GAME_CONFIG");
		this.level = Integer.valueOf(levelConfig.get("level"));
	}

	public int getLevel() {
		return this.level;
	}

	public Keys getKeys() {
		return this.keys;
	}
	
	/**
	 * Returns a string associated with the given key.
	 */
	public String getTextByKey(String key) {
		return texts.get(key);
	}
	
	public class Keys {
		private char start;
		private char left;
		private char right;
		private char up;
		private char down;
		
		public Keys() {
			this.start = ' ';
			this.left = 'q';
			this.right = 'd';
			this.up = 'z';
			this.down = 'd';
		}
		
		public char getStart() {
			return start;
		}
		
		public void setStart(char start) {
			this.start = start;
		}

		public char getLeft() {
			return left;
		}
		
		public void setLeft(char left) {
			this.left = left;
		}

		public char getRight() {
			return right;
		}
		
		public void setRight(char right) {
			this.right = right;
		}
		
		public char getUp() {
			return up;
		}
		
		public void setUp(char up) {
			this.up = up;
		}

		public char getDown() {
			return down;
		}
		
		public void setDown(char down) {
			this.down = down;
		}
	}
}
