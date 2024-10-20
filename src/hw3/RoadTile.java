package hw3;

import edu.du.dudraw.Draw;

public class RoadTile extends TerrainTile{
	public int vegetation;
	protected RoadTile (GridPoint location) {
		super(location);
	}
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(255, 255, 0);
	}
	public void lowerVeg() {
		vegetation -= 0;
	}	
		
	
}

