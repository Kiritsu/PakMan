package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Arch;
import simbad.sim.Box;
import simbad.sim.CherryAgent;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class PakEnvironmentParser {
	/**
	 * Parses the given file to detect different WorldBlock entities and robots.
	 * @param env Defines the environment we are working on.
	 * @param path Path of the file to parse.
	 * @return HashMap containing every different object parsed.
	 */
	public static HashMap<String, ArrayList<Object>> parseEnvironment(EnvironmentDescription env, String path) {		
		HashMap<String, ArrayList<Object>> objs = new HashMap<>();
		
		try {
			File file = new File(path); 
			  
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			  
			String st; 
			while ((st = br.readLine()) != null) {
				String[] vals = st.split(" ");
				
				if (vals.length == 0 || vals.length == 1 || vals[0].startsWith("//")) {
					continue;
				}
				
				//W for Walls, A for Archs, B for Boxes, PAK for the player object, GHOST for the ennemies.
				if (vals[0].equals("W")) {
					objs.putIfAbsent("Walls", new ArrayList<Object>());
					
					if (vals.length != 7) {
						continue;
					}
					
					Wall temp = new Wall(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), Integer.parseInt(vals[4]), Integer.parseInt(vals[5]), env);
					if (vals[6].equals("1")) {
						temp.rotate90(1);
					}
					
					objs.get("Walls").add(temp);
				} else if (vals[0].equals("A")) {
					objs.putIfAbsent("Arch", new ArrayList<Object>());
					
					if (vals.length != 5) {
						continue;
					}
					
					Arch temp = new Arch(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), env);
					if (vals[4].equals("1")) {
						temp.rotate90(1);
					}
					
					objs.get("Arch").add(temp);
				} else if (vals[0].equals("B")) {
					objs.putIfAbsent("Box", new ArrayList<Object>());
					
					if (vals.length != 8) {
						continue;
					}
					
					Box temp = new Box(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), new Vector3f(Float.valueOf(vals[4]), Float.valueOf(vals[5]), Float.valueOf(vals[6])), env);
					if (vals[7].equals("1")) {
						temp.rotate90(1);
					}
					
					objs.get("Box").add(temp);
				} else if (vals[0].equals("PAK")) {
					objs.putIfAbsent("Player", new ArrayList<Object>());
					
					if (vals.length != 4) {
						continue;
					}
					
					objs.get("Player").add(new PakRobot(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), "Pak Istan"));
				} else if (vals[0].equals("GHOST")) {
					objs.putIfAbsent("Ghost", new ArrayList<Object>());
					
					if (vals.length != 5) {
						continue;
					}
					
					objs.get("Ghost").add(new PakGhostRobot(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), "Pak Istan", Double.valueOf(vals[4])));
				} else if(vals[0].equals("P")) {
					objs.putIfAbsent("Point", new ArrayList<Object>());
					
					if (vals.length != 5){
						continue;		
					}
					
					float pts = 0.15f;
					Color3f color = new Color3f(0, 255, 255);
					
					if (vals[4].equals("1"))
					{
						pts = 0.25f;
					}
					
					objs.get("Point").add(new CherryAgent(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), "Point", pts, color));
				}
			} 
			
			br.close();
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
		
		return objs;
	}
}
