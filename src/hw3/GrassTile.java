
package hw3;

import edu.du.dudraw.Draw;

public class GrassTile extends TerrainTile{
	public int vegetation;
	protected GrassTile (GridPoint location) {
		super(location);
		this.vegetation = 50;
	}
	public void setColor(Draw duDwin) {
		int G = 100-vegetation;
		duDwin.setPenColor(0, G, 0);
	}
	public void lowerVeg() {
		if (vegetation >= 0) {
			vegetation = 1;
		}
	}
	
	public void raiseVeg() {
		if (vegetation <= 50) {
			vegetation += 10;
		}
		if (vegetation > 50) {
			vegetation = 50;
		}
		}
	
	public int getVeg() {
		return vegetation;
	}
		

		
	
}

