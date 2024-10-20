package hw3;

import edu.du.dudraw.Draw;

public class WaterTile extends TerrainTile {
	public int vegetation;
	protected WaterTile (GridPoint location) {
		super(location);
	}
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(0, 100, 255);
	}
		
	public void lowerVeg() {
		vegetation -= 0;
	}
	public int getWet() {
		return 1;
	}
		
	
}
