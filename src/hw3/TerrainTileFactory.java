package hw3;

public class TerrainTileFactory {

	public static TerrainTile newTerrainTile(String tileStr, GridPoint loc) throws InvalidTerrainTypeException{
		TerrainTile tile = null;
		if (tileStr.equals("g")){
			tile = new GrassTile(loc);
		}
		
		else if (tileStr.equals("w")){
			tile = new WaterTile(loc);
		}
		
		else if (tileStr.equals("r")){
			tile = new RoadTile(loc);
		}
		
		else if (tileStr.equals("m")){
			tile = new MountainTile(loc);
		}
		
		else {
			throw new InvalidTerrainTypeException("Terrain is invalid");
		}
		return tile;
	}
}
