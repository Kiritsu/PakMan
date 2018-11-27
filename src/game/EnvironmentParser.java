package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Arch;
import simbad.sim.BlockWorldObject;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class EnvironmentParser {
	public static HashMap<String, ArrayList<BlockWorldObject>> parseEnvironment(EnvironmentDescription env, String path) {		
		HashMap<String, ArrayList<BlockWorldObject>> objs = new HashMap<>();
		
		try {
			File file = new File(path); 
			  
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			  
			String st; 
			while ((st = br.readLine()) != null) {
				String[] vals = st.split(" ");
				
				if (vals[0].equals("W")) {
					objs.putIfAbsent("Walls", new ArrayList<BlockWorldObject>());
					
					if (vals.length != 7) {
						continue;
					}
					
					Wall temp = new Wall(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), Integer.parseInt(vals[4]), Integer.parseInt(vals[5]), env);
					if (vals[6].equals("1")) {
						temp.rotate90(1);
					}
					
					objs.get("Walls").add(temp);
				} else if (vals[0].equals("A")) {
					objs.putIfAbsent("Arch", new ArrayList<BlockWorldObject>());
					
					if (vals.length != 5) {
						continue;
					}
					
					Arch temp = new Arch(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), env);
					if (vals[4].equals("1")) {
						temp.rotate90(1);
					}
					
					objs.get("Arch").add(temp);
				} else if (vals[0].equals("B")) {
					objs.putIfAbsent("Box", new ArrayList<BlockWorldObject>());
					
					if (vals.length != 8) {
						continue;
					}
					
					Box temp = new Box(new Vector3d(Double.valueOf(vals[1]), Double.valueOf(vals[2]), Double.valueOf(vals[3])), new Vector3f(Float.valueOf(vals[4]), Float.valueOf(vals[5]), Float.valueOf(vals[6])), env);
					if (vals[7].equals("1")) {
						temp.rotate90(1);
					}
					
					objs.get("Box").add(temp);
				}
			} 
			
			br.close();
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
		
		return objs;
	}
}
