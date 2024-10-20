package hw3;

import edu.du.dudraw.Draw;

public abstract class VegetationAvatar extends Avatar{
	public VegetationAvatar(TerrainMap map, GridPoint location) {
		super(map, location);
	}
	public void lowerVeg(){
		theMap.theTiles.get(theMap.getGridPoint(location)).lowerVeg();
		
	}
	public abstract void draw(Draw duDwin);
	public abstract void move();
}
