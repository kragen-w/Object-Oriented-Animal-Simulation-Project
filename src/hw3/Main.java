package hw3;

public class Main {

	public static void main(String[] args) throws TerrainFileException{
		try {
			// Load in the map
			TerrainMap tm = new TerrainMap("map1.txt");
						
			// Make the display panel
			SimWindow window = new SimWindow(tm);
			
			
			
			// Start the simulation
			window.runSimulation();
		}
		catch(MalformedTerrainFileException M) {
			System.out.println(M);
		}catch(InvalidTerrainTypeException I) {
			System.out.println(I);
		
		}
	}

}
