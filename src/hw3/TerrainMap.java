package hw3;
import java.util.HashMap;
import java.util.Set;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import edu.du.dudraw.Draw;


// The TerrainMap represents a 2D grid of Tiles

public class TerrainMap implements Drawable {

	public HashMap<GridPoint, TerrainTile> theTiles;
	
	// public static constants set in the constructor.
	public static int gridWidth;
	public static int gridHeight;

	// Constructor to read from file
	public TerrainMap(String filename) throws TerrainFileException{
		this.theTiles = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			
            String line;
            int rowCounter = 0;
            while ((line = br.readLine()) != null) {
            	
                String[] firstLine = line.split(" ");
                
                 if(firstLine.length == 2) {
            		try {
            			this.gridWidth = Integer.valueOf(firstLine[0]);
            			this.gridHeight = Integer.valueOf(firstLine[1]);
            			if (rowCounter == 0) {
            				rowCounter = gridHeight - 1;
            			}
            			continue;
            		}
            		catch (NumberFormatException e) {
            			throw new MalformedTerrainFileException("The map is malformed");
            		}
        		}  

                int columnCounter = 0;
            	String[] value = line.split(" ");
            	for (String letter: value) {
            		GridPoint location = new GridPoint(columnCounter,rowCounter);
            		TerrainTile tile = TerrainTileFactory.newTerrainTile(letter, location);
            		theTiles.put(location, tile);
    	
            		columnCounter += 1;

            	}
            	
                rowCounter -= 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void draw(Draw duDwin) {
		
		for (GridPoint key : theTiles.keySet()) {
			theTiles.get(key).draw(duDwin);
			
		}
	}
	
	public GridPoint getGridPoint(GridPoint gp) {
		Set<GridPoint> keySet = theTiles.keySet();
		
		for (GridPoint gridpoint:keySet) {
			if (gridpoint.equals(gp)) {
				return gridpoint;
			}
		}
		return null;
		
	}
	
	public void regrow() {
		
		
		for (TerrainTile t: theTiles.values()) {
			if (t.getVeg() > 0) {
				t.raiseVeg();
			}
		}
	}
	
	public int getWet(GridPoint gp) {
		return theTiles.get(getGridPoint(gp)).getWet();
	}
	public int getVeg(GridPoint gp) {
		return theTiles.get(getGridPoint(gp)).getVeg();
	}
	public int getBumpy(GridPoint gp) {
		return theTiles.get(getGridPoint(gp)).getBumpy();
	}

}
